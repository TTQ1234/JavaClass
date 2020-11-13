package com.ttq.decoration;

public class NewPhone extends Phone {
	//重写，子类重写父类的方法，增强父类的方法
	/**
	 * 高耦合：继承关系耦合度高，解耦
	 * 关系：泛化 继承 高
	 * 		实现 类实现接口 抽象无耦合
	 * 		关联 一个类是另一个类属性 中
	 * 		依赖 方法里面实例化另一个类对象 弱
	 * 
	 * 旧手机还是老手机，都有call功能
	 * 		提取接口，规定手机具备的功能
	 * 耦合度：开发过程中的耦合
	 * 		多人合作
	 * */
	//继承变成关联，耦合降低一级
	//完全解耦
	private Phone oldPhone;

	public void call() {
		oldPhone.call();
		System.out.println("彩铃");
	}

	public NewPhone(Phone oldPhone) {
		super();
		this.oldPhone = oldPhone;
	}

	public static void main(String[] args) {
		NewPhone newPhone = new NewPhone(new OldPhone());
		newPhone.call();
	}
}
