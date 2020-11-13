package com.ttq.demo1;

public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//两数交换

		int num1 = 10;
		int num2 = 20;
		int temp = num1;//第三个数做过度
		temp = num1;
		num1 = num2;
		num2 = temp;

		num1 = num1 ^ num2;//num1=10^20
		num2 = num1 ^ num2;//一个数异或另一个数两次还是这个数 num2=10^20^20=10
		num1 = num1 ^ num2;//num1=10^20^10=20

		//三目
		int num = 10 > 2 ? 10 : 2;
		System.out.println(num);

	}

}
