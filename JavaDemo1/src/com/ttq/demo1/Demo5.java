package com.ttq.demo1;

public class Demo5 {
	public static void main(String[] args) {

		System.out.println(5 << 2);
		System.out.println(9 >> 2);
		System.out.println(9 >>> 2);
		System.out.println(5 & 9);
		System.out.println(5 | 9);
		System.out.println(~5);
		System.out.println(5 ^ 9);

		//计算时，二进制运算结果最快 2*8 最快的方式 2<<3
		System.out.println(2 << 3);

		//负数位运算
		System.out.println(-5 << 2);
		System.out.println(-5 | -9);
		System.out.println(-5 & -9);

		//右移 高位空出，补符号位，正数补0，负数补1
		//一个数右移极为就是除上2的几次放 5>>2=5/4=1
		System.out.println(-5 >> 2);
		//>>>无符号右移 高位全部补0 只接受32位 会负数变正数

		//～5 全部取反
		//5^9 异或 ：做加密 一个数异或另一个数两次还是这个数
		//用异或将两个数交换

	}
}
