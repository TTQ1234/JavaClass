package com.ttq.demo;

//一般类的东西都是公开的
class Person {
	static {
		System.out.println("静态代码块");//类加载的时候执行静态代码块，只执行一次
	}
	{
		System.out.println("构造代码块");//实例化对象的时候执行，实例化几个对象就执行几次
	}

	static int age = 10;

	public static void add() {
		System.out.println("添加成功");
	}

	//静态方法可以调用非静态的属性和方法吗？ 不可以 类加载的时候对象的东西没有
	//非静态的方法可以调用静态的属性和方法码？ 可以
}

public class StaticDemo2 {
	public static void main(String[] args) {
		System.out.println(Person.age);

		Person p1 = new Person();
		System.out.println(p1.age);//这样也可以，但是不建议用对象名.**调用类成员或变量
		Person p2 = new Person();
		Person.add();
	}

}
