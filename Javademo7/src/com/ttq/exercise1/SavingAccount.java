package com.ttq.exercise1;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SavingAccount extends Account {//子类构造给父亲属性赋值，然后子类继承
	public SavingAccount(String password, String name) {
		super(password, name);//调用父亲构造,getter获得属性值
		// TODO Auto-generated constructor stub
	}

}
