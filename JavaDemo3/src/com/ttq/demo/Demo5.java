package com.ttq.demo;

/**
 * 本类用来演示
 * 
 * 求两个数的和
 * 求三个数的和
 * 求四个数的和
 * 求五个数的和
 * 
 * 作者: ttq
 * 日期:	2020年10月12日 上午11:34:04
 */
public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//函数的重载：方法名相同，参数类型或数量不一样，我们称为方法的重载，返回值不考虑
	//方法的重载不是同一个方法，只是方法名相同，一个函数里面不能出现同一个方法
	public static int add(int num1, int num2) {
		return num1 + num2;
	}

	public static double add(double a, double b) {//方法名相同 参数类型不同
		return a + b;
	}

	public static int add(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}

	public static int add(int num1, int num2, int num3, int num4) {
		return num1 + num2 + num3 + num4;
	}

	public static int add(int num1, int num2, int num3, int num4, int num5) {
		return num1 + num2 + num3 + num4 + num5;
	}

}
