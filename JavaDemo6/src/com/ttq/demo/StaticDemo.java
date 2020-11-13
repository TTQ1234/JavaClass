package com.ttq.demo;

public class StaticDemo {
	static int age = 10;//属性/成员变量/实例变量 实例化的时候

	public static void main(String[] args) {//类的
		age = 20;//生命周期的问题 但是有错误
	}
	//static和this冲突，this是本类对象，static是类的成员
}
