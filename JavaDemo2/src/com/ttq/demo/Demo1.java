package com.ttq.demo;

import java.util.Scanner;

/**
 * 接受键盘输入
 * 作者: ttq
 * 日期:	2020年10月10日 上午9:21:31
 */
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入：");
		//输入单词后按esc，那么后面就不会加string后缀了
		String line = scanner.nextLine();//接受键盘输入
		System.out.println(line);

	}

}
