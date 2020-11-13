package com.ttq.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class User {//登录成功 1.购物 2.查看商品列表 3.查看自己已买商品列表
	String name;
	String password;
	double balance;
	Date createTime;
	//已买商品列表（底层透明：内存空间对程序没有影响，支队程序运行效率有影响）
	LinkedList<Good> goodList = new LinkedList<Good>();

	{
		this.createTime = new Date();
		this.balance = 0.0;
		addGood();
	}

	public void addGood() {
		Good good = new Good("苹果", 13.5, 6, "未购买");
		Good good1 = new Good("橘子", 6.9, 7, "未购买");
		Good good2 = new Good("香蕉", 3.5, 32, "未购买");
		Good good3 = new Good("西瓜", 13.4, 6, "未购买");
		Good good4 = new Good("蔬菜", 0.88, 3, "未购买");
		goodList.add(good);
		goodList.add(good1);
		goodList.add(good2);
		goodList.add(good3);
		goodList.add(good4);
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String screate = simpleDateFormat.format(this.createTime);
		return name + "\t" + password + "\t" + balance + "\t" + screate;
	}

}
