package com.ttq.set;

import java.util.ArrayList;
import java.util.HashSet;

public class SetDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(9);
		list.add(23);
		list.add(4);
		list.add(6);
		list.add(10);
		list.add(8);
		list.add(9);
		list.add(23);
		list.add(11);

		//set
		HashSet<Integer> set = new HashSet<Integer>();
		set.addAll(list);//去重
		list.clear();
		list.addAll(set);
		list.forEach(e -> System.out.println(e));

	}

}
