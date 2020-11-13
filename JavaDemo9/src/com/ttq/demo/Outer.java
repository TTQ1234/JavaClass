package com.ttq.demo;

public class Outer {
	private int age = 10;//普通属性
	private static int sage = 11;//静态属性

	public class Inner {//内部类，可以使用外部类的一切
		private int age = 30;

		public void show() {
			int age = 20;
			System.out.println(age);//自己的局部变量 20
			System.out.println(this.age);//自己的属性 30
			System.out.println(Outer.this.age);//外部类的属性 10
		}
	}

	//static 可以修饰属性，可以修饰代码块，可以修饰方法，可以修饰内部类
	public static class StaticInner {//静态的内部类只能调用静态的属性
		public void show1() {
			//System.out.println(age); 错误 age生命周期的问题
			System.out.println(sage);//静态的只能调用静态
		}
	}

	public static void main(String[] args) {
		//内部类实例化对象
		//普通内部类
		Outer.Inner inner = new Outer().new Inner();
		inner.show();
		//静态内部类
		Outer.StaticInner sInner = new Outer.StaticInner();
		sInner.show1();
	}
}
