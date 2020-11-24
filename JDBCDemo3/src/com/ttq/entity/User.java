package com.ttq.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户表
 * */
@NoArgsConstructor
@AllArgsConstructor
@Data //setter  getter  equals  hashcode  toString这些方法
public class User {
	private Integer uid;
	private String uname;
	private String password;
	//一对多
	private List<Car> carList = new ArrayList<Car>();

	public User(Integer uid, String uname, String password) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
	}

}
