package com.ttq.user;

import java.util.LinkedList;

public class UserServiceImpl implements UserService {
	//用户列表替换数组 (无缝衔接,底层透明)
	private LinkedList<User> userList = new LinkedList<User>();
	//业务类全部是单例
	private GoodService goodService = GoodServiceImp1.getGoodService();

	public static UserServiceImpl getUserService() {
		return userService;
	}

	private static final UserServiceImpl userService = new UserServiceImpl();

	private UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean register(User user) {
		return userList.add(user);//添加到集合框架
	}

	@Override
	public User login(String username, String password) {
		for (User user : userList) {//增强for
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;//登录成功
			}
		}
		return null;//登录失败
	}

	@Override
	public void showAllList() {//显示所有
		System.out.println("********用户列表********");
		userList.forEach(System.out::println);
	}

	@Override
	public void findByName(String name) {
		for (User user : userList) {//增强
			if (user.getUsername().equals(name)) {
				System.out.println(user);
				return;
			}
		}
		System.out.println("该用户不存在");

	}

	@Override
	public void updateBalance(User user, double money) {
		user.setBalance(money);
		System.out.println("修改成功");
	}

	@Override
	public Boolean buyGood(User user, String buyGoodName, int num) {
		// TODO Auto-generated method stub
		//去商店里的商品列表取查找该商品是否存在
		Good good = goodService.selectByname(buyGoodName);
		if (good == null) {
			System.out.println("商品不存在");
			return false;
		}
		//数量不够
		if (good.getNum() < num) {
			System.out.println("个数不足");
			return false;
		}
		//余额不足
		double sumPrice = good.getPrice() * num;
		if (user.getBalance() < sumPrice) {
			System.out.println("余额不足");
			return false;
		}
		user.setBalance(user.getBalance() - sumPrice);
		goodService.updateNum(good, good.getNum() - num);
		user.getGoodList().add(new Good(buyGoodName, good.getPrice(), num));
		return true;
	}

	@Override
	public void showHistoryOrders(User user) {
		// TODO Auto-generated method stub
		user.getGoodList().forEach(System.out::println);
	}

}
