package com.ttq.demo;

/**
 * 本类用来演示
 * 变量的类型：成员变量/属性/实例变量和局部变量的区别
 *    1)在内存中的位置，age存在堆，局部变量num存在栈里
 *    2）在类中的位置，属性在类里，局部变量在方法里
 *    3）初始化：属性可以不初始化，赋予默认值，而局部变量一定要初始化
 *    4）生命周期：属性什么时候创建，什么时候销毁
 *               new 对象的时候创建，GC销毁，没有栈指向该对象空间时
 *    			 局部变量什么时候穿件，什么时候销毁
 *    			 方法调用的时候创建局部变量
 *    			 方法结束的时候被销毁
 *        
 * 如果属性和局部变量同名，就近原则，用局部变量
 *         属性：属性就是成员变量，对象的特征
 *   this：本类对象，就是我的意思，this.变量名=属性 this.方法名=成员方法
 *        
 * 作者: ttq
 * 日期:	2020年10月13日 下午2:06:41
 */
public class Student {
	int age = 100;//成员变量/属性/实例变量
	int money = 1000;//属性

	public void show() {
		int num = 10;//方法里面的变量，num称为局部变量
		int age = 20;
		System.out.println(age);//20 就近原则
		System.out.println(this.age);//属性 代表我的
	}

	public void addMoney(int money) {
		this.money += money;
		//System.out.println(money);
	}

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.addMoney(20);
		System.out.println(s1.money);
	}
}
