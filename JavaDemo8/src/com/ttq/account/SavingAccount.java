package com.ttq.account;

import lombok.NoArgsConstructor;

/**
 * 基本储蓄：方法直接继承
 * */
@NoArgsConstructor //需要传进两个参数
public class SavingAccount extends Account {
	//给父类的又惨构造赋值
	public SavingAccount(String password, String name) {
		super(password, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deposite(double money) {
		// TODO Auto-generated method stub
		if (money < 0) {
			System.out.println("存款金额不正确");
			return;
		}
		setBalance(getBalance() + money);
		System.out.println("存款成功");
	}

	@Override
	public void widthdraw(double money) {
		// TODO Auto-generated method stub

		if (money > getBalance()) {
			System.out.println("余额不足");
			return;
		}
		if (money < 0) {
			System.out.println("金额不正确");
			return;
		}
		setBalance(getBalance() - money);
		System.out.println("取款成功");
	}

}
