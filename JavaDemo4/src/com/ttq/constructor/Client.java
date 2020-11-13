package com.ttq.constructor;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//实例化一个Person对象
		//实例化对象一定会调用构造方法
		Person p1 = new Person();
		p1.name = "csy";

		Person p2 = new Person("ttq");
		System.out.println(p2.name);

		Person p3 = new Person("feng", 6);
		System.out.println(p3.name + p3.age);
	}

}
