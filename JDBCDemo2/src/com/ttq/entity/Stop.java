package com.ttq.entity;

import java.util.Date;

import com.ttq.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 停车信息
 * */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Stop {
	private Integer tid;
	private Integer cid;//外键
	private Date beginTime;
	private Date endTime;
	private Integer hours;
	private Double money;
	private String loc;

	public Stop(Integer cid, String loc) {
		super();
		this.cid = cid;
		this.loc = loc;
		this.beginTime = new Date();//当前时间
	}

	@Override
	public String toString() {
		String begin = "";
		String end = "";
		if (beginTime != null) {
			begin = DateUtil.dateToString(beginTime);
		}
		if (endTime != null) {
			end = DateUtil.dateToString(endTime);
		}
		return tid + "\t" + cid + "\t" + begin + "\t" + end + "\t" + hours + "\t" + money + "\t" + loc;
	}

}
