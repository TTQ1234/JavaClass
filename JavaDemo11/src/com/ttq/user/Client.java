package com.ttq.user;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//用户业务类
		UserService userService = UserServiceImpl.getUserService();//多态
		//商品业务类
		GoodService goodService = GoodServiceImp1.getGoodService();//多态
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
				adminSuperMenu(scanner, userService, goodService);
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

	private static void adminSuperMenu(Scanner scanner, UserService userService, GoodService goodService) {
		// TODO Auto-generated method stub
		System.out.println("请输入管理员账号：");
		String account = scanner.nextLine().trim();
		System.out.println("请输入账号密码：");
		String password = scanner.nextLine().trim();
		if (account.equals("admin") && password.equals("123")) {
			System.out.println("登录成功");
			adminMenu(scanner, userService, goodService);
		} else {
			System.out.println("用户名或密码错误");
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
				System.out.println("商品信息列表如下：");
				goodService.showGoodList();
				break;
			case 2:
				System.out.println("请输入需要添加的商品名：");
				String goodName = scanner.nextLine().trim();
				System.out.println("请输入该商品的价格：");
				double goodPrice = Double.parseDouble(scanner.nextLine().trim());
				System.out.println("请输入该商品的数量");
				int goodNum = Integer.parseInt(scanner.nextLine().trim());
				Good good = new Good(goodName, goodPrice, goodNum);
				goodService.addGood(good);
				System.out.println("添加成功");
				break;
			case 3:
				System.out.println("请输入需要删除的商品名：");
				String goodName1 = scanner.nextLine().trim();
				goodService.deleteGoodByGname(goodName1);
				System.out.println("删除成功");
				break;
			case 4:
				System.out.println("请输入需要查找的商品名：");
				String goodName2 = scanner.nextLine().trim();
				if (goodService.selectByname(goodName2) != null) {
					Good good1 = goodService.selectByname(goodName2);
					System.out.println("该商品信息如下：");
					System.out.println(good1);
				} else {
					System.out.println("暂无该商品");
				}
				break;
			case 5:
				System.out.println("请输入需要修改价格的商品名：");
				String goodName3 = scanner.nextLine().trim();
				if (goodService.selectByname(goodName3) != null) {
					Good good2 = goodService.selectByname(goodName3);
					System.out.println("请输入修改价格：");
					double goodPrice1 = Double.parseDouble(scanner.nextLine().trim());
					goodService.updatePrice(good2, goodPrice1);
					System.out.println("修改成功");
				} else {
					System.out.println("暂无该商品，无法修改");
				}

				break;
			case 6:
				System.out.println("请输入需要修改数量的商品名：");
				String goodName4 = scanner.nextLine().trim();
				if (goodService.selectByname(goodName4) != null) {
					Good good3 = goodService.selectByname(goodName4);
					System.out.println("请输入修改价格：");
					int num = Integer.parseInt(scanner.nextLine().trim());
					goodService.updateNum(good3, num);
					System.out.println("修改成功");
				} else {
					System.out.println("暂无该商品，无法修改");
				}

				break;
			case 7:
				menu(scanner, userService, goodService);
				return;
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
