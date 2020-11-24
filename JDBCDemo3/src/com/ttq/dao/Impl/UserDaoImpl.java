package com.ttq.dao.Impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ttq.dao.UserDao;
import com.ttq.entity.User;
import com.ttq.util.JDBCUtil;

public class UserDaoImpl implements UserDao {
	//创建模板对象 (数据库连接池)
	private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

	@Override
	public User selectByUsername(String username) {
		String sql = "select *  from  tb_user  where  uname=?";
		// ORM模型 -> Object   R 表    mapping   对象和表之间的映射  表的一行变成一个实体对象
		// 反射机制  ->字节码获得管理对象  无参构造 new 对象
		// 反射   Class.forName()   类名.class   对象.getClass()  
		List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class), username);
		if (userList == null || userList.size() == 0) {
			return null;//没有查到
		}
		return userList.get(0);//集合里面只有 一个用户对象,获取
	}

	@Override
	public boolean insertUser(User user) {
		String sql = "insert into tb_user values(null,?,?) ";
		//添加,删除,插入 update
		int count = template.update(sql, user.getUname(), user.getPassword());

		return count > 0 ? true : false;
	}

	@Override
	public User selectByUsernameAndPassword(String username, String password) {
		String sql = "select *  from tb_user where uname=? and password=?";
		List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class), username, password); //不要忘记参数绑定

		if (userList == null || userList.size() == 0) {
			return null;//登录不成功
		}
		return userList.get(0);
	}

}
