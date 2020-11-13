package com.ttq.demo;

import java.util.Scanner;

/**
 * 输入两个数，求两个数的最大值
 * 作者: ttq
 * 日期:	2020年10月10日 上午10:01:26
 */
public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入第一个数：");
		int num1 = Integer.parseInt(scanner.nextLine());
		System.out.println("请输入第二个数：");
		int num2 = Integer.parseInt(scanner.nextLine());
		int max = num1 >= num2 ? num1 : num2;
		System.out.println(num1 + "和" + num2 + "的最大值为：" + max);

	}

}
