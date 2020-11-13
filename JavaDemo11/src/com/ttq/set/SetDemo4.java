package com.ttq.set;

import java.util.HashSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@EqualsAndHashCode
class Person {
	private String name;
	private int age;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

public class SetDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Person> set = new HashSet<Person>();
		set.add(new Person("张三", 10));
		set.add(new Person("张三", 10));
		set.add(new Person("张三", 10));
		set.add(new Person("张三", 20));
		System.out.println(set.size());
		//原来是4，重写equals后变成1
		//注册：姓名相同，年龄不同，认为是两个对象吗？（姓名不重复）
		//重写hashcodeandequals 只选择name
	}

}
