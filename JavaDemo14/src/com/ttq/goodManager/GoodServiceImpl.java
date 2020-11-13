package com.ttq.goodManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.ttq.util.ObjectIOUtil;

public class GoodServiceImpl implements GoodService {
	private ArrayList<Good> goodList = new ArrayList<Good>();//List做容器

	private static final GoodServiceImpl goodService = new GoodServiceImpl();

	public static GoodServiceImpl getGoodService() {
		return goodService;
	}

	private GoodServiceImpl() {
		super();
		goodList = ObjectIOUtil.fileToObject("good.txt");
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

	//根据商品名删除商品 (集合删除,我们用for)
	@Override
	public boolean deleteGoodByGname(String name) {
		for (int i = 0; i < goodList.size(); i++) {
			if (goodList.get(i).getName().equals(name)) {
				//			找到了  goodList.remove(i)返回结果是被删除的对象
				return goodList.remove(i) != null ? true : false;//删除
			}
		}
		System.out.println("该商品不存在");
		return false;
	}

	//输出所有
	@Override
	public void showGoodList() {
		goodList.forEach(System.out::println);

	}

	@Override
	public void showGoodListByPriceAsc() {//价格升序
		//Collections  sort(比较器)
		Collections.sort(goodList, new Comparator<Good>() {
			@Override
			public int compare(Good o1, Good o2) {
				int sort = Double.valueOf(o1.getPrice()).compareTo(o2.getPrice());
				if (sort == 0) {
					return o1.getName().compareTo(o2.getName());//价格相等 商品名牌
				}
				return sort;//价格排序
			}
		});
		//输出
		goodList.forEach(System.out::println);

	}

	@Override
	public void showGoodListByPriceDesc() {//价格降序
		Collections.sort(goodList, new Comparator<Good>() {
			@Override
			public int compare(Good o1, Good o2) {
				int sort = Double.valueOf(o2.getPrice()).compareTo(o1.getPrice());//降序
				if (sort == 0) {
					return o1.getName().compareTo(o2.getName());//价格相等 商品排序
				}
				return sort;//价格排序
			}
		});
		//输出
		goodList.forEach(System.out::println);

	}

	@Override
	public void showGoodListByNumAsc() {//数量升序
		// TODO Auto-generated method stub
		Collections.sort(goodList, new Comparator<Good>() {

			@Override
			public int compare(Good o1, Good o2) {
				int sort = Integer.valueOf(o1.getNum()).compareTo(o2.getNum());//数量排序
				if (sort == 0) {
					return o1.getName().compareTo(o2.getName());//数量相等 商品名排序
				}
				return sort;
			}
		});
		//输出
		goodList.forEach(System.out::println);
	}

	@Override
	public void showGoodListByNumDesc() {//数量降序
		// TODO Auto-generated method stub
		Collections.sort(goodList, new Comparator<Good>() {

			@Override
			public int compare(Good o1, Good o2) {
				int sort = Integer.valueOf(o2.getNum()).compareTo(o1.getNum());//数量排序
				if (sort == 0) {
					return o1.getName().compareTo(o2.getName());//数量相等 商品名排序
				}
				return sort;
			}
		});
		//输出
		goodList.forEach(System.out::println);

	}

	@Override
	public boolean addGood(Good good) {
		// TODO Auto-generated method stub
		goodList.add(good);
		ObjectIOUtil.ObjectToFile(goodList, "good.txt");
		return true;
	}

	@Override
	public Good selectByGname(String name) {//常用增强for
		for (Good good : goodList) {
			if (good.getName().equals(name)) {
				return good;
			}
		}
		return null;
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

}
