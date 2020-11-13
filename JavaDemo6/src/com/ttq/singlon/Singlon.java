package com.ttq.singlon;

/**
 * 
 * 本类用来演示
 * 
 * 1)构造方法私有化
 * 2)内部自己实例化对象（static）
 * 3)构造get方法
 * 
 * 作者: ttq
 * 日期:	2020年10月15日 下午3:11:23
 */
public class Singlon {
	//自己内部私有化一个自己的对象
	public static Singlon s1 = new Singlon();

	public static Singlon getS1() {

		return s1;
	}

	private Singlon() {//构造方法私有化

	}
}
