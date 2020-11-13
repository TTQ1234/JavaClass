package com.ttq.goodSystem;

/**
 * 本类用来演示
 * 
 * 商品的模版
 *    特征：对商品的描述，长成什么样：价格 数量 商品名
 *    行为：商品能做什么功能
 *    
 * 作者: ttq
 * 日期:	2020年10月13日 上午11:05:32
 */
public class Good {
	//商品名
	private String goodName;
	//数量
	private int num;
	//价格
	private double price;

	public void showInfo() {
		System.out.println("商品名：" + goodName + ",数量：" + num + ",价格：" + price);
	}

	//默认构造
	public Good() {
		super();
		// TODO Auto-generated constructor stub
	}
	//全部参数构造

	public Good(String goodName, int num, double price) {
		super();
		this.goodName = goodName;
		this.num = num;
		this.price = price;
	}

	//属性私有化 会提供getter和setter方法,可以有约束条件
	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
