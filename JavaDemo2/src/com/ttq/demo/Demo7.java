package com.ttq.demo;

import java.util.Scanner;

public class Demo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("******欢迎进入学生管理系统******");
		System.out.println("1.查看所有学生");
		System.out.println("2.添加学生");
		System.out.println("3.删除学生");
		System.out.println("4.修改学生信息");
		System.out.println("5.根据学生姓名查看学生");
		System.out.println("6.退出");
		System.out.println("请输入您的选择");
		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 1:
			System.out.println("查看学生列表成功");
			break;
		case 2:
			System.out.println("添加学生成功");
			break;
		case 3:
			System.out.println("删除学生成功");
			break;
		case 4:
			System.out.println("修改学生成功");
			break;
		case 5:
			System.out.println("查看学生成功");
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("您输入的不正确");
			break;
		}
	}

}
