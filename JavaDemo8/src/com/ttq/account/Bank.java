package com.ttq.account;

/**
 * 银行：账号数组：普通账号，信用账号
 * 
 * 单例模式
 * */
public class Bank {

	private Account[] accountLis = new Account[100];
	private int count;
	private static final Bank bank = new Bank();

	//bank静态属性的构造方法
	public static Bank getBank() {
		return bank;
	}

	private Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	//开户
	public void createAccount(Account account) {//形参，可能是基本储蓄，可能是信用储蓄
		accountLis[count++] = account;
		if (account instanceof SavingAccount) {
			System.out.println("基本储蓄开户成功");
		} else {
			System.out.println("信用储蓄开户成功");
		}
	}

	//显示所有的账号信息
	public void showAccountList() {
		for (int i = 0; i < count; i++) {
			System.out.println(accountLis[i]);//多态 数组中 账户类型是不一样的
			//全部调用孩子toString方法
		}
	}

	//存款
	public void saveMoney(Account account, double money) {
		account.deposite(money);
	}

	//取款
	public void getMoney(Account account, double money) {
		account.widthdraw(money);
	}

	//登录
	public Account login(long id, String password) {
		for (int i = 0; i < count; i++) {
			Account account = accountLis[i];
			if (account.getId() == id && account.getPassword().equals(password)) {
				return account;
			}
		}
		System.out.println("该账户不存在");
		return null;
	}
}
