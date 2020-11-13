package com.ttq.list;

import java.util.ArrayList;

/**
 * 容器：ArrayList 底层数组，但是在数组的上面做了操作，扩容，田间，删除，获得...
 * ArrayList()	构造一个初始容量为10的空列表。 如果满了扩容
 * 创建新的数组，长度是旧数组的长度+1（算法因子），将旧数组删除
 * 			grow（size+1）
 * 
 * */
public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//真实存放对象的类型，容器里面放什么对象 String[] list = new String[10];
		//数据结构里面的顺序表
		ArrayList<String> list = new ArrayList<>();
		list.add("今天");//数组的封装 追加
		list.add(0, "hello");
		list.add(1, "明天");
		list.add(1, "明天");
		list.add(1, "明天");
		list.add(1, "明天");
		list.add(1, "明天");
		list.add(1, "明天");
		list.add(1, "明天");
		list.add(1, "明天");
		list.add(1, "明天");
		list.add(1, "明天");//自动扩容 
		//list.add(1);报错，数据类型不匹配
		//遍历，集合框架里面的数据
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
