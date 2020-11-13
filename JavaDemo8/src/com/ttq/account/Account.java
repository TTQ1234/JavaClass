package com.ttq.account;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 账户类
 * 
 * id自增长
 * */
@NoArgsConstructor
@Getter
@Setter
public abstract class Account {
	private long id;
	private String password;
	private String name;
	private double balance;
	private Date openDate;
	public static long sid = 10000;//类变量，所有对象共享

	//所有实例化对象都会调用
	{
		this.id = sid++;//前面账户对象获取sid值，然后+1，给后面对象用，保证id自增长
		this.openDate = new Date();//当前时间
		this.balance = 0.0;
	}

	//实例化对象只需奥密码和姓名
	public Account(String password, String name) {
		super();
		this.password = password;
		this.name = name;
	}

	//存钱
	//只需要定义我的孩子必须要存款方法，抽象了，孩子必须要重写我的抽象方法，约束
	public abstract void deposite(double money);//{//子类不许重写取款方法
	//		if (money < 0) {
	//			System.out.println("存款金额不正确");
	//			return;
	//		}
	//		this.balance += money;
	//		System.out.println("存款成功");
	//	}

	//取钱
	public abstract void widthdraw(double money);

	@Override //如果一个类有了toString（），那么输出对象的时候不在是地址，而是调用此方法。
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sopen = simpleDateFormat.format(this.openDate);
		return id + "\t" + password + "\t" + name + "\t" + balance + "\t" + sopen;
	}

}
