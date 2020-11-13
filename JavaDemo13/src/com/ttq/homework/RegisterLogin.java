package com.ttq.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RegisterLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		File file = new File("user.txt");
		while (true) {
			System.out.println("1.注册");
			System.out.println("2.登录");
			System.out.println("3.退出");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				try {
					file.createNewFile();
					writeFile(scanner, file);
					System.out.println("注册成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				readAndSplitFileByUser(scanner, file);
				break;
			case 3:
				System.exit(0);
				break;

			default:
				System.out.println("您输入的有误");
				break;
			}
		}

	}

	public static void writeFile(Scanner scanner, File file) {
		BufferedOutputStream outputStream = null;
		try {
			outputStream = new BufferedOutputStream(new FileOutputStream(file));
			String line = "";
			while (!line.equals("end")) {
				System.out.println("请输入用户名");
				String name = scanner.nextLine().trim();
				System.out.println("请输入密码");
				String password = scanner.nextLine().trim();
				outputStream.write((name + "\t" + password + "\n").getBytes());
				System.out.println("是否继续：（输入end结束，其他任意符号继续）");
				line = scanner.nextLine().trim();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	public static void readAndSplitFileByUser(Scanner scanner, File file) {
		BufferedInputStream inputStream = null;
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> passwordList = new ArrayList<String>();

		try {
			String line = "";
			String[] tmp = null;
			inputStream = new BufferedInputStream(new FileInputStream(file));
			byte[] array = new byte[1024];
			int len = inputStream.read(array);//读到数组中，len上的字节个数
			while (len != -1) {
				String userList = new String(array, 0, len);//字节数组->字符串 new String(byte[] bytes)
				//数组里面有多少个字节，就读取多少个字节
				len = inputStream.read(array);
				userList = userList.replace("\n", ";");

				String[] user = userList.split(";");
				for (int i = 0; i < user.length; i++) {
					tmp = user[i].split("\t");
					nameList.add(tmp[0]);
					passwordList.add(tmp[1]);
				}
			}

			System.out.println("请输入用户名");
			String name = scanner.nextLine().trim();
			System.out.println("请输入密码");
			String password = scanner.nextLine().trim();
			for (int i = 0; i < nameList.size(); i++) {
				if (nameList.get(i).equals(name) && passwordList.get(i).equals(password)) {
					System.out.println("登录成功");
					return;
				}

			}
			System.out.println("用户名或密码错误");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
