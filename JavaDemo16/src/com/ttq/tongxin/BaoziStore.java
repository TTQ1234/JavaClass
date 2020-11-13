package com.ttq.tongxin;

import java.util.LinkedList;

public class BaoziStore {
	private int max = 100;
	private LinkedList<Object> baoziList = new LinkedList<Object>();//包子列表

	//买包子(消费者)
	public void buy(int num) {
		synchronized (baoziList) {
			while (baoziList.size() < num) {
				System.out.println("不能买包子");
				//进入消费者等待
				try {
					baoziList.wait();//object的方法，消费者等待，锁是什么，就锁.**s
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//包子够了，买包子
			for (int i = 0; i < num; i++) {
				baoziList.removeFirst();//移除一个包子
			}
			System.out.println(Thread.currentThread().getName() + "该线程买了" + num + "个包子，还剩" + baoziList.size() + "个包子");
			//唤醒其他阻塞的线程
			baoziList.notifyAll();

		}
	}

	//卖包子（生产者） 每次生产100
	public void produce() {
		synchronized (baoziList) {//生产者和消费者的锁是用一把
			while (baoziList.size() + 50 > max) {//不生产 最多放100个包子，随机看
				System.out.println("库存满");
				try {
					baoziList.wait();//消费阻塞
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 50; i++) {
				baoziList.add(new Object());
			}
			System.out.println("包子生产了50个，快来买");
			//唤醒其他线程 消费者
			baoziList.notifyAll();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
