package com.ttq.abstracts;

abstract class Person {//有抽象方法的类必须是抽象类，不能实例化对象，也就不能调用该抽象方法
	public abstract void eat();

	public Person() {//给子类实例化对象用
		super();
		// TODO Auto-generated constructor stub
	}

}

class SouthPerson extends Person {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("喜欢吃米饭");
	}

}

class NorthPerson extends Person {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("喜欢吃面条");
	}

}

public class Client {
	public static void main(String[] args) {
		//Person p1 = new Person();
		Person p1 = new NorthPerson();
		Person p2 = new SouthPerson();

		//继承是把双刃剑，好处 子类继承父类的一切 缺点 耦合度高
		//依赖于抽象（抽象类） 不要依赖于具体 一班父类都是抽象，解耦
	}
}
