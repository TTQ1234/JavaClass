package com.ttq.demo;

interface Base {
	//求两个数相加
	int add(int num1, int num2);
}

public class Client {
	public static void main(String[] args) {
		Base base1 = new Base() {

			@Override
			public int add(int num1, int num2) {
				// TODO Auto-generated method stub
				return num1 + num2;
			}
		};
		int sum = base1.add(10, 20);
		System.out.println(sum);

		//lambda 多态
		Base base2 = (num1, num2) -> {
			return num1 + num2;
		};
		System.out.println(base1.add(20, 30));
	}

}
