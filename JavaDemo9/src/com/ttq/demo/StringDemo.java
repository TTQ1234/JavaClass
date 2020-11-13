package com.ttq.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class User {
	private String namException;
	private int age;
	private String sexString;
}

public class StringDemo {
	public static void main(String[] args) {
		//用户数组
		User[] userList = new User[100];
		int count = 0;
		//前段字符串
		String users = "张三-12-女；李四-20-男；王五-24-男；阿蒙-23-男";
		//分割字符串，变成User对象存到User数组里面
		String[] userStrings = users.split(";");
		for (String user : userStrings) {//增强for循环
			String[] nameAndAgeAndSex = user.split("-");
			User user2 = new User(nameAndAgeAndSex[0], Integer.parseInt(nameAndAgeAndSex[1]), nameAndAgeAndSex[2]);
			userList[count++] = user2;
		}
	}
}
