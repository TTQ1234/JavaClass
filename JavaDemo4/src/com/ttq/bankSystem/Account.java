package com.ttq.bankSystem;

import java.util.Date;

public class Account {
	long id;
	String password;
	double money;
	String name;
	Date time;

	public void showInfo() {
		System.out.println("账户id：" + id + ",密码：" + password + ",余额：" + money + "元,开户姓名：" + name + ",开户时间额：" + time);

	}

	//存钱
	public void saveMoney(double money) {
		this.money += money;
		System.out.println("存钱成功");
	}

	//取钱
	public void withdrawMoney(double money) {
		if (money > this.money) {
			System.out.println("余额不足");
			return;
		}
		this.money -= money;
		System.out.println("取钱成功");
	}
}
