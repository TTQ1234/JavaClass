package com.ttq.tongxin1;

//相当于包子店
public class Tongxin {
	boolean flag = true;//主线程工作

	//打印hello2次
	public void showHello() {
		synchronized (this) {
			while (!flag) {//子线程工作，等待
				try {
					this.wait();//锁，wait（）
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 2; i++) {
				System.out.println("hello...");
			}
			flag = false;
			this.notifyAll();
		}
	}

	//打印word3次
	public void showWord() {
		synchronized (this) {
			while (flag) {//主线程工作，等待
				try {
					this.wait();//锁，wait（）
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 3; i++) {
				System.out.println("world...");
			}
			flag = true;
			this.notifyAll();
		}
	}
}
