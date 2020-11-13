package com.ttq.list;

import java.util.ArrayList;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);//隐藏装箱 1是基本数据-> 包装类 list.add(Integer.valuesof(1))
		list.add(2);//隐藏装箱 1是基本数据-> 包装类 list.add(Integer.valuesof(1))
		list.add(3);//隐藏装箱 1是基本数据-> 包装类 list.add(Integer.valuesof(1))
		list.add(4);//隐藏装箱 1是基本数据-> 包装类 list.add(Integer.valuesof(1))
		list.add(5);//隐藏装箱 1是基本数据-> 包装类 list.add(Integer.valuesof(1))
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		//删除 按照位置 按照值
		list.remove(2);//删除位置
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		list.remove(Integer.valueOf(2));//删除值
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
