package com.ttq.set;

import java.util.HashSet;

public class SetDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(1);
		set.add(1);
		set.add(1);
		System.out.println(set.size());
		set.forEach(e -> System.out.println(e));//重复的不会加进去
	}

}
