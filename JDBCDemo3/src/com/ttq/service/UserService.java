package com.ttq.service;

import java.util.LinkedList;
import java.util.List;

import com.ttq.entity.Car;
import com.ttq.entity.User;

/**
 * 用户业务接口
 * */
public interface UserService {
	//注册(查询用户名是否存在  添加用户)
	boolean register(User user);

	//登录（根据用户名和密码查询用户）
	User login(String username, String password);

	//租车位  插入stop（判断 cid 是否已经存在并且结束时间为null 不能租）
	boolean park(int cid, LinkedList<String> locations);

	//出车位 更新tb_stop endTime money hour
	boolean out(int cid, LinkedList<String> locations);

	//查看历史订单 select 多表查询
	List<Car> getOrder(int uid);

	//查看没有入库的车
	List<Car> getNotParkCar(int uid);
}
