package com.ttq.runnable;

import java.util.concurrent.locks.ReentrantLock;

class MyRunable implements Runnable {
	private int ticket = 100;
	private ReentrantLock lock = new ReentrantLock();//只有一个对象，不需要用static

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (ticket > 0) {
			lock.lock();//上锁
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "正在卖" + ticket + "张票");
				ticket--;
			}
			lock.unlock();//开锁
		}
	}

}

public class RunnableDemo1 {
	public static void main(String[] args) {//优选
		MyRunable runable = new MyRunable();//线程的traget
		Thread thread1 = new Thread(runable);
		Thread thread2 = new Thread(runable);
		Thread thread3 = new Thread(runable);
		thread1.setName("窗口一");
		thread2.setName("窗口二");
		thread3.setName("窗口三");
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
