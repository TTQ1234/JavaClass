package com.ttq.exercise1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreditAccount extends Account {
	private double ceiling = 10000;

	//给自己透支额度属性赋值，然后调用父亲构造给继承的属性赋值
	public CreditAccount(String password, String name, double ceiling) {
		super(password, name);//继承的父亲和属性，用父亲的构造方法赋值
		this.ceiling = ceiling;//自己的属性自己赋值
	}

	//取款方法
	public void withdraw(double money) {
		if (money <= 0) {
			System.out.println("金额不正确");
			return;
		}
		if (money > this.getBalance() + ceiling) {
			System.out.println("金额不足");
			return;
		}
		if (money < this.getBalance()) {
			this.setBalance(this.getBalance() - money);
			System.out.println("取款成功");
			return;
		}
		this.ceiling -= (money - this.getBalance());
		this.setBalance(0);
	}

}
