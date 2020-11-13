package com.ttq.demo;

import java.util.Random;
import java.util.Scanner;

public class SureCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		String s2 = "";
		int count = 0;
		while (count < 6) {
			Random random = new Random();
			s2 += s1.charAt(random.nextInt(s1.length()));
			count++;
		}
		System.out.println(s2);
		Scanner scanner = new Scanner(System.in);
		String s3 = scanner.nextLine().trim();
		if (s3.equalsIgnoreCase(s2) == true) {
			System.out.println("验证码正确");
		} else {
			System.out.println("验证码错误");
		}

	}

}
