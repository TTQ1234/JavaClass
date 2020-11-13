package com.ttq.goodManager;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//用户业务类
		UserService userService = UserServiceImpl.getUserService();//多态
		//商品业务类
		GoodService goodService = GoodServiceImpl.getGoodService();//多态
		System.out.println("欢迎您使用Gem商品管理系统");
		menu(scanner, userService, goodService);

	}

	//主菜单
	private static void menu(Scanner scanner, UserService userService, GoodService goodService) {
		while (true) {
			System.out.println("1.管理员");
			System.out.println("2.客户");
			System.out.println("3.退出系统");
			System.out.println("请输入您的选择:");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				//管理员的界面
				adminMenu(scanner, userService, goodService);
				break;
			case 2:
				//用户的界面
				userSuperMenu(scanner, userService, goodService);
				break;
			case 3:
				//退出
				System.exit(0);
				break;

			default:
				System.out.println("您输入不正确");
				break;
			}
		}

	}

	private static void userSuperMenu(Scanner scanner, UserService userService, GoodService goodService) {
		System.out.println("1.登录");
		System.out.println("2.注册");
		System.out.println("3.返回上一层");
		System.out.println("4.退出");
		System.out.println("请输入您的选择:");
		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 1:
			System.out.println("请输入用户名:");
			String name = scanner.nextLine().trim();
			System.out.println("密码:");
			String password = scanner.nextLine().trim();
			User user = userService.login(name, password);
			if (user != null) {//登录成功
				//用户功能
				userMenu(scanner, userService, goodService, user);
			} else {
				System.out.println("登录失败");
			}

			break;
		case 2:
			System.out.println("请输入用户名:");
			name = scanner.nextLine().trim();
			System.out.println("密码:");
			password = scanner.nextLine().trim();
			User user2 = new User(name, password, 1000);
			userService.register(user2);//注册
			System.out.println("注册成功");
			break;
		case 3:
			menu(scanner, userService, goodService);
			break;
		case 4:
			System.exit(0);
			break;

		default:
			break;
		}

	}

	//

	private static void userMenu(Scanner scanner, UserService userService, GoodService goodService, User user) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1.查看商品列表");
			System.out.println("2.按价格升序");
			System.out.println("3.按价格降序");
			System.out.println("4.按数量升序");
			System.out.println("5.按数量降序");
			System.out.println("6.购物");
			System.out.println("7.查看历史订单");
			System.out.println("8.修改余额");
			System.out.println("9.返回上一层");
			System.out.println("10.退出");
			System.out.println("请输入您的选择");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1: //商品列表
				goodService.showGoodList();
				break;
			case 2://价格升序
				goodService.showGoodListByPriceAsc();
				break;
			case 3://价格降
				goodService.showGoodListByPriceDesc();
				break;
			case 4://数量升
				goodService.showGoodListByNumAsc();
				break;
			case 5://数量降
				goodService.showGoodListByNumDesc();
				break;
			case 6://购物
				System.out.println("请输入购买的商品名:");
				String name = scanner.nextLine().trim();
				System.out.println("请输入购买的数量:");
				int num = Integer.parseInt(scanner.nextLine().trim());
				userService.buyGood(user, name, num);//购物
				break;
			case 7:
				userService.showHistoryOrders(user);
				break;
			case 8:
				System.out.println("请输入修改的余额:");
				double money = Double.parseDouble(scanner.nextLine().trim());
				userService.updateBalance(user, money);
				break;
			case 9:
				menu(scanner, userService, goodService);
				break;
			case 10:
				System.exit(0);
				break;

			default:
				System.out.println("您输入不正确");
				break;
			}

		}
	}

	//管理员
	private static void adminMenu(Scanner scanner, UserService userService, GoodService goodService) {
		while (true) {
			System.out.println("1.查看商品列表");
			System.out.println("2.添加商品");
			System.out.println("3.删除商品");
			System.out.println("4.查找商品");
			System.out.println("5.修改商品的价格");
			System.out.println("6.修改商品的数量");
			System.out.println("7.返回上一层");
			System.out.println("8.退出");
			System.out.println("请输入您的选择");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				goodService.showGoodList();
				break;
			case 2:
				System.out.println("请输入商品名:");
				String goodName = scanner.nextLine();
				Good good = goodService.selectByGname(goodName);
				if (good != null) {
					System.out.println("该商品已存在");
				} else {
					System.out.println("请输入商品价格:");
					double price = Double.parseDouble(scanner.nextLine().trim());
					System.out.println("请输入数量:");
					int num = Integer.parseInt(scanner.nextLine().trim());
					Good good2 = new Good(goodName, price, num);
					goodService.addGood(good2);//添加商品

				}
				break;
			case 3:
				System.out.println("请输入商品的商品名:");
				goodName = scanner.nextLine();
				goodService.deleteGoodByGname(goodName);
				break;
			case 4:
				System.out.println("请输入商品的商品名:");
				goodName = scanner.nextLine();
				good = goodService.selectByGname(goodName);
				System.out.println(good);
				break;
			case 5:
				System.out.println("请输入修改商品的名称:");
				goodName = scanner.nextLine();
				good = goodService.selectByGname(goodName);
				if (good == null) {
					System.out.println("该商品不存在");
				} else {
					System.out.println("请输入修改的价格:");
					double price = Double.parseDouble(scanner.nextLine().trim());
					goodService.updatePrice(good, price);
				}

				break;
			case 6:
				System.out.println("请输入修改商品的名称:");
				goodName = scanner.nextLine();
				good = goodService.selectByGname(goodName);
				if (good == null) {
					System.out.println("该商品不存在");
				} else {
					System.out.println("请输入修改的数量:");
					int num = Integer.parseInt(scanner.nextLine().trim());
					goodService.updateNum(good, num);
				}

				break;
			case 7:
				menu(scanner, userService, goodService);
				break;
			case 8:
				System.exit(0);
				break;

			default:
				System.out.println("您输入不正确");
				break;
			}

		}

	}

}
