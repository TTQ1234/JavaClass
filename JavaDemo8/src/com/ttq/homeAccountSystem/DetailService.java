package com.ttq.homeAccountSystem;

public class DetailService {
	private Detail[] detailList = new Detail[100];
	private int count;
	private double remainder = 0;

	public void showDetailList() {
		if (count == 0) {
			System.out.println("暂无记录");
			return;
		}
		System.out.println("----------当前收支明细记录-----------");
		System.out.println("收支\t账户金额\t收支金额\t说   明");
		for (int i = 0; i < count; i++) {
			System.out.println(detailList[i]);
		}
		System.out.println("----------------------------------");
	}

	public void addDetail(Detail detail) {
		detailList[count++] = detail;
	}

	public double getRemainder() {
		return remainder;
	}

	public void setRemainder(double remainder) {
		this.remainder = remainder;
	}

}
