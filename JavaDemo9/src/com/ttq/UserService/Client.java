package com.ttq.UserService;

import java.util.Random;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		UserService userService = new UserServiceImp1();
		while (true) {
			menu(scanner, userService);
		}
	}

	public static void menu(Scanner scanner, UserService userService) {
		System.out.println("----------欢迎来到用户业务系统----------");
		System.out.println("1.注册用户");
		System.out.println("2.登录");
		System.out.println("3.查看全部用户列表");
		System.out.println("4.退出");
		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 1:
			//注册用户
			createAccount(scanner, userService);
			break;
		case 2:
			//登录
			login(scanner, userService);
			break;
		case 3:
			//查看全部用户列表
			userService.showAll();
			break;
		case 4:
			//退出
			System.exit(0);
			break;
		default:
			System.out.println("您输入的有误");
			break;
		}
	}

	private static void login(Scanner scanner, UserService userService) {
		// TODO Auto-generated method stub
		System.out.println("请输入用户名[邮箱、手机号或QQ号]：");
		String name = scanner.nextLine().trim();
		System.out.println("请输入密码[不少于8位]：");
		String password = scanner.nextLine().trim();
		User user = userService.login(name, password);
		if (user == null) {
			System.out.println("查无该账号");
		} else {
			loginMenu(scanner, user, userService);
		}

	}

	private static void createAccount(Scanner scanner, UserService userService) {
		boolean flag = true;
		while (flag) {
			// TODO Auto-generated method stub
			System.out.println("请输入用户名[邮箱、手机号或QQ号]：");
			String name = scanner.nextLine().trim();
			String email = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
			String phoneNum = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
			String qq = "[1-9][0-9]{4,}";
			String scode = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
			String code = "";
			if (name.matches(email) || name.matches(phoneNum) || name.matches(qq)) {
				System.out.println("请输入密码[不少于8位]：");
				String password = scanner.nextLine().trim();
				if (password.length() >= 8) {
					while (code.length() <= 6) {
						Random random = new Random();
						code += scode.charAt(random.nextInt(scode.length()));
					}
					System.out.println(code);
					System.out.println("请输入验证码：");
					String checkCode = scanner.nextLine().trim();
					if (checkCode.equalsIgnoreCase(code)) {
						User user = new User(name, password);
						userService.createUser(user);
						System.out.println("注册用户成功");
						flag = false;
					} else {
						System.out.println("您输入的验证码不正确，请重新注册[输入“q”退出注册]");
					}
				} else {
					System.out.println("您输入的密码格式不正确，请重新注册[输入“q”退出注册]");
				}
			} else if (name.equals("q")) {
				flag = false;
			} else {
				System.out.println("您输入的用户名格式不正确，请重新注册[输入“q”退出注册]");
			}

		}

	}

	private static void loginMenu(Scanner scanner, User user, UserService userService) {
		// TODO Auto-generated method stub
		//已经登录成功
		while (true) {
			System.out.println("1.查看该用户信息");
			System.out.println("2.修改该账户余额");
			System.out.println("3.查看商品列表");
			System.out.println("4.购买");
			System.out.println("5.查看已购买商品列表");
			System.out.println("6.返回上一层");
			System.out.println("7.退出");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				//查看用户信息
				userService.selectShow(user);
				break;
			case 2:
				//修改账户余额
				userService.editBalance(scanner, user);
				break;
			case 3:
				//查看商品列表
				showAllGoodList(user);
				break;
			case 4:
				//购买
				buyGood(scanner, user);
				break;
			case 5:
				//查看已购买商品列表
				showOwnGoodList(user);
				break;
			case 6:
				//返回上一层
				menu(scanner, userService);
				return;
			case 7:
				//退出
				System.exit(0);
				break;
			default:
				System.out.println("您输入的有误");
				break;
			}

		}
	}

	private static void showOwnGoodList(User user) {
		// TODO Auto-generated method stub
		for (int i = 0; i < user.goodList.size(); i++) {
			if (user.goodList.get(i).getStatement().equals("已购买")) {
				System.out.println(user.goodList.get(i));
			}
		}
	}

	private static void buyGood(Scanner scanner, User user) {
		// TODO Auto-generated method stub
		System.out.println("请输入要购买的商品：");
		String goodName = scanner.nextLine().trim();
		for (int i = 0; i < user.goodList.size(); i++) {
			if (user.goodList.get(i).getGoodName().equals(goodName)) {
				System.out.println("请输入购买数量");
				int count = Integer.parseInt(scanner.nextLine().trim());
				if (count <= user.goodList.get(i).getGoodCount()) {
					System.out.println("购买成功");
					user.goodList.get(i).setGoodCount(user.goodList.get(i).getGoodCount() - 1);
					user.goodList.get(i).setStatement("已购买");
					return;
				} else {
					System.out.println("该商品数量不足");
				}
			}
		}
		System.out.println("暂无该商品");

	}

	private static void showAllGoodList(User user) {
		// TODO Auto-generated method stub
		for (int i = 0; i < user.goodList.size(); i++) {
			System.out.println(user.goodList.get(i));
		}
	}
}
