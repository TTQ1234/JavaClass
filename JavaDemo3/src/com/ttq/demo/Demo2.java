package com.ttq.demo;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				break;//跳出循环,可以提高程序执行效率
				//coninue;
			}
			System.out.println(i + " ");
		}

		//在数组中查询某个数

		int[] arr = { 11, 22, 43, 56, 44, 67, 96, 3, 6 };
		int num = 22;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				System.out.println("找到了，第" + (i + 1) + "个");
				break;
			}
		}

		//跳出多重循环 break

		flag: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 3) {
					break flag;//只能跳出内循环 除非使用标记
				}
				System.out.print(i + "*" + j + "\t");
			}
			System.out.println();

		}

		//总结：break相对用的比较多，跳出多重循环的break了解，用的地方不多，面试多
	}

}
