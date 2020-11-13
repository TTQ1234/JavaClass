package com.ttq.thread;

class MyThread1 extends Thread {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "--->" + i);
		}
	}
}

public class ThreadClient2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//主线程直接开启//再开3个线程 4个执行的线程
		MyThread1 myThread1 = new MyThread1();
		myThread1.start();//开启新线程，和主线程抢cpu
		MyThread1 myThread2 = new MyThread1();
		myThread2.start();//开启新线程，和主线程抢cpu
		MyThread1 myThread3 = new MyThread1();
		myThread3.start();//开启新线程，和主线程抢cpu
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "++++++++++" + i);
		}
		//两个线程抢cpu，main的优先级高，main会先获得cpu
		//cpu调度线程的方式
	}

}
