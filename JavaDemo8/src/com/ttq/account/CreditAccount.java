package com.ttq.account;

import java.text.SimpleDateFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 信用储蓄
 * 
 * */
@NoArgsConstructor
@Getter
@Setter
public class CreditAccount extends Account {
	private double ceiling = 10000;//投资
	private double qianKuan = 0;

	public CreditAccount(String password, String name) {
		super(password, name);
		// TODO Auto-generated constructor stub
	}

	//取款方法重写
	@Override
	public void widthdraw(double money) {
		// TODO Auto-generated method stub
		if (money < 0) {
			System.out.println("取款金额不正确");
			return;
		}
		if (getBalance() + ceiling - qianKuan < money) {
			System.out.println("余额不足");
			return;
		}
		if (getBalance() > money) {
			setBalance(getBalance() - money);
			return;
		}
		double ceilingMoney = money - getBalance();
		setBalance(0);
		this.qianKuan += ceilingMoney;
		System.out.println("取款成功，透支了" + ceilingMoney);

	}

	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sopen = simpleDateFormat.format(getOpenDate());
		return getId() + "\t" + getPassword() + "\t" + getName() + "\t" + getBalance() + "\t" + sopen + "\t" + ceiling
				+ "\t" + qianKuan;
	}

	@Override
	public void deposite(double money) {
		// TODO Auto-generated method stub
		if (money < 0) {
			System.out.println("存款金额不正确");
			return;
		}
		setBalance(getBalance() + money);
		System.out.println("存款成功");

	}

}
