package com.ttq.demo;

/**
 * 本类用来演
 * 
 * 递归的思想：分治的思想
 * 自己不断点用自己解决问题
 * 
 * 递归的要素：1）递归的算法 2）出口：小问题一定可以解决
 * 
 * 求1-n的和 
 * 
 * 作者: ttq
 * 日期:	2020年10月13日 上午9:18:37
 */
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSum(10));
		System.out.println(getMul(10));
	}

	//求1-n的和
	public static int getSum(int n) {
		if (n == 1) {
			return 1;
		}
		return getSum(n - 1) + n;
	}

	//求1-10的积

	public static int getMul(int n) {
		if (n == 1) {
			return 1;
		}
		return getMul(n - 1) * n;
	}
}
