package com.ttq.demo;

import java.util.Scanner;

public class StringMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入用户名（必须是邮箱）");
		Scanner scanner = new Scanner(System.in);
		String nameString = scanner.nextLine().trim();
		String regString = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		if (nameString.matches(regString)) {
			System.out.println("正确");
		} else {
			System.out.println("不正确");
		}
	}

}
