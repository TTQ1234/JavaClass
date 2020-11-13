package com.ttq.bankSystem;

import java.util.Date;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account csy = new Account();
		csy.id = 12345678;
		csy.password = "980617";
		csy.name = "陈舒怡";
		csy.money = 3.5;
		csy.time = new Date();
		csy.showInfo();
		csy.saveMoney(1000);
		csy.showInfo();
		csy.withdrawMoney(1003.5);
		csy.showInfo();
	}

}
