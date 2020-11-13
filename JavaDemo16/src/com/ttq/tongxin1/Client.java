package com.ttq.tongxin1;

public class Client {

	public static void main(String[] args) {//主线程要执行就开
		// TODO Auto-generated method stub
		Tongxin tongxin = new Tongxin();

		//接口只有方法，直接匿名内部类，没有必要实现接口，new实现类对象
		//		new Thread(new Runnable() {
		//
		//			@Override
		//			public void run() {
		//				// TODO Auto-generated method stub
		//				tongxin.showWord();
		//			}
		//		}).start();
		new Thread(() -> {//子线程，和主线程抢cpu，  word 输出10次，每次3行
			// TODO Auto-generated method stub
			for (int i = 0; i < 10; i++) {
				tongxin.showWord();
			}
		}).start();
		//main方法里的代码是主线程的代码，hello输出是10次 每次输出2行
		for (int i = 0; i < 10; i++) {//优先级高
			tongxin.showHello();//主线程执行
		}

		//wait（） notify（） flag标识来判断我什么时候执行，执行中会被打算，加锁，在实行中不丢cpu
	}
}
