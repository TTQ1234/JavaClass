package com.ttq.client;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.ttq.entity.Car;
import com.ttq.entity.Stop;
import com.ttq.entity.User;
import com.ttq.service.UserService;
import com.ttq.service.Impl.UserServiceImpl;

public class Client {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//车位
		LinkedList<String> list = new LinkedList<String>();
		for (int i = 1000; i <= 1100; i++) {
			list.add("车位:" + i);
		}
		UserService userService = new UserServiceImpl();
		System.out.println("*********欢迎停车********");
		while (true) {
			menu(scanner, userService, list);
		}
	}

	public static void menu(Scanner scanner, UserService userService, LinkedList<String> list) {
		System.out.println("1.注册");
		System.out.println("2.登录");
		System.out.println("3.退出");
		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 1:
			System.out.println("请输入用户名:");
			String name = scanner.nextLine().trim();
			System.out.println("请输入密码:");
			String password = scanner.nextLine().trim();
			boolean flag = userService.register(new User(null, name, password));
			if (flag) {
				System.out.println("注册正确");
			} else {
				System.out.println("注册失败");
			}
			break;
		case 2:
			System.out.println("请输入用户名:");
			name = scanner.nextLine().trim();
			System.out.println("请输入密码:");
			password = scanner.nextLine().trim();
			User user = userService.login(name, password);
			if (user != null) {
				sendMenu(scanner, userService, list, user);
			} else {
				System.out.println("用户名或密码错误");
			}
			break;
		case 3:
			System.exit(0);
			break;

		default:
			System.out.println("您输入的不正确");
			break;
		}
	}

	private static void sendMenu(Scanner scanner, UserService userService, LinkedList<String> list, User user) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1.停车");
			System.out.println("2.离开");
			System.out.println("3.查看历史停车记录");
			System.out.println("4.返回上一层");
			System.out.println("5.退出");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				List<Car> notParkCarList = userService.getNotParkCar(user.getUid());
				for (Car car : notParkCarList) {
					System.out.println(car);
				}
				System.out.println("请输入需要停车的id：");
				int cid = Integer.parseInt(scanner.nextLine().trim());
				boolean flag = userService.park(cid, list);
				if (flag) {
					System.out.println("停车成功");
				} else {
					System.out.println("停车失败");
				}
				break;
			case 2:
				System.out.println("请输入需要还车的id：");
				cid = Integer.parseInt(scanner.nextLine().trim());
				flag = userService.out(cid, list);
				if (flag) {
					System.out.println("出库成功");
				} else {
					System.out.println("出库失败");
				}
				break;
			case 3:
				List<Car> carList = userService.getOrder(user.getUid());
				System.out.println("历史订单：");
				for (Car car : carList) {
					System.out.println("\t\t" + car.getCid() + "\t" + car.getCnum() + "\t" + car.getBrand());
					List<Stop> stopList = car.getStopList();
					for (Stop stop : stopList) {
						System.out.println(stop);
					}
				}
				break;
			case 4:
				return;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("您输入的不正确");
				break;
			}
		}
	}

}
