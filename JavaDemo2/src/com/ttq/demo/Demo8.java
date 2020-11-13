package com.ttq.demo;

import java.util.Random;
import java.util.Scanner;

/**
 * 本类用来演示
 * 
 * 猜字谜游戏
 * ***********欢迎您进入GEM猜字谜游戏*************
         1.开始游戏
         2.退出
                  请输入您的选择:
                   1. 请输入您的姓名
                      请输入您猜数的范围 (例如:100,那么猜数就在1-100之间的整数)
                       100
                      请输入您猜的数
                      恭喜答对   大了   小了
 * 作者: ttq
 * 日期:	2020年10月10日 上午11:33:40
 */
public class Demo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("***********欢迎您进入GEM猜字谜游戏*************");
		System.out.println("1.开始游戏");
		System.out.println("2.退出");

		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 1:
			System.out.println("请输入您的姓名:");
			String name = scanner.nextLine().trim();
			System.out.println("请输入您猜数的范围（例如：输入100，所猜的数就在1-100之间的整数）");
			int num = Integer.parseInt(scanner.nextLine().trim());

			Random random = new Random();
			int randomNum = random.nextInt(num) + 1;

			while (true) {
				System.out.println("请输入您猜的数【输入0结束】：");
				int guessNum = Integer.parseInt(scanner.nextLine().trim());
				if (guessNum == 0) {
					System.exit(0);
				}
				if (randomNum == guessNum) {
					System.out.println("你猜对了");
					return;
				}
				if (randomNum < guessNum) {
					System.out.println("大了，真实的数为" + randomNum);
					//return; 这是函数结束，循环也会结束
				} else {
					System.out.println("小了，真实的数为" + randomNum);
				}
			}

		case 2:
			System.exit(0);
			break;
		default:
			System.out.println("您输入的不正确");//正常退出
			break;
		}
	}

}
