package com.ttq.user;

public interface GoodService {
	//添加商品
	public boolean addGood(Good good);

	//删除商品
	public boolean deleteGoodByGname(String name);

	//根据商品名查找商品
	public Good selectByname(String name);

	//显示商品列表
	public void showGoodList();

	//修改商品的价格
	public boolean updatePrice(Good good, double price);

	//修改商品的数量
	public boolean updateNum(Good good, int num);

	//按照价格升序排序
	public void showGoodListByPriceAsc();

	//按照价格降序排序
	public void showGoodListByPriceDesc();

	//按照数量升序排序
	public void showGoodListByNumAsc();

	//按照数量降序
	public void showGoodListByNumDesc();
}
