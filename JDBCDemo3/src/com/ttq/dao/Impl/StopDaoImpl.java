package com.ttq.dao.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ttq.dao.StopDao;
import com.ttq.entity.Car;
import com.ttq.entity.Stop;
import com.ttq.util.JDBCUtil;

public class StopDaoImpl implements StopDao {

	private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

	@Override
	public List<Car> selectCarNotStop(int uid) {
		// TODO Auto-generated method stub
		//System.out.println(uid);
		String sql = "select distinct c.*  from  tb_car  c left join tb_stop s on c.cid=s.cid where uid=?  and  (tid is null  or endTime is not null)   ";
		List<Car> carList = template.query(sql, new BeanPropertyRowMapper<Car>(Car.class), uid);
		return carList;
	}

	@Override
	public boolean insertStop(Stop stop) {
		// TODO Auto-generated method stub
		String sql = "insert into tb_stop values(null,?,now(),null,null,null,?)";
		return template.update(sql, stop.getCid(), stop.getLoc()) > 0 ? true : false;
	}

	@Override
	public boolean updateStopByEndTimeAndHourAndMoney(int cid, Date endTime, int hours, double money) {
		// TODO Auto-generated method stub
		String sql = "update tb_stop set endtime=now(),hours=?,money=? where cid=?";
		return template.update(sql, hours, money, cid) > 0 ? true : false;
	}

	@Override
	public Stop selectByCidAndEndTimeIsNull(int cid) {
		// TODO Auto-generated method stub
		String sql = "select *  from  tb_stop  where  cid=? and endTime is  null";
		List<Stop> stopList = template.query(sql, new BeanPropertyRowMapper<Stop>(Stop.class), cid);
		if (stopList == null || stopList.size() == 0) {
			return null;
		}
		return stopList.get(0);
	}

	@Override
	public List<Stop> selectOrderList(int cid) {
		// TODO Auto-generated method stub
		String sql = "select *  from  tb_stop  where  cid=?  ";
		List<Stop> stopList = template.query(sql, new BeanPropertyRowMapper<Stop>(Stop.class), cid);
		return stopList;
	}

	@Override
	public List<Car> selectCarByUid(int uid) {
		// TODO Auto-generated method stub
		String sql = "select * from  tb_car   where uid=? ";
		List<Car> carList = template.query(sql, new BeanPropertyRowMapper<Car>(Car.class), uid);
		return carList;
	}

}
