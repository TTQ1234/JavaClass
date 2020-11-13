package com.ttq.demo1;
/**
 * 本类用来演示
 * 作者: easonsy
 * 日期:	2020年10月9日 上午11:33:57
 */

/**
 * 变量：一块内存空间
 * 大小（数据类型）变量名=值
 * 小盒子里面的值存到大盒子是可以的，反之不行
 * byte->short->int->long 小盒子->大盒子
 * float->double 小盒子->大盒子
 * char->int 小盒子->大盒子 '0'=>48 'A'->65 'a'->97
 * int/short/int/long->double 可以
 * 
 * 大盒子到小盒子报错，但是可以强转，有风险，需要注意
 */
public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte num1 = 10;//在内存栈中开辟一块空间，空间大小为1个字节，里面存放值为10，空间名为num1
		System.out.println(num1);
		num1 = 20;//修改num1内存空间的值为20
		//int num2 = num1;//将num1空间里面的值赋值一份存放到num2中
		//num1=num2; num2里面的值取出来放到num1中，放不下，num1空间小，越界
		int num2 = 130;
		num1 = (byte) num2;//num2里面的值取出来放到num1中，越界
		System.out.println(num1);//负数 截断 高位可能是1

		char num3 = 'C';
		int num4 = num3;//ascii码
		System.out.println(num4);
		double num5 = num4;

		/**
		 * 下面梁总方法有区别吗?
		 * float f1 = 12.345f; 正确 4个字节
		 * float f2 =(float)12.345; 正确 8个字节
		 */

		float f = 12.4f;//四个字节

		//自定义常量
		final float num6 = 12.4f;//num6存在常量池中，不在栈里面
		//num6 = 30.5f；//常量不能改变

		/*int num;//定义变量
		System.out.println(num);//变量没有初始值不能使用
		int i = num;//错误
		*/

		var num = 10;//相当于int，double

	}

}
