package com.ttq.dao;

import java.util.Date;
import java.util.List;

import com.ttq.entity.Car;
import com.ttq.entity.Stop;

public interface StopDao {
	//查看该用户没有入库的车牌
	List<Car> selectCarNotStop(int uid);

	//插入Stop(入库) 停车
	boolean insertStop(Stop stop);

	//离开
	boolean updateStopByEndTimeAndHourAndMoney(int cid, Date endTime, int hours, double money);

	//查看该车的停车状态
	Stop selectByCidAndEndTimeIsNull(int cid);

	//查看历史订单
	List<Stop> selectOrderList(int cid);

	List<Car> selectCarByUid(int uid);
}
