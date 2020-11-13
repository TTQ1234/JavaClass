package com.ttq.goodSystem;

/**
 * 本类用来演示
 * 
 * 客户端
 * 作者: ttq
 * 日期:	2020年10月13日 上午11:11:05
 */
public class Client {
	public static void main(String[] args) {
		//实例化苹果对象，复杂类型的变量
		Good apple = new Good();
		//int num=10;//基本数据类型
		//		apple.goodName = "苹果";
		//		apple.num = 100;
		//		apple.price = 10.8;
		//		apple.showInfo();

		//橘子的特征
		Good orange = new Good();
		//		orange.goodName = "橘子";
		//		orange.num = 99;
		//		orange.price = 5.9;
		//		orange.showInfo();

		//香蕉(有参构造很方便)
		Good banana = new Good("香蕉", 100, 9.8);
		banana.showInfo();
		banana.setPrice(1.8);
		banana.showInfo();
		System.out.println(banana.getPrice());

		/**
		 * 一个标注的类：属性私有化，提供setter和getter方法，提供构造方法（无参和全部参数构造）
		 * 
		 * 定义学生类
		 * 学号 int
		 * 姓名 name
		 * 年龄 age
		 * 性别 sex
		 * 实例化3个学生
		 * 
		 */
	}

}
