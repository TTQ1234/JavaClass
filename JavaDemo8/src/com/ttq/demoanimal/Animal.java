package com.ttq.demoanimal;

public class Animal {
	public String name = "动物";

	public void show() {
		System.out.println("父亲");
	}

	public static void main(String[] args) {
		Animal cat = new Cat();
		System.out.println(cat.name);
		cat.show();
		((Cat) cat).hello();//父亲没有孩子的方法，编译不通过，转成真实的对象，向下转型

		Cat cat1 = (Cat) cat;
		Animal dog = new Dog();
		((Cat) dog).hello();//(编译正常，运行不正确，类型转换异常，java.lang.ClassCastException)
		if (dog instanceof Dog) {//判断该对象是否为此类型
			((Cat) dog).hello();
		}
	}
}

class Cat extends Animal {
	public String name = "猫";

	public void show() {
		System.out.println("猫");
	}

	public void hello() {
		System.out.println("hello");
	}
}

class Dog extends Animal {
	public String name = "狗";

	public void show() {
		System.out.println("狗");
	}
}

class Hello {
	public void show(Animal a) {//多态
		a.show();//真是对象的方法，多态 如果是猫，执行的就是猫，狗执行的就是狗
	}

	public void method() {
		Cat cat = new Cat();
		show(cat);
	}
}
