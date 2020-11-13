package com.ttq.sort;

import java.util.TreeSet;

//缺排序算法
public class TreeSetDemo {

	public static void main(String[] args) {//如果价格一样 会被去掉
		// TODO Auto-generated method stub
		TreeSet<Good> goods = new TreeSet<Good>();
		goods.add(new Good("苹果", 13.5, 6));
		goods.add(new Good("橘子", 6.9, 7));
		goods.add(new Good("哈密瓜", 5.4, 7));
		goods.add(new Good("西瓜", 6.9, 7));
		goods.add(new Good("香蕉", 2.9, 7));
		goods.add(new Good("柠檬", 10.9, 7));
		goods.forEach(System.out::println);

	}

}
