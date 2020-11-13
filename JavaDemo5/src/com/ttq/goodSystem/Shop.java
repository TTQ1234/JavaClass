package com.ttq.goodSystem;

public class Shop {
	private Good[] goodList = new Good[100];

	private int count = 0;
	private static final Shop shop = new Shop();

	public static Shop gerShop() {
		return shop;
	}

	private Shop() {
	}

	//添加商品
	/**
	 * 
	 * @param good
	 */
	public void addGood(Good good) {
		if (this.count == this.goodList.length) {
			System.out.println("商品已满");
			return;
		}
		this.goodList[this.count++] = good;
		System.out.println("商品添加成功");
	}

	/**
	 * 显示商品列表
	 */
	public void showAllGood() {
		if (this.count == 0) {
			System.out.println("没有任何商品");
			return;
		}
		for (int i = 0; i < this.count; i++) {
			goodList[i].show();
		}
	}

	/**
	 * 
	 * @param goodName
	 * @return
	 */
	public Good selectGoodList(String goodName) {
		for (int i = 0; i < this.count; i++) {
			Good good = this.goodList[i];
			if (good.getGoodName().equals(goodName)) {
				return good;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param good
	 * @param num
	 */
	public void addNum(Good good, int num) {
		if (num <= 0) {
			System.out.println("进货数量有误");
			return;
		}
		good.setNum(good.getNum() + num);
		System.out.println("进货成功");
	}

	/**
	 * 
	 * @param good
	 * @param num
	 */
	public void subNum(Good good, int num) {
		if (num <= 0 || num >= good.getNum()) {
			System.out.println("输入有误或商品数量不足");
			return;
		}
		good.setNum(good.getNum() - num);
		System.out.println("减少商品数量成功");
	}

	/**
	 * 
	 * @param good
	 * @param price
	 */
	public void editPrice(Good good, double price) {
		if (price < 0) {
			System.out.println("输入的价格有误");
			return;
		}
		good.setPrice(price);
		System.out.println("修改价格成功");
	}

	/**
	 * 
	 * @param good
	 */
	public void delectGood(Good good) {
		for (int i = 0; i < this.count; i++) {
			if (goodList[i].getGoodName().equals(good.getGoodName())) {
				for (int j = i; j < count - 1; j++) {
					goodList[j] = goodList[1 + j];
				}
				System.out.println("该商品删除成功");
				count--;
			}
		}

	}
}
