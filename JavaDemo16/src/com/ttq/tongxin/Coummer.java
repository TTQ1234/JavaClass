package com.ttq.tongxin;

import java.util.Random;

public class Coummer implements Runnable {
	private BaoziStore baoziStore;

	public Coummer(BaoziStore baoziStore) {
		// TODO Auto-generated constructor stub
		this.baoziStore = baoziStore;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random random = new Random();
		int num = random.nextInt(10) + 1;
		baoziStore.buy(num);
	}

}
