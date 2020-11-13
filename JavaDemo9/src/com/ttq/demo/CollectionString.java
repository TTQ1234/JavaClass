package com.ttq.demo;

import java.util.Scanner;

public class CollectionString {

	public static void main(String[] args) {
		System.out.println("请输入一串字符串：");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine().trim();
		int smallcount = 0;
		int bigcount = 0;
		int othercount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && 'z' >= s.charAt(i)) {
				smallcount++;
			} else if (s.charAt(i) > 'A' && 'Z' >= s.charAt(i)) {
				bigcount++;
			} else {
				othercount++;
			}
		}
		System.out.println(smallcount);
		System.out.println(bigcount);
		System.out.println(othercount);
	}
}
