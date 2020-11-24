package com.ttq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ttq.dao.StopDao;
import com.ttq.entity.Car;
import com.ttq.entity.Stop;
import com.ttq.util.JDBCUtil;

public class StopDaoImpl implements StopDao {

	@Override
	public List<Car> selectCarNotStop(int uid) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtil.getConnection();
		String sql = "select distinct c.* from tb_car c left join tb_stop s on c.cid=s.cid where uid =? and (tid is null or endTime is not null)";
		//select c.* from tb_car c left join tb_stop s on c.cid=s.cid where uid =1 and (tid is null or entTime is not null)
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, uid);
			set = statement.executeQuery();
			List<Car> carList = new ArrayList<Car>();
			while (set.next()) {
				Car car = new Car(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4));
				carList.add(car);
			}
			return carList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, statement, set);
		}

		return null;
	}

	@Override
	public boolean insertStop(Stop stop) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtil.getConnection();
		String sql = "insert into tb_stop(cid,beginTime,loc) values(?,now(),?)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, stop.getCid());
			statement.setString(2, stop.getLoc());
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, statement, null);
		}

		return false;
	}

	@Override
	public boolean updateStopByEndTimeAndHourAndMoney(int cid, Date endTime, int hours, double money) {
		// TODO Auto-generated method stub
		//数据库的当前时间now（）
		//正在停车位上的车离开
		Connection connection = JDBCUtil.getConnection();
		String sql = "update tb_stop set endTime=now(),hours=?,money=? where cid=? and endTime is null";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);

			statement.setInt(1, hours);
			statement.setDouble(2, money);
			statement.setInt(3, cid);
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, statement, null);
		}

		return false;
	}

	@Override
	public Stop selectByCidAndEndTimeIsNull(int cid) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtil.getConnection();
		String sql = "select * from tb_stop where cid=? and endTime is null";
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cid);
			set = statement.executeQuery();
			if (set.next()) {
				return new Stop(set.getInt(1), set.getInt(2), set.getTimestamp(3), set.getTimestamp(4), set.getInt(5),
						set.getDouble(6), set.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, statement, null);
		}

		return null;
	}

	@Override
	public List<Stop> selectOrderList(int cid) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtil.getConnection();
		String sql = "select * from tb_stop where cid=? and endTime is not null";
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cid);
			set = statement.executeQuery();
			List<Stop> stopList = new ArrayList<Stop>();
			while (set.next()) {
				Stop stop = new Stop(set.getInt(1), set.getInt(2), set.getTimestamp(3), set.getTimestamp(4),
						set.getInt(5), set.getDouble(6), set.getString(7));
				stopList.add(stop);
			}
			return stopList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Car> selectCarByUid(int uid) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtil.getConnection();
		String sql = "select * from tb_car where uid =?";
		//select c.* from tb_car c left join tb_stop s on c.cid=s.cid where uid =1 and (tid is null or entTime is not null)
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, uid);
			set = statement.executeQuery();
			List<Car> carList = new ArrayList<Car>();
			while (set.next()) {
				Car car = new Car(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4));
				carList.add(car);
			}
			return carList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, statement, set);
		}

		return null;
	}

}
