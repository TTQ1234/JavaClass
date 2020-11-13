package com.ttq.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GoodServiceImp1 implements GoodService {

	private ArrayList<Good> goodList = new ArrayList<Good>();

	private static final GoodServiceImp1 goodService = new GoodServiceImp1();

	public static GoodServiceImp1 getGoodService() {
		return goodService;
	}

	private GoodServiceImp1() {
		super();
		// TODO Auto-generated constructor stub
	}

	{
		goodList.add(new Good("苹果", 9.8, 10));
		goodList.add(new Good("西瓜", 9.8, 90));//价格相等
		goodList.add(new Good("哈密瓜", 12.8, 190));
		goodList.add(new Good("香蕉", 7.8, 101));
		goodList.add(new Good("萝卜", 1.8, 100));
		goodList.add(new Good("黄瓜", 5.8, 100));
	}

	@Override
	public boolean addGood(Good good) {
		// TODO Auto-generated method stub
		return goodList.add(good);
	}

	@Override
	public boolean deleteGoodByGname(String name) {
		// TODO Auto-generated method stub
		for (int i = 0; i < goodList.size(); i++) {
			if (goodList.get(i).getName().equals(name)) {
				return goodList.remove(i) != null ? true : false;
			}
		}
		System.out.println("该商品不存在");
		return false;
	}

	@Override
	public Good selectByname(String name) {//常用增强for
		// TODO Auto-generated method stub
		for (Good good : goodList) {//foreach
			if (good.getName().equals(name)) {
				return good;
			}
		}
		return null;
	}

	@Override
	public void showGoodList() {
		goodList.forEach(System.out::println);
		// TODO Auto-generated method stub

	}

	@Override
	public boolean updatePrice(Good good, double price) {
		// TODO Auto-generated method stub
		good.setPrice(price);
		return true;
	}

	@Override
	public boolean updateNum(Good good, int num) {
		// TODO Auto-generated method stub
		good.setNum(num);
		return true;
	}

	@Override
	public void showGoodListByPriceAsc() {
		// TODO Auto-generated method stub
		Collections.sort(goodList, new Comparator<Good>() {

			@Override
			public int compare(Good o1, Good o2) {
				int sort = Double.valueOf(o1.getPrice()).compareTo(o2.getPrice());
				if (sort == 0) {
					return o1.getName().compareTo(o2.getName());
				}
				return sort;
			}
		});
		goodList.forEach(System.out::println);
	}

	@Override
	public void showGoodListByPriceDesc() {
		// TODO Auto-generated method stub
		Collections.sort(goodList, new Comparator<Good>() {

			@Override
			public int compare(Good o1, Good o2) {
				int sort = Double.valueOf(o2.getPrice()).compareTo(o1.getPrice());
				if (sort == 0) {
					return o1.getName().compareTo(o2.getName());
				}
				return sort;
			}
		});
		goodList.forEach(System.out::println);
	}

	@Override
	public void showGoodListByNumAsc() {
		// TODO Auto-generated method stub
		Collections.sort(goodList, new Comparator<Good>() {

			@Override

			public int compare(Good o1, Good o2) {
				int sort = Integer.valueOf(o1.getNum()).compareTo(o2.getNum());
				if (sort == 0) {
					return o1.getName().compareTo(o2.getName());
				}
				return sort;
			}
		});
		goodList.forEach(System.out::println);
	}

	@Override
	public void showGoodListByNumDesc() {
		// TODO Auto-generated method stub
		Collections.sort(goodList, new Comparator<Good>() {

			@Override

			public int compare(Good o1, Good o2) {
				int sort = Integer.valueOf(o2.getNum()).compareTo(o1.getNum());
				if (sort == 0) {
					return o1.getName().compareTo(o2.getName());
				}
				return sort;
			}
		});
		goodList.forEach(System.out::println);
	}

}
