package com.ttq.homeAccountSystem;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetailService detailService = new DetailService();
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------家庭收支记账软件----------");
		while (true) {
			Menu(scanner, detailService);
		}
	}

	private static void Menu(Scanner scanner, DetailService detailService) {
		// TODO Auto-generated method stub
		System.out.println("1.收支明细");
		System.out.println("2.登记收入");
		System.out.println("3.登记支出");
		System.out.println("4.退   出");
		System.out.println("请选择（1-4）：");
		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 1:
			//收支明细
			detailService.showDetailList();
			break;
		case 2:
			//登记收入
			registerDetail(scanner, detailService, 1);
			break;
		case 3:
			//登记支出
			registerDetail(scanner, detailService, 2);
			break;
		case 4:
			//退出
			System.exit(0);
			break;

		default:
			System.out.println("您输入的不正确");
			break;
		}
	}

	private static void registerDetail(Scanner scanner, DetailService detailService, int flag) {
		// TODO Auto-generated method stub

		if (flag == 1) {
			System.out.println("本次收入金额：");
			double money = Double.parseDouble(scanner.nextLine().trim());
			System.out.println("本次收入说明：");
			String statement = scanner.nextLine().trim();
			Income income = new Income(money, statement);
			income.setWays("收入");
			detailService.setRemainder(detailService.getRemainder() + money);
			income.setBalance(detailService.getRemainder());
			detailService.addDetail(income);
			System.out.println("登记成功");
		} else {
			System.out.println("本次支出金额：");
			double money = Double.parseDouble(scanner.nextLine().trim());
			System.out.println("本次支出说明：");
			String statement = scanner.nextLine().trim();
			Pay pay = new Pay(money, statement);
			pay.setWays("支出");
			detailService.setRemainder(detailService.getRemainder() - money);
			pay.setBalance(detailService.getRemainder());
			detailService.addDetail(pay);
			System.out.println("登记成功");
		}
	}

}
