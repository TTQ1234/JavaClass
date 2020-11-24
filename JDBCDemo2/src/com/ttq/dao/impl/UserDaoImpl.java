package com.ttq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ttq.dao.UserDao;
import com.ttq.entity.User;
import com.ttq.util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User selectByUsername(String username) {
		// TODO Auto-generated method stub
		//1创建连接
		Connection connection = JDBCUtil.getConnection();
		//2编写Sql
		String sql = "select * from tb_user where uname=?";//占位符代替字符串拼接
		//3Statement
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			statement = connection.prepareStatement(sql);//获得预编译对象
			//绑定参数 ? 绑定至 set*** 第几个？ 值是什么
			statement.setString(1, username);
			//4执行 excuteQuery();
			set = statement.executeQuery();//唯一的
			if (set.next()) {
				User user = new User(set.getInt(1), set.getString(2), set.getString(3));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, statement, set);
		}
		return null;
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		//1创建连接
		Connection connection = JDBCUtil.getConnection();
		//2sql
		String sql = "insert into tb_user values(null,?,?)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUname());
			statement.setString(2, user.getPassword());
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
	public User selectByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		//1创建连接
		Connection connection = JDBCUtil.getConnection();
		//2编写Sql
		String sql = "select * from tb_user where uname=? and password=?";//占位符代替字符串拼接
		//3Statement
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			statement = connection.prepareStatement(sql);//获得预编译对象
			//绑定参数 ? 绑定至 set*** 第几个？ 值是什么
			statement.setString(1, username);
			statement.setString(2, password);
			//4执行 excuteQuery();
			set = statement.executeQuery();//唯一的
			if (set.next()) {
				User user = new User(set.getInt(1), set.getString(2), set.getString(3));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, statement, set);
		}
		return null;
	}

}
