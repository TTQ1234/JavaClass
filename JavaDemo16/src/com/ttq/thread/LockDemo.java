package com.ttq.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 本类用来演示
 * 
 * 三个窗口卖100张票
 * 		Lock 类 JDK1.5之后提出的，优化同步代码 Synchronized关键字
 * 		互斥和同步的区别
 * 		ReentrantLock和Synchronized的区别
 * 			1）Synchronized是关键字，加锁和开锁的操作都由JVM来执行，那么JVM负担重
 * 			   ReentrantLock  lock()上锁 unlock()开锁， 锁的开关都由程序员做，JVM负担减轻
 * 			2）ReentrantLock 可以中断。如果死锁问题，Synchronized一直死死锁住
 * 			   ReentrantLock如果长期请不到锁，放弃请求锁，结束程序
 * 			3）ReentrantLock公平的，FIFO，哪个线程先来请求执行代码，先获得锁
 * 			   Synchronized抢占式的，不公平的，看操作系统的调度
 * 			   ReentrantLock性能好，但是Synchronized时间早，相对还是为主，慢慢的用ReentrantLock替换
 * 
 * 作者: ttq
 * 日期:	2020年10月29日 上午9:07:41
 */
class Window extends Thread {
	private static int ticket = 100;//100张票	
	private static ReentrantLock lock = new ReentrantLock();//锁对象唯一

	public void run() {
		while (ticket > 0) {
			//			synchronized ("a") {
			lock.lock();//上锁
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "正在卖" + ticket + "张票");
				ticket--;
			}
			//			}
			lock.unlock();//开锁
		}
	};
}

public class LockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window window1 = new Window();
		Window window2 = new Window();
		Window window3 = new Window();
		window1.start();
		window2.start();
		window3.start();
	}

}
