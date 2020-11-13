package com.ttq.demo;

import java.util.Scanner;

/**
 * 本类用来演示
 * 
 * 商品管理系统
 * 
 * bug：如果商品名有相同的名字，会被一起删除掉
 * 
 * 作者: ttq
 * 日期:	2020年10月12日 下午6:03:35
 */

public class ShopSys {
	/**
	 *     *********欢迎进入商店管理系统********
	 *     while(true){
	 *      1.查看全部的商品列表信息   "商品名 \t 价格\t 100     苹果   10.8  58"
	 *      2.商品入库   (请输入商品名  请输入商品价格   请输入商品数量  [重复])
	 *      3.商品下架(请输入下架第几个商品,个数-1=下标  删除)
	 *      4.查询商品信息(选中)  arr[i].startWith("苹果")==true;   字符串以什么开头  两个数组
	 *      5.根据商品名删除商品(请输入删除商品的商品名,删除成功)
	 *      6.退出系统
	 *      }
	 *      String[] goodList=new String[50];     "商品名 \t 价格\t 100     苹果   10.8  58"
	 *      //可以全部写在main里面 [1,2,3,6]
	 *      //  封装成其他方法
	 *      //  全部完成,方法封装
	 * 
	 * 
	 * **/

	//主函数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] goodList = new String[50];
		int curLength = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********欢迎进入商店管理系统********");

		//		insertData(scanner, goodList, curLength);
		while (true) {
			curLength = menu(scanner, goodList, curLength);
		}
	}

	//menu
	public static int menu(Scanner scanner, String[] goodList, int curLength) {
		System.out.println();
		System.out.println("1.查看全部的商品列表信息");
		System.out.println("2.商品入库");
		System.out.println("3.商品下架");
		System.out.println("4.查询商品信息");
		System.out.println("5.根据商品名删除商品");
		System.out.println("6.退出系统");
		System.out.println("请输入您的选择");
		int choice = Integer.parseInt(scanner.nextLine().trim());

		switch (choice) {
		case 1:
			showList(goodList, curLength);
			break;
		case 2:
			curLength = insertData(scanner, goodList, curLength);
			break;
		case 3:
			curLength = deleteData(scanner, goodList, curLength);
			break;
		case 4:
			showGood(scanner, goodList, curLength);
			break;
		case 5:
			curLength = deleteGood(scanner, goodList, curLength);
			break;
		case 6:
			System.exit(0);
			break;

		default:
			System.out.println("您输入的有误，请重新选择！");
			break;
		}
		return curLength;
	}

	//查看全部的商品列表信息
	public static void showList(String[] goodList, int curLength) {
		//没有商品
		if (curLength == 0) {
			System.out.println("暂无商品");
			return;
		}
		//查询所有商品
		System.out.println("商品名\t价格\t数量");
		for (int i = 0; i < curLength; i++) {
			System.out.println(goodList[i]);
		}

	}

	//商品入库
	public static int insertData(Scanner scanner, String[] goodList, int curLength) {
		//判断是否已满
		if (curLength == goodList.length) {
			System.out.println("商品已满，无法添加");
			return curLength;
		}
		//添加新数据
		System.out.println("请输入商品名");
		String good = scanner.nextLine().trim();
		System.out.println("请输入商品价格");
		String price = scanner.nextLine().trim();
		System.out.println("请输入商品数量");
		String count = scanner.nextLine().trim();
		String data;
		data = good + "\t" + price + "\t" + count;
		//		System.out.println(data);
		goodList[curLength++] = data;
		System.out.println("商品添加成功");
		return curLength;
	}

	//商品下架
	public static int deleteData(Scanner scanner, String[] goodList, int curLength) {
		//输入需要删除的值
		System.out.println("请输入需要删除商品对应的序号");
		int index = Integer.parseInt(scanner.nextLine().trim());
		//数组为空
		if (curLength == 0) {
			System.out.println("暂无商品");
			return curLength;
		}
		//输入的删除位置不正确
		if (index < 0 || index >= curLength) {
			System.out.println("没有该商品");
			return curLength;
		}
		//删除

		for (int i = index; i < curLength - 1; i++) {
			goodList[i] = goodList[i + 1];
		}
		System.out.println("该商品删除成功");
		curLength--;
		return curLength;
	}

	//查询商品信息
	public static void showGood(Scanner scanner, String[] goodList, int curLength) {
		System.out.println("请输入需要查询的商品名称");
		String good = scanner.nextLine().trim();
		for (int i = 0; i < curLength; i++) {
			if (goodList[i].startsWith(good) == true) {
				System.out.println(goodList[i]);
			} else {
				System.out.println("没有找到该商品");
			}
		}
	}

	//根据商品名删除商品
	public static int deleteGood(Scanner scanner, String[] goodList, int curLength) {
		System.out.println("请输入需要删除的商品名称");
		String good = scanner.nextLine().trim();

		//数组为空
		if (curLength == 0) {
			System.out.println("暂无商品");
			return curLength;
		}
		//查找并删除该商品
		for (int i = 0; i < curLength;) {
			if (goodList[i].startsWith(good) == true) {
				for (int j = i; j < curLength - 1; j++) {
					goodList[j] = goodList[1 + j];
				}
				System.out.println("该商品删除成功");
				curLength--;
				return curLength;

			} else {
				System.out.println("没有找到该商品");
				return curLength;
			}
		}
		return curLength;
	}
}
