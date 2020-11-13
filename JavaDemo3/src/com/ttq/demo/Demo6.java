package com.ttq.demo;

/**
 * 本类用来演示
 * 
 * 对于相同的功能，形参的类型一致，个数不确定，我们可以用不定参数
 * 求多个int整数的和
 * 
 * 作者: ttq
 * 日期:	2020年10月12日 下午2:20:17
 */
public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(10, 20, 30));
		System.out.println(add(10, 20));

	}

	//实参不定的特殊情况 不定参数只能有一个 而且必须放在最后一个 （可以接受其他的参数 比如加一个int a）
	public static int add(int... nums) {
		//nums是数组，专门接收输入的实参 int[] nums 
		//使用增强for循环
		int sum = 0;
		for (int num : nums) {//将nums里面的数一个个取出来复制给num

			sum += num;
		}
		return sum;
	}

}
