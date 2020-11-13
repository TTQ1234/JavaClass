package com.ttq.demo;

/**
 * 本类用来演示
 * 
 * 汉偌塔
 * 递归 贪心 背包...
 * 
 * 作者: ttq
 * 日期:	2020年10月13日 上午9:36:19
 */
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		movePlan(1, 'a', 'b', 'c');
		movePlan(2, 'a', 'b', 'c');

	}

	//移盘子，从A移到C
	public static void movePlan(int n, char A, char B, char C) {
		if (n == 1) {
			move(n, A, C);
		} else {
			movePlan(n - 1, A, C, B);//把n-1的盘子 从a移到b
			move(n, A, C);//把最大的盘子移到C
			movePlan(n - 1, B, A, C);
		}
	}

	//盘子移动
	public static void move(int n, char source, char end) {
		System.out.println(n + "盘子从" + source + "移到了" + end);
	}
}
