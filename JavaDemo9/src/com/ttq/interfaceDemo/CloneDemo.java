package com.ttq.interfaceDemo;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
class Student implements Cloneable {//该类对象才允许克隆，Cloneable标示
	String name = "zs";
	int age = 20;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}

public class CloneDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		Student s1 = new Student();
		Student cloneS1 = (Student) s1.clone();
		System.out.println(s1 == cloneS1);
		System.out.println(s1.equals(cloneS1));
		System.out.println(s1);
		System.out.println(cloneS1);
		cloneS1.age = 10;
		//si.age?20
	}
}
