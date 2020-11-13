package com.ttq.sort2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Good {
	private String name;
	private double price;
	private int num;

	@Override
	public String toString() {
		return name + "\t" + price + "\t" + num;
	}
}
