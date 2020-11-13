package com.ttq.thread;

/**
 * 第一个问题：可能多张相同的票 3张100
 * 第二个问题：可能卖到0和-1票
 * 线程不安全：StringBuffer Vector Hashtable 线程不安全
 * 线程不安全的条件：1.多线程 2.共享资源 3.对这个资源做了修改操作
 * 		cpu并发执行带来的问题，共享变量发生改变，并发执行让这个共享变量发生了不安全的变化
 * 线程不安全：三个条件必须满足：多线程，资源共享，修改操作，缺一就不会发生不安全的问题：ArrayList【发生的机会很少】
 * 解决：
 * 		修改操作：解决它  修改的加锁，不会丢cpu
 * 				锁：随意对象，必须是同一把锁
 * 加锁过程之后，就算其他线程获得cpu也没办法执行，必须锁和cpu都在的情况下才能执行，等执行完，放弃锁，放弃cpu，抢cpu，谁获得cpu谁就获得锁
 * */
class Window extends Thread {//t1,t2,t3全部就绪，抢cpu
	private static int ticket = 100;
	//	private static Object b = new Object();

	@Override
	public void run() {
		while (ticket > 0) {
			synchronized (Window.class) {//锁对象队医，必须是同一把锁,同步代码块
				// TODO Auto-generated method stub
				if (ticket > 0) {
					System.out.println(Thread.currentThread().getName() + "正在卖" + (101 - ticket) + "张");
					ticket--;
					//主动放弃cpu
					try {
						Thread.sleep(1);//线程休息1毫秒
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}

public class TicketDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window window = new Window();
		window.setName("窗口一");
		Window window1 = new Window();
		window1.setName("窗口二");
		Window window2 = new Window();
		window2.setName("窗口三");
		window.start();
		window1.start();
		window2.start();
	}

}
