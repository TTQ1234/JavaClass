package com.ttq.goodSystem;

import java.util.Scanner;

/**
 * 本类用来演示
 * 
 * 商品管理系统:
 * 1.添加商品(新商品) 
 * 2.进货(给已有商品加num) 
 * 3.删除该商品 
 * 4.根据商品名查询该商品
 * 5.显示所有商品 
 * 6.减少商品的个数  
 * 7.修改商品的价格  
 * 8.退出
 * 
 * 作者: ttq
 * 日期:	2020年10月14日 下午2:59:10
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Shop shop = Shop.gerShop();
		System.out.println("**********欢迎进入商店**********");
		while (true) {
			menu(scanner, shop);
		}
	}

	public static void menu(Scanner scanner, Shop shop) {
		System.out.println("1.添加商品");
		System.out.println("2.查询商品信息");
		System.out.println("3.查询商品列表");
		System.out.println("4.退出");
		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 1:
			addShopGood(scanner, shop);
			break;
		case 2:
			selectGood(scanner, shop);
			break;
		case 3:
			shop.showAllGood();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("您输入的有误，请重新输入！");
			break;
		}
	}

	/**
	 * 
	 * @param scanner
	 * @param shop
	 */
	public static void addShopGood(Scanner scanner, Shop shop) {
		System.out.println("请输入商品名");
		String name = scanner.nextLine().trim();
		Good good1 = shop.selectGoodList(name);
		if (good1 != null) {
			System.out.println("商品存在");
			return;
		}
		System.out.println("请输入商品价格");
		double price = Double.parseDouble(scanner.nextLine().trim());
		System.out.println("请输入商品数量");
		int num = Integer.parseInt(scanner.nextLine().trim());
		Good good = new Good(name, price, num);
		shop.addGood(good);
	}

	public static void selectGood(Scanner scanner, Shop shop) {
		System.out.println("请输入需要查询的商品名");
		String name = scanner.nextLine().trim();
		Good good = shop.selectGoodList(name);
		if (good != null) {
			System.out.println("该商品信息如下：");
			System.out.println(good.getGoodName() + "\t" + good.getPrice() + "\t" + good.getNum());
			System.out.println("您还可以进行以下操作：");
			while (true) {
				secondMenu(scanner, shop, good);
			}
		} else {
			System.out.println("查无此商品");
		}

	}

	public static void secondMenu(Scanner scanner, Shop shop, Good good) {
		System.out.println("1.进货");
		System.out.println("2.删除该商品");
		System.out.println("3.减少该商品的个数");
		System.out.println("4.修改该商品的价格");
		System.out.println("5.返回上一级");
		System.out.println("6.退出");
		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 1:
			System.out.println("请您输入进货数量");
			int num = Integer.parseInt(scanner.nextLine().trim());
			shop.addNum(good, num);
			break;
		case 2:
			shop.delectGood(good);
			break;
		case 3:
			System.out.println("请您输入减少的数量");
			int num1 = Integer.parseInt(scanner.nextLine().trim());
			shop.subNum(good, num1);
			break;
		case 4:
			System.out.println("请您输入新的价格");
			double price = Double.parseDouble(scanner.nextLine().trim());
			shop.editPrice(good, price);
			break;
		case 5:
			menu(scanner, shop);
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("您输入的有误，请重新输入！");
			break;
		}
	}
}
