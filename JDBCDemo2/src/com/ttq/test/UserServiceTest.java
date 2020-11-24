package com.ttq.test;

import org.junit.Test;

import com.ttq.entity.User;
import com.ttq.service.UserService;
import com.ttq.service.impl.UserServiceImpl;

public class UserServiceTest {
	private UserService userService = new UserServiceImpl();

	@Test
	public void test1() {
		boolean f = userService.register(new User(null, "李四", "123"));
		System.out.println(f);
	}

	@Test //钓鱼网站
	public void test2() {
		User user = userService.login("张三", "123");
		System.out.println(user);
	}
}
