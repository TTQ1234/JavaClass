package com.ttq.test;

import org.junit.Test;

import com.ttq.dao.UserDao;
import com.ttq.dao.Impl.UserDaoImpl;
import com.ttq.entity.User;

public class UserTest {
	private UserDao dao = new UserDaoImpl();

	@Test
	public void test1() {
		System.out.println(dao.insertUser(new User(null, "ttq", "123")));
	}
}
