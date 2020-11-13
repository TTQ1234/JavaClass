package com.ttq.demo1;

/**
 * 运算符：算数运算
 * byte short char 做算数运算 先转你太再运算
 */
public class Demo4 {
	public static void main(String[] args) {
		byte b = 10;
		//b=b+1;//Type mismatch: cannot convert from int to byte
		int c = b + 1;
		System.out.println(c);
		System.out.println('a' + 1);//98
		//byte b3 = b1+b2;//错误 byte相加先变成int类型

		char d = 'c';
		char f = 'c' + 1;//99+1=100 -> 'd'

		System.out.println('a' + 1 + "hello");//98hello
		System.out.println(f + "hello");//dhello

		/**
		 * 总结：
		 * 算数运算：byte short char 做运算，先转int，再做运算
		 * 常量一样，但是常量的结果会自动转型
		 * byte num=10+9；//隐藏的转型
		 * num=num+10；//变量相加不会自动转型，错误num+10 int类型 类型提升
		 * char c=‘a’+1；//int类型98 英藏的转型 char98 = ‘b'
		 * System.out.println('a' + 1 );//没有任何转型 所以输出为98
		 * 
		 * ++ 前置++ 先+1再运算 后置++ 先运算再+1
		 * int num=10；
		 * int c=++num；//c=11 num=11
		 * int c=num++；//c=10 num=11
		 * */

	}
}
