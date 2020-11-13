package com.ttq.demo;

/**
 * 本类用来演示
 * 
 * 多重循环代码不要超过3层循环，如果出现了，想办法优化
 * 
 * 作者: ttq
 * 日期:	2020年10月12日 上午9:14:22
 */
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int j = 1; j <= 9; j++) {
			for (int i = 1; i <= j; i++) {
				System.out.print(j + "*" + i + "=" + (j * i) + "\t");
			}
			System.out.println();
		}
	}

}
