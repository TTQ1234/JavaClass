package com.ttq.array;

import java.util.Scanner;

/**
 * 本类用来演示
 * 
 * 用户数组：字符串数组
 * 
 * 作者: ttq
 * 日期:	2020年10月10日 下午3:26:13
 */
public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] userList = new String[20];//最多存20个用户，存放格式“用户名；密码”
		int curLength = 0;//数组里面已有的用户个数
		//键盘扫描仪
		Scanner scanner = new Scanner(System.in);
		System.out.println("******欢迎使用*******");

		while (true) {
			System.out.println("1.注册");
			System.out.println("2.登录");
			System.out.println("3.退出");
			System.out.println("请输入您的选择");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				//注册
				if (curLength == userList.length) {
					System.out.println("用户列表已满，不能注册");
				} else {
					System.out.println("请输入用户名：");
					String username = scanner.nextLine().trim();
					System.out.println("请输入密码：");
					String password = scanner.nextLine().trim();

					//将用户存进数组中，然后当前长度++
					userList[curLength++] = username + ";" + password;
					System.out.println(username + "注册成功");
				}
				break;
			case 2:
				System.out.println("请输入用户名：");
				String username = scanner.nextLine().trim();
				System.out.println("请输入密码：");
				String password = scanner.nextLine().trim();
				//循环便利数组，看用户名和密码是否能存在
				boolean flag = false;
				for (int i = 0; i < curLength; i++) {//数组里面已有的用户遍历
					if ((username + ";" + password).equals(userList[i])) {
						System.out.println("登录成功");
						flag = true;
						break;
					}
				}
				//循环结束
				if (!flag) {
					System.out.println("用户名或密码错误");
				}
				break;
			case 3:
				System.exit(0);
				break;

			default:
				System.out.println("您输入的不正确");
				break;
			}
		}
	}

}
