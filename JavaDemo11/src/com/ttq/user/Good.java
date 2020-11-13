package com.ttq.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Good {
	//商品名
	private String name;
	//价格
	private double price;
	//数量
	private int num;

	@Override
	public String toString() {
		return name + "\t" + price + "\t" + num;
	}

}
