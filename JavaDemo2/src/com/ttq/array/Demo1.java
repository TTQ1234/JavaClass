package com.ttq.array;

/**
 * 本类用来演示
 * 
 * 数组：里面存放多个数据元素
 * 		在内存中是一片连续的区域 一个长度为10的int类型数组，10个int类型的数存在一起
 * 数组定义分为静态初始化和动态初始化
 * 数组存在堆里面，堆需要手动开辟资源，用关键字new开辟
 * java中的数组，只要定义，长度不可变
 * 
 * 作者: ttq
 * 日期:	2020年10月10日 下午2:15:15
 */
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 静态初始化
		 * int num =10;
		 * int[] num1;
		 */

		int[] arr1 = new int[] { 10, 20, 30, 40 };

		System.out.println(arr1);//输出的是地址  为[I@626b2d4a
		System.out.println(arr1[0]);//输出第一位
		//System.out.println(arr1[4]); //Index 4 out of bounds for length 4

		//数组的长度
		System.out.println("该数组的长度为" + arr1.length);
		arr1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		//数组是不是长度从4变成10？ 错误，数组定义，不可以改变长度
		System.out.println(arr1);//新指向的地址 为[I@156643d4 说明不是同一个
		System.out.println("该数组的新长度为" + arr1.length);

		int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };//new int[] 省去，存在堆里面

		//动态定义
		int[] arr3 = new int[10];//开辟10个int空间的数组，里面的只默认初始化为0

		//数组可静态初始化可以动态初始化，但是不能动静结合
		//int[] arr = new int[10] {1,2,3,4}; //错误
		//int[10] arr7 = {1,2,3,4,5};//错误

	}

}
