package com.ttq.demo;

/**
 * 本类用来演示
 * 
 * switch 只接受 byte short char int 枚举 字符串jdk1.7之后版本
 * 
 * 作者: ttq
 * 日期:	2020年10月10日 上午11:15:50
 */
public class Demo6 {
	public static void main(String[] args) {
		int num = 10;
		switch (num) {
		case 10:
			System.out.println(10);
			break;
		case 9:
			System.out.println(9);
			break;
		default:
			System.out.println("以上值都不是");
			break;
		}
	}
}
