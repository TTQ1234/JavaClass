package com.ttq.homeAccountSystem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 父类 抽象类
 * */
@NoArgsConstructor
@Getter
@Setter
public abstract class Detail {
	private String ways;
	private double balance;//余额
	private double money;//收支数
	private String statement;
	{
		this.balance = 0.0;
	}

	public Detail(double money, String statement) {
		super();
		this.money = money;
		this.statement = statement;
	}

	@Override
	public String toString() {
		return ways + "\t" + balance + "\t" + money + "\t" + statement;
	}

	//	public abstract void addDetail(double money, String statement);
}
