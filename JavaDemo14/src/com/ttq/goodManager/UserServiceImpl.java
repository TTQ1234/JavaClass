package com.ttq.goodManager;

import java.util.ArrayList;

import com.ttq.util.ObjectIOUtil;

public class UserServiceImpl implements UserService {
	//用户列表替换数组 (无缝衔接,底层透明)
	private ArrayList<User> userList = null;
	// 业务类全部单例
	private GoodServiceImpl goodSevice = GoodServiceImpl.getGoodService();
	//单例
	private static final UserServiceImpl userService = new UserServiceImpl();

	public static UserServiceImpl getUserService() {
		return userService;
	}

	private UserServiceImpl() {
		// TODO Auto-generated constructor stub
		userList = ObjectIOUtil.fileToObject("users.txt");

	}

	@Override
	public boolean register(User user) {
		//		return userList.add(user);//添加到集合框架
		userList.add(user);
		ObjectIOUtil.ObjectToFile(userList, "users.txt");
		return false;
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

	//买商品
	@Override
	public Boolean buyGood(User user, String buyGoodname, int buyNum) {
		//去商店里的商品列表中查找该商品是否存在
		Good good = goodSevice.selectByGname(buyGoodname);
		if (good == null) {
			System.out.println("该商品不存在");
			return false;
		}
		//		数量不够
		if (good.getNum() < buyNum) {
			System.out.println("商品个数不足");
			return false;
		}
		//余额不足
		double sumPrice = good.getPrice() * buyNum;//买的钱
		if (user.getBalance() < sumPrice) {
			System.out.println("余额不足");
			return false;
		}
		//买
		user.setBalance(user.getBalance() - sumPrice);//余额修改
		goodSevice.updateNum(good, good.getNum() - buyNum);//数量减少
		//生成订单
		user.getGoodList().add(new Good(buyGoodname, good.getPrice(), buyNum));
		System.out.println("购物成功");
		return true;

	}

	@Override
	public void showHistoryOrders(User user) {
		//user gooList  已买商品列表属性
		user.getGoodList().forEach(System.out::println);

	}

}
