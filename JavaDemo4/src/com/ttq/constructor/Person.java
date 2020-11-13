package com.ttq.constructor;

/**
 * 本类用来演示
 * 
 * 构造方法：与类同名，实例化对象的时候调用
 * 作者: easonsy
 * 日期:	2020年10月13日 下午3:35:12
 */
public class Person {
	//姓名
	String name;
	//年龄
	int age;

	public Person() {

		// TODO Auto-generated constructor stub
		System.out.println("我出生了");
	}

	public Person(String name) {
		this.name = name;
		System.out.println("我出生了");
	}

	//有参构造，要求给姓名和年龄都赋值
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("我有名字和年龄了");
	}

}
