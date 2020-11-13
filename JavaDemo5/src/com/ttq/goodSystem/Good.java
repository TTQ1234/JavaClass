package com.ttq.goodSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Good {
	private String goodName;
	private double price;
	private int num;

	public void show() {
		System.out.println(this.goodName + "\t" + this.price + "\t" + this.num);

	}
}
