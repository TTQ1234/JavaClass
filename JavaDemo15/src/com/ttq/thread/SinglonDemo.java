package com.ttq.thread;

/**
 * 单例三部曲 
 * 			单例的饿汉模式：get方法时候已经有对象了，如果我们不调用get方法，那么对象盛昌，浪费空间，对象类加载的时候有
 * 			懒汉模式：在调用get方法的时候再实例化对象，取的时候在new对象，不用就浪费内存资源，但是第一次取的时候会先new对象，慢
 * 懒汉模式：线程不安全需要加锁
 * 		线程的不安全的条件：多线程 共享对象singlon 单例 修改new
 * 		cpu是原子性，一次只保证一行代码的执行，所以业务执行的时候可能丢cpu，容易出现线程不安全
 * 加锁之后，cpu只能执行一个线程，哪怕线程现在暂停，sleep（1000），cpu也不丢，必须执行完劫夺，所以程序执行的效率慢
 * 安全的代价就是慢，StringBuffer执行效率慢，StringBuilder执行快
 * */
class Singlon {//方法是静态的，锁对象是类名.class（Singlon.class）
	public static synchronized Singlon getSinglon() {//缺点：第一次访问慢       // 同步化

		if (singlon == null) {
			//				try {
			//					Thread.sleep(10000);
			//				} catch (InterruptedException e) {
			//					// TODO Auto-generated catch block
			//					e.printStackTrace();
			//				}
			singlon = new Singlon();

		}
		return singlon;
	}

	private static Singlon singlon;

	private Singlon() {

	}
}

//多线程开单例，学生管理系统，业务类：多个客户同时操作学生管理系统，业务类有没有不安全的问题
class MyThread2 extends Thread {

	@Override
	public void run() {
		Singlon singlon = Singlon.getSinglon();
		System.out.println(Thread.currentThread().getName() + "----->" + singlon);
	}

}

public class SinglonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread2 thread1 = new MyThread2();
		thread1.start();
		MyThread2 thread2 = new MyThread2();
		thread2.start();
		MyThread2 thread3 = new MyThread2();
		thread3.start();
		//三个线程 获得Singlon对象，singlon是电力，不管哪个线程来都获得相同的对象
		//银行 账户列表 A客户来操作 B客户来操作 C客户来操作 都是使用该账户列表，一个银行 银行是唯一的
	}

}
