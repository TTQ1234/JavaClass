package com.ttq.demo;

interface Person {
	void show();
}

//class PersonImp1 implements Person {
//
//	@Override
//	public void show() {
//		// TODO Auto-generated method stub
//		System.out.println("hello");
//
//	}
//
//}

public class Hello {
	public static void main(String[] args) {

		//在很多时候，如果我们show（）只用一次，我们还要写一个实现类，麻烦

		Person p2 = new Person() {

			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("hello");

			}
		};
		p2.show();

		new Person() {

			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("aaa");
			}
		}.show();
	}
}
//只有一个抽象方法，