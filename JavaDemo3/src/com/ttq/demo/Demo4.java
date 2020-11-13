package com.ttq.demo;

/**
 * 本类用来演示
 * 方法的定义和调用
 * 
 * 作者: ttq
 * 日期:	2020年10月12日 上午10:30:10
 */
public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//真正使用的时候成为实参，如果有返回值，用变量接收返回值，变量的类型和返回值类型一只
		int sum = add(10, 20);
		System.out.println(sum);

		System.out.println(add(30, 40));

		int a = 10;
		int b = 20;
		swap(a, b);
		System.out.println(a + b);

		int[] arr = { 10, 20 };
		swapArray(arr);
		System.out.println(arr[0] + "" + arr[1]);
	}

	//求两个数 int的和
	public static int add(int num1, int num2) {
		int sum = num1 + num2;//求和//形参
		//return 返回结果
		return sum;
	}

	public static void swap(int num1, int num2) {
		//int num1=(num1+num2)-(num2=num1);
		int temp = num1;
		num1 = num2;
		num2 = temp;

	}

	public static void swapArray(int[] arr) {
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
	}
	//总结：如果实参存在栈理，那么形参改变不影响实
	//如果实参在堆理，那么形参和实参为一体，形参改变影响实参
}
