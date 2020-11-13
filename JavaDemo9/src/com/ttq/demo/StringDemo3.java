package com.ttq.demo;

import java.util.UUID;

public class StringDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();//随机一个id的对象
		String sid = uuid.toString();//随机字符串
		sid = sid.replace("-", "");
		System.out.println(sid);//验证吗id里面不会有-
		//6位验证码 割字串 subString(start,end) 前包后不包
		String code = sid.substring(2, 8);
		System.out.println(code);
	}

}
