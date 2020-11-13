package com.ttq.runnable;

/**
 * 懒汉线程处理：cpu是原子性，不可分割的代码
 * */
class Singlon {

	private static Singlon singlon;//懒汉模式，get的时候再New对象

	private Singlon() {
	};

	public synchronized static Singlon getSinglon() {
		if (singlon == null) {//第一次没有，实例化对象
			singlon = new Singlon();
		}
		return singlon;
	}
}

class MyRunable1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Singlon singlon = Singlon.getSinglon();
		System.out.println(Thread.currentThread().getName() + "----" + singlon);
	}

}

public class RunableDemo2 {

	public static void main(String[] args) {//保证单例的懒汉模式线程安全，多并发下还是单例
		// TODO Auto-generated method stub
		MyRunable1 runable1 = new MyRunable1();
		Thread thread1 = new Thread(runable1);
		Thread thread2 = new Thread(runable1);
		Thread thread3 = new Thread(runable1);
		thread1.start();
		thread2.start();
		thread3.start();

	}

}
