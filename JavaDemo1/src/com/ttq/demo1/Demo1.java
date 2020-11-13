package com.ttq.demo1;

/**
 * 文档注释
 * @author Tianqi
 * @date  2020年10月9日 上午9:56:40
 * @describe 我的第一个java程序
 * 
 * 一个java文件里面可以有
 * 1）多格雷，以打括号为界
 * 2）同一个包下面类名不能重复
 * 3）一个源码文件只能有一个主类（public修饰），并且主类必须和文件同名
 * 4）主类里面才能有main方法，程序的入口，其他类里面有不可执行
 * 说明，不建议一个文件里面有多个类
 * 写代码随时ctrl（command）+s，会格式化（代码正确，错误不格式）
 */
public class Demo1 {
	/**
	 * main方法是任何语言程序的入口，程序首先执行他，如果其他方法/函数，也必须要在main方法中调用才能执行
	 * main徐碧前面加public static
	 * void 返回值，没有返回值
	 * 		function add（）{
	 * }
	 * args 接受程序的键入输入值，可能输入多个，所以用数组接受，string字符串数组（现在已经不用）
	 * 
	 * String srgs[] 也行
	 * */

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		//原码与十进制交换，补码是存在计算机内， 补码=原码除去符号位取反（反码）+1

		/**0代表正数，1代表负数
		*byte max = 0111 1111 = 1000 0000 -1 =127
		*short max = 0111 1111 1111 1111=2^15-1
		*int max = 0111 1111 1111 1111 1111 1111 1111 1111=2^31-1
		*long max = 2^63-1
		*byte min = 1000 0000(补码)-0000 0001 = 1111 1111（取反）=1000 0000 =-2^7
		*short min = 1000 0000 0000 0000 = -2^15
		*int min = 1000 0000 0000 0000 0000 0000 0000 0000=-2^31
		*long min = -2^63
		*byte (-2^7~2^7-1)
		*short (-2^15~2^15-1)
		*int (-2^31~2^31-1)
		*long (-2^63~2^63-1)
		*/

		//byte num =255;//Type mismatch: cannot convert from int to byte

	}

}

/*class Student {
	
}

class Teacher {

}*/