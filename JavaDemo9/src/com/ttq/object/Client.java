package com.ttq.object;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class Person {
	private String nameString;
	private int age;

	public Person(String name, int age) {
		super();
		this.nameString = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
		//hash算法可能会发生冲突，一个位置上可能存多个数组元素
		//s110 s230 s311 s421 s522 s616 s714 s832 s967 数组长度为5
		//哈希算法：年龄%数组的长度=对象存放在数组中的位置
		//减少equals方法
		//hashcode 只要值不想等，肯定equals不相等，如果hashcode值相等，就进一步比较属性
	}

}

public class Client {
	public static void main(String[] args) {
		Person p1 = new Person("张三", 12);
		Person p2 = new Person("张三", 12);
		//Person 是不是Object的子类？ 是，任何类都是Object的子类，可以直接object的方法
		boolean flag = p1.equals(p2);
		//equals() 默认和 == 一个意思，所以不想等
		//		public boolean equals(Object obj) {
		//	        return (this == obj);==比较的是对象的地址
		//	    	}

		String s1 = new String();
		String s2 = new String();
		System.out.println(s1 == s2);//false
		System.out.println(s1.equals(s2));//true
		//证明：String子类重写了equals（）方法，不然肯定继承Object，所以重写了就是true

	}
}
