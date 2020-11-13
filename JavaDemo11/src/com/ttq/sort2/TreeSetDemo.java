package com.ttq.sort2;

import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//comparator 对象 public interface Comparator<T> {} 接口 实现类对象
		//匿名内部类
		//		TreeSet<Good> setDemo = new TreeSet<Good>(new Comparator<Good>() {
		//
		//			@Override
		//			public int compare(Good o1, Good o2) {
		//				int sort = Double.valueOf(o1.getPrice()).compareTo(o2.getPrice());
		//				if (sort == 0) {
		//					return o1.getName().compareTo(o2.getName());
		//				}
		//				// TODO Auto-generated method stub
		//				return sort;
		//			}
		//		});

		//lambda
		TreeSet<Good> priceSet = new TreeSet<Good>((o1, o2) -> {
			int sort = Double.valueOf(o1.getPrice()).compareTo(o2.getPrice());
			if (sort == 0) {
				return o1.getName().compareTo(o2.getName());
			}
			// TODO Auto-generated method stub
			return sort;

		});
		priceSet.add(new Good("苹果", 9.8, 100));
		priceSet.add(new Good("西瓜", 9.8, 100));//价格相等
		priceSet.add(new Good("哈密瓜", 12.8, 100));
		priceSet.add(new Good("香蕉", 7.8, 100));
		priceSet.add(new Good("萝卜", 1.8, 100));
		priceSet.add(new Good("黄瓜", 5.8, 100));

		priceSet.forEach(System.out::println);

		//数量排序，换容器
		TreeSet<Good> numSet = new TreeSet<Good>((o1, o2) -> {
			int sort = Integer.valueOf(o1.getNum()).compareTo(o2.getNum());
			if (sort == 0) {
				return o1.getName().compareTo(o2.getName());
			}
			return sort;
		});
		numSet.add(new Good("苹果", 9.8, 100));
		numSet.add(new Good("西瓜", 9.8, 100));//价格相等
		numSet.add(new Good("哈密瓜", 12.8, 100));
		numSet.add(new Good("香蕉", 7.8, 100));
		numSet.add(new Good("萝卜", 1.8, 100));
		numSet.add(new Good("黄瓜", 5.8, 100));

		numSet.forEach(System.out::println);
	}

}
