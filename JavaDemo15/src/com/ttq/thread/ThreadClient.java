package com.ttq.thread;

/**
 * Thread 线程类，具体类
 * 		java有个主线程，main，如果没有先开线程，那么就一个主线程
 * 				后台线程：GC，垃圾回收器
 * 子类
 * start() 开启线程，执行线程的run()
 * */
class MyThread extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName() + "你好");
	}
}

public class ThreadClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread thread = new MyThread();
		thread.start();
	}

}
