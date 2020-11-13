package com.ttq.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@Setter
@Getter
public class User {
	private String username;
	private String password;
	private double balance;
	private Date open;
	//已买商品列表(底层透明:内存空间对程序没有影响,只对程序运行效率有影响)
	private ArrayList<Good> goodList = new ArrayList<>();
	{
		open = new Date();
	}

	@Override
	public String toString() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String openString = format1.format(open);
		return username + "\t" + password + "\t" + balance + "\t" + openString;
	}

	public User(String username, String password, double balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

}
