package com.ttq.demo;

import java.util.Scanner;

public class Demo9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//枚举类型
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入性别");
		String ssex = scanner.nextLine().trim();//字符串

		Gender sex = ssex.equals("男") ? Gender.MAN : Gender.WOMAN;
		//下面业务统一用枚举值：男女
		switch (sex) {
		case MAN:
			System.out.println("男生");
			break;
		case WOMAN:
			System.out.println("女生");
			break;
		default:
			System.out.println("输入的不正确");
			break;
		}

	}

}
