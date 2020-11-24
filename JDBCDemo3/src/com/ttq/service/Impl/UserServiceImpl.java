package com.ttq.service.Impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ttq.dao.StopDao;
import com.ttq.dao.UserDao;
import com.ttq.dao.Impl.StopDaoImpl;
import com.ttq.dao.Impl.UserDaoImpl;
import com.ttq.entity.Car;
import com.ttq.entity.Stop;
import com.ttq.entity.User;
import com.ttq.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	private StopDao stopDao = new StopDaoImpl();

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		if (userDao.selectByUsername(user.getUname()) != null) {
			System.out.println("用户名已存在");
			return false;
		}
		return userDao.insertUser(user);
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.selectByUsernameAndPassword(username, password);
	}

	@Override
	public boolean park(int cid, LinkedList<String> locations) {
		// TODO Auto-generated method stub
		//locations 空车位，停了车，车位移走
		Stop stop = new Stop(cid, locations.removeFirst());
		boolean f = stopDao.insertStop(stop);
		return f;
	}

	@Override
	public boolean out(int cid, LinkedList<String> locations) {
		// TODO Auto-generated method stub
		//查看停车信息，获得停车的开始时间
		Stop carStop = stopDao.selectByCidAndEndTimeIsNull(cid);
		Date endTime = new Date();
		int hours = (int) ((endTime.getTime() - carStop.getBeginTime().getTime()) / (1000 * 60 * 60));
		double money = hours > 3 ? (hours - 3) * 2 : 0;
		money = money > 20 ? 20 : money;
		return stopDao.updateStopByEndTimeAndHourAndMoney(cid, new Date(), hours, money);
	}

	@Override
	public List<Car> getOrder(int uid) {
		// TODO Auto-generated method stub
		List<Car> carList = stopDao.selectCarByUid(uid);
		for (Car car : carList) {
			List<Stop> stopList = stopDao.selectOrderList(car.getCid());
			car.setStopList(stopList);
		}
		return carList;
	}

	//显示没有入库的车
	@Override
	public List<Car> getNotParkCar(int uid) {
		// TODO Auto-generated method stub
		return stopDao.selectCarNotStop(uid);
	}

}
