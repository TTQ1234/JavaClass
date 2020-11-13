package com.ttq.array;

/**
 * 本类用来演示
 * 
 * while 循环
 * 
 * 作者: ttq
 * 日期:	2020年10月10日 下午4:21:33
 */
public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//求1-100的和
		int sum = 0;
		//初始值
		int num = 1;
		//结束条件
		while (num <= 100) {
			sum += num;//求和
			//步调
			num++;
		}
		System.out.println("1-100的和为" + sum);

		int sum1 = 0;
		int num1 = 1;
		do {
			sum1 += num1;
			num1++;
		} while (num1 <= 100);
		System.out.println("1-100的和为" + sum1);
	}

}
