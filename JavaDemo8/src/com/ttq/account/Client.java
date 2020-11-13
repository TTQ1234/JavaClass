package com.ttq.account;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		Account a1 = new Account("123", "ttq");
		//		System.out.println(a1);//调用toString
		//只要一个类写了toString 那么输出对象名就会调用此方法 按照方法中返回的字符串执行

		Scanner scanner = new Scanner(System.in);
		Bank bank = Bank.getBank();
		//		Bank bank2 = bank;
		//		System.out.println(bank == bank2);
		System.out.println("******欢迎进入银行系统******");
		while (true) {
			Menu(scanner, bank);
		}
	}

	private static void Menu(Scanner scanner, Bank bank) {
		// TODO Auto-generated method stub
		System.out.println("1.开户");
		System.out.println("2.查看账户列表");
		System.out.println("3.登录");
		System.out.println("4.退出");
		System.out.println("请输入您的选择：");
		int choice = Integer.parseInt(scanner.nextLine().trim());

		choiceMenu(scanner, bank, choice);
	}

	private static void choiceMenu(Scanner scanner, Bank bank, int choice) {
		// TODO Auto-generated method stub
		switch (choice) {
		case 1:
			//开户方法
			createAccount(scanner, bank);
			break;
		case 2:
			bank.showAccountList();
			break;
		case 3:
			//登录
			login(scanner, bank);
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("您输入的有误");
			break;
		}
	}

	private static void login(Scanner scanner, Bank bank) {
		// TODO Auto-generated method stub
		System.out.println("请输入ID：");
		long id = Long.parseLong(scanner.nextLine().trim());
		System.out.println("请输入账户密码：");
		String password = scanner.nextLine().trim();
		Account account = bank.login(id, password);
		if (account != null) {

			sendMenu(scanner, bank, account);

			return;
		}
		System.out.println("查无该账号或id密码不正确");
	}

	private static void sendMenu(Scanner scanner, Bank bank, Account account) {
		while (true) {
			// TODO Auto-generated method stub
			System.out.println("1.存钱");
			System.out.println("2.取钱");
			System.out.println("3.查看透支额度");
			System.out.println("4.查看已使用的透支额度");
			System.out.println("5.返回上一层");
			System.out.println("6.退出");
			System.out.println("请输入您的选择：");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				System.out.println("请输入存款金额：");
				double money = Double.parseDouble(scanner.nextLine().trim());
				bank.saveMoney(account, money);
				break;
			case 2:
				System.out.println("请输入取款金额：");
				double money1 = Double.parseDouble(scanner.nextLine().trim());
				bank.getMoney(account, money1);
				break;
			case 3:
				if (account instanceof CreditAccount) {
					double ceiling = ((CreditAccount) account).getCeiling();
					System.out.println("该账号的透支额度为：" + ceiling);
				} else {
					System.out.println("该账户类型无透支额度");
				}
				break;
			case 4:
				if (account instanceof CreditAccount) {
					double qiankuan = ((CreditAccount) account).getQianKuan();
					System.out.println("该账号的已透支额度为：" + qiankuan);
				} else {
					System.out.println("该账户类型无透支额度");
				}
				break;

			case 5:
				Menu(scanner, bank);
				return;//该函数结束  不会再次进入二级页面
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("您输入的有误");
				break;
			}
		}
	}

	public static void createAccount(Scanner scanner, Bank bank) {
		// TODO Auto-generated method stub
		System.out.println("1.基本储蓄账户");
		System.out.println("2.信用储蓄账户");
		System.out.println("请输入您的选择：");
		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 1:
			//基本储蓄
			createAccountSavingOrCredit(scanner, bank, 1);
			break;
		case 2:
			//信用储蓄
			createAccountSavingOrCredit(scanner, bank, 2);
			break;

		default:
			break;
		}
	}

	//形参值为1开基本储蓄，形参值为2开信用储蓄
	public static void createAccountSavingOrCredit(Scanner scanner, Bank bank, int flag) {
		// TODO Auto-generated method stub
		System.out.println("请输入账户密码");
		String password = scanner.nextLine().trim();
		System.out.println("请输入开户真实姓名");
		String name = scanner.nextLine().trim();

		if (flag == 1) {
			SavingAccount savingAccount = new SavingAccount(password, name);
			bank.createAccount(savingAccount);//多态 Account account给子类对象可以的，常用的多态写法
		} else {
			CreditAccount creditAccount = new CreditAccount(password, name);
			bank.createAccount(creditAccount);
			System.out.println("默认开户的透支额度为10000，是否修改（Y/N）");
			String update = scanner.nextLine().trim();
			switch (update) {
			case "Y":
			case "y":
				System.out.println("请输入设置的透支额度：");
				double ceiling = Double.parseDouble(scanner.nextLine().trim());
				creditAccount.setCeiling(ceiling);
				System.out.println("透支修改成功");
				break;
			case "N":
			case "n":
				//不修改
				break;

			default:
				System.out.println("您输入的不正确");
				break;
			}
		}
	}

}
