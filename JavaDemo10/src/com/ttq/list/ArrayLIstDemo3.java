package com.ttq.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 集合遍历
 * 
 * */
public class ArrayLIstDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		//普通遍历for
		System.out.println("----------普通for----------");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		System.out.println("----------增强for----------");
		for (String num : list) {
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.println("----------集合自带迭代器----------");//相当于一个指针，指向第一个数据元素的前一位，查看后面有没有，有的话遍历输出
		Iterator<String> iterator = list.iterator();//迭代器
		while (iterator.hasNext()) {//后面有没有值
			System.out.print(iterator.next() + " ");//指针移到后一位，获取值
		}
		/**
		 * public interface Consumer<T>{
		 *   accepy(T e);//匿名内部类，lamdba
		 *   
		 *   写实现类，new对象，重写accept（T e ）{集合里面数据元素，输出这个元素}
		 * }
		 * */
		System.out.println();
		System.out.println("----------ForEach----------");
		list.forEach(e -> System.out.print(e));

		list.forEach(new MyConsumer());//void java.util.ArrayList.forEach(Consumer action)
		//接口的实现类对象
		System.out.println();
		System.out.println("------stream------");

		list.forEach(System.out::print);
	}

}

class MyConsumer implements Consumer<String> {

	@Override
	public void accept(String t) {
		// TODO Auto-generated method stub
		System.out.print(t + "  ");

	}

}
