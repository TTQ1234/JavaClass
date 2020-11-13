package com.ttq.tongxin;

public class Producer implements Runnable {

	private BaoziStore baoziStore;

	public Producer(BaoziStore baoziStore) {
		// TODO Auto-generated constructor stub
		this.baoziStore = baoziStore;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		baoziStore.produce();
	}

}
