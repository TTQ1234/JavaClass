package com.ttq.interfaceDemo;

/**
 * 接口做架构的，业务骨架，所以他实在业务层，操作类的方法的提取
 * 类：实体类（属性为主） 操作类（业务类，一方法为主）【接口就是操作类/业务类的骨架搭建】
 * 
 * */
public interface StudentService {
	//可以有属性，不建议，一般接口里面不会出现属性
	public static final int max = 100;//必须是公开的静态的常量，也可以省略
	int min = 10;

	//抽象方法，访问权限必须是public
	public abstract void showInfor();

	public abstract void showInfor1();

	void findById(int id);//省去public abstract（常用）
}
