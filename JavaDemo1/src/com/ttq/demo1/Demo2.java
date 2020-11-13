package com.ttq.demo1;

/**
 * 
 * 基本 数据类型（8个）
 * byte short int long float double char boolean
 * 输出：System.out.print();不换行
 * 		System.out.println();换行
 * */
public class Demo2 {
	public static void main(String[] args) {

		//常量 整数默认int 小数默认double
		//输出快捷键 syso
		//System.out.println(10000000000000);//The literal 10000000000000 of type int is out of range
		System.out.println(100000000);//默认int 4个字符
		System.out.println(100000000000000l);//long类型 8个字符
		System.out.println(12.4);//8个字符
		System.out.println(12.4f);//float 4个字符
		//二进制
		System.out.println(0b0101010);
		//八进制
		System.out.println(012344);
		//十六进制
		System.out.println(0x123ac74);
		//jdk1.7的新特性 下划线
		System.out.println(100_0000_00);// = 100000000

		//char 字符
		System.out.println("a");
		System.out.println("上课");
		//unicode码 java字符串 汉字转unicode码
		System.out.println('\u4e2d');//中
	}

}
