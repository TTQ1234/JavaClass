package com.ttq.animal;

public class Animal {
	//属性和方法公开
	public String name;
	public int age;

	static {
		System.out.println("父亲的静态代码块");
	}
	{
		System.out.println("父亲的构造代码块");
	}

	public Animal() {
		// TODO Auto-generated constructor stub
		System.out.println("父亲的构造方法");
	}

	public void eat() {
		System.out.println("在吃饭");

	}

	public void sleep() {
		System.out.println("在睡觉");
	}

}
