package com.ttq.interfaceDemo;

import java.io.Serializable;

/**
 * 类实现接口 implements 就要全部实现接口的抽象方法，不能全部实现，那么这个类就是抽象类
 * 类继承类/抽象类 extends
 * 		接口和抽象类的区别
 * 			1.接口和抽象类一样都不能实例化对象，都是多态的方式实例化子类或者实现类对象
 * 				StudentService s=new StudentServiceImp1（）；多态
 * 			 多态：父类引用指向子类对象或者接口引用指向实现类对象
 * 			2.抽象类里面有构造方法，给子类实例化对象使用：子类实例化对象要先实例化父类对象
 * 			  接口没有构造方法，实现类实例化对象无需实例化接口对象
 * 			3.单继承多实现：java是类单继承，一个子类只能有一个父亲，实现多个接口
 * 			4.接口可以继承接口，多继承
 * */
public class StudentServiceImp1 implements StudentService, Serializable {

	@Override
	public void showInfor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showInfor1() {
		// TODO Auto-generated method stub

	}

	@Override
	public void findById(int id) {
		// TODO Auto-generated method stub

	}

}

interface s extends StudentService, Serializable {

}