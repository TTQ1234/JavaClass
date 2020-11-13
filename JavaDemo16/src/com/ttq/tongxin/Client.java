package com.ttq.tongxin;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//做包子的target
		//毛包子的target
		BaoziStore baoziStore = new BaoziStore();
		Coummer coummer = new Coummer(baoziStore);
		Producer producer = new Producer(baoziStore);
		Thread com1 = new Thread(coummer);
		Thread com2 = new Thread(coummer);
		Thread com3 = new Thread(coummer);
		Thread pro = new Thread(producer);
		pro.start();
		com1.start();
		com2.start();
		com3.start();

	}

}
