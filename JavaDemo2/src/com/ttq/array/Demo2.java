package com.ttq.array;

/**
 * 循环处理数组里面的值
 * */
public class Demo2 {
	public static void main(String[] args) {
		//循环输出数组里面的值 数组名【下标】 下标从0开始一直到数组长度-1
		int[] arr = new int[] { 22, 55, 33, 66, 88, 33 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		// 	求数组里面的最大值：
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}

			//max=max>=arr[i]?max:arr[i];

		}
		System.out.println("最大值为：" + max);

	}
}
