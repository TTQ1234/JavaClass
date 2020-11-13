package com.ttq.UserService;

import java.util.Scanner;

public class UserServiceImp1 implements UserService {
	private User[] userList = new User[100];
	int count = 0;

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		if (count >= userList.length) {
			System.out.println("存储已满");
			return;
		}
		userList[count++] = user;
	}

	@Override
	public User login(String name, String password) {
		// TODO Auto-generated method stub
		for (int i = 0; i < userList.length; i++) {
			if (userList[i].getName().equals(name) && userList[i].getPassword().equals(password)) {
				System.out.println("登录成功");
				return userList[i];
			}
		}
		return null;
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		System.out.println("用户名\t密码\t余额\t注册时间");
		for (int i = 0; i < count; i++) {
			System.out.println(userList[i].toString());
		}
	}

	@Override
	public void selectShow(User user) {
		// TODO Auto-generated method stub
		System.out.println("用户名\t密码\t余额\t注册时间");
		System.out.println(user.toString());
	}

	@Override
	public void editBalance(Scanner scanner, User user) {
		// TODO Auto-generated method stub
		double balance = user.getBalance();
		System.out.println("当前余额" + balance);
		System.out.println("请输入要修改的余额");
		balance = Double.parseDouble(scanner.nextLine().trim());
		user.setBalance(balance);
		System.out.println("修改余额成功");
	}

}
