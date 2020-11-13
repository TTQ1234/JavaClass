package com.ttq.set;

import java.util.HashSet;
import java.util.Random;

public class SetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		//不重复
		HashSet<Integer> set = new HashSet<Integer>();
		while (set.size() < 5) {
			int num = random.nextInt(100) + 1;
			set.add(num);
		}
		set.forEach(e -> System.out.println(e));
	}

}
