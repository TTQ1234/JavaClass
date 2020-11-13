package com.ttq.exercise1;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SavingAccount s1 = new SavingAccount("123", "张三");
		System.out.println(s1.getId());

		CreditAccount account = new CreditAccount("123", "张三", 1000.0);
		System.out.println(account.getName());
	}

}
