package com.ttq.demo;

import java.util.Scanner;

/**
 * 键盘输入两个正数，求两个数的和
 * 作者: ttq
 * 日期:	2020年10月10日 上午9:54:38
 */
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入第一个数：");
		int num1 = Integer.parseInt(scanner.nextLine());//字符串->整数
		System.out.println("请输入第二个数：");
		int num2 = Integer.parseInt(scanner.nextLine());
		System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
	}

}
