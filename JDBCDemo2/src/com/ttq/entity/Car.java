package com.ttq.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 车
 * */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
	private Integer cid;
	private String cnum;
	private String brand;
	private Integer uid;//外键

	private List<Stop> stopList = new ArrayList<Stop>();//停车订单

	public Car(Integer cid, String cnum, String brand, Integer uid) {
		super();
		this.cid = cid;
		this.cnum = cnum;
		this.brand = brand;
		this.uid = uid;
	}

}
