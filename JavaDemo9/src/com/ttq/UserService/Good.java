package com.ttq.UserService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Good {
	//名称 价格 数量
	String goodName;
	double goodPrice;
	int goodCount;
	String statement;

	@Override
	public String toString() {
		return goodName + "\t" + goodPrice + "\t" + goodCount + "\t" + statement;
	}

}
