package com.ttq.demo;

public class Student {
	private String nameString;
	//只要你执行方法，就会直接代码块
	{
		System.out.println("构造代码块");
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("调用无参构造");

	}

	public Student(String nameString) {
		super();
		this.nameString = nameString;
		System.out.println("调用有参构造");
	}

}
