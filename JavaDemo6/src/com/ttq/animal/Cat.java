package com.ttq.animal;

public class Cat extends Animal {
	static {
		System.out.println("孩子的静态代码块");
	}
	{
		System.out.println("孩子的构造代码块");
	}

	public Cat() {
		super();//如果没有，JVM会添加，调用父亲的构造方法
		System.out.println("孩子的构造方法");
	}

}
