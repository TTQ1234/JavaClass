package com.ttq.set;

import java.util.TreeSet;

/**
 * 排序
 * 		TreeSet
 * */
public class SetDemo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//二叉排序树（红黑树）
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(1);
		set.add(11);
		set.add(31);
		set.add(44);
		set.add(2);
		set.add(8);
		set.forEach(e -> System.out.println(e));
	}

}
