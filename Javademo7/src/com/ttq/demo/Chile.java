package com.ttq.demo;

public class Chile extends Base {

	public Chile() {
		super("李四", 123);
		//super();//不写，默认添加，调用父亲的构造方法实例化对象
		//无参构造,父亲实例化不成功，无法实例化子类
	}

	public void show() {
		setName("张三");
		setAge(10);
		System.out.println(getAge());
		System.out.println(getName());
	}

	public static void main(String[] args) {
		Chile child = new Chile();
		child.setName("张三");
		System.out.println(child.getName());
	}
}
