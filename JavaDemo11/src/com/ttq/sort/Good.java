package com.ttq.sort;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@EqualsAndHashCode
public class Good implements Comparable<Good> {//接口 自然排序接口
	private String name;
	private double price;
	private int num;

	@Override
	public String toString() {
		return name + "\t" + price + "\t" + num;
	}

	@Override
	public int compareTo(Good o) {//排序方法 0 相等 -1 我比你小 1 我比你大
		// TODO Auto-generated method stub
		//比较的是价格
		int order = Double.valueOf(this.price).compareTo(o.price);
		if (order == 0) {//价格相等
			//按照商品名排序
			return this.name.compareTo(o.name);//商品名升序排
		}
		return order;//double的升序
		//return Double.valueOf(o.price).compareTo(this.price);//double的降序
	}

}
