package com.ttq.user;

public interface UserService {
	//注册
	boolean register(User user);

	//登录
	User login(String username, String password);

	//查看全部用户
	void showAllList();

	//根据用户的名字查看用户
	void findByName(String name);

	//修改用户的余额
	void updateBalance(User user, double money);

	//购买商品
	public Boolean buyGood(User user, String buyGoodName, int num);

	//c查看历史购买商品
	public void showHistoryOrders(User user);
}
