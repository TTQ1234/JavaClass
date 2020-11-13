package com.ttq.exercise1;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 本类用来演示
 * 
 * 写一个账户类(Account),属性:
 *  id:账户账号  用户的账号(id)是自动生成的,初始值为100000,第一个开户的用户id为100001,第二个为100002,依此类推.
 *  password:账户密码 
 *  name:真实姓名  
 *  open: 开户日期           
 *  balance:账户余额

 *  构造方法:
 *  有参和无参,有参构造方法用于设置必要的属性

 * 方法:
 *  deposit: 存款方法,参数是金额
 *  withdraw:取款方法,参数是金额
 * 
 * 作者: ttq
 * 日期:	2020年10月16日 上午11:42:50
 */

@NoArgsConstructor
@Getter
@Setter
public class Account {
	private long id;
	private String password;
	private String name;
	private Date opentime;
	private double balance;
	static long sid = 10000;
	{
		this.opentime = new Date();
		this.id = sid++;
		balance = 0.0;
	}

	public Account(String password, String name) {
		super();
		this.password = password;
		this.name = name;

	}

	public void deposit(double money) {
		if (money <= 0) {
			System.out.println("金额不正确");
			return;
		}
		this.balance += money;
		System.out.println("存款成功");
	}

	public void withdraw(double money) {
		if (money <= 0) {
			System.out.println("金额不正确");
			return;
		}
		if (money > this.balance) {
			System.out.println("金额不足");
			return;
		}
		this.balance -= money;
		System.out.println("取款成功");
	}

}
