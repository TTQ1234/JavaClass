package com.ttq.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.ttq.util.ReaderUtil;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("127.0.0.1", 9999);
		Scanner scanner = new Scanner(System.in);
		//获得服务器给我发送的数据
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		menu(scanner, socket);
		//		System.out.println(reader.readLine());//**欢迎进入**
		//		System.out.println(reader.readLine());//1.登陆
		//		System.out.println(reader.readLine());//2.注册
		//		System.out.println(reader.readLine());//3.退出
		//		System.out.println(reader.readLine());//请输入您的选择
		socket.close();
	}

	/**
	 * @param scanner
	 * @param socket
	 * @throws IOException
	 */
	private static void menu(Scanner scanner, Socket socket) throws IOException {
		// TODO Auto-generated method stub
		//		ReaderUtil.read(reader);//输出服务器发送的界面
		//		int choice = Integer.parseInt(scanner.nextLine().trim());//输入的请求
		//		//写到服务器
		//		ReaderUtil.write(socket, choice + "");
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		while (true) {
			ReaderUtil.readShow(reader, 5);
			//		System.out.println(reader.readLine());//读服务器发送的界面
			//		System.out.println(reader.readLine());//读服务器发送的界面
			//		System.out.println(reader.readLine());//读服务器发送的界面
			//		System.out.println(reader.readLine());//读服务器发送的界面
			//		System.out.println(reader.readLine());//读服务器发送的界面
			int choice = Integer.parseInt(scanner.nextLine().trim());//输入选择
			ReaderUtil.write(writer, choice + "\n");//将选择写给服务器
			switch (choice) {
			case 1:
				ReaderUtil.readShow(reader, 1);
				String name = scanner.nextLine().trim() + "\n";
				ReaderUtil.write(writer, name);
				ReaderUtil.readShow(reader, 1);
				String password = scanner.nextLine().trim() + "\n";
				ReaderUtil.write(writer, password);
				String line = ReaderUtil.read(reader);
				if (line.trim().equals("登录成功")) {
					secondMenu(reader, writer, scanner, socket);
				} else {
					System.out.println("登录失败");
				}
				break;
			case 2:
				ReaderUtil.readShow(reader, 1);
				name = scanner.nextLine().trim() + "\n";
				ReaderUtil.write(writer, name);
				ReaderUtil.readShow(reader, 1);
				password = scanner.nextLine().trim() + "\n";
				ReaderUtil.write(writer, password);
				ReaderUtil.readShow(reader, 1);
				break;
			case 3:
				System.exit(0);
				break;

			default:
				System.out.println("您输入的有误");
				break;
			}
		}
		//		String line = ReaderUtil.read(reader);
		//		if (line.trim().equals("退出")) {
		//			System.exit(0);
		//		} else if (line.trim().equals("您输入的不正确")) {
		//			System.out.println("您输入的不正确");
		//		} else if (line.trim().equals("请输入用户名")) {
		//			String name = scanner.nextLine().trim() + "\n";
		//			ReaderUtil.write(writer, name);//写给服务器用户名
		//
		//		} else if (line.trim().equals("请输入密码")) {
		//			String password = scanner.nextLine().trim() + "\n";
		//			ReaderUtil.write(writer, password);//写给服务器密码
		//
		//		}

		//		writer.write(choice + "\n");//客户端将选择写到服务器
		//		writer.flush();
	}

	private static void secondMenu(BufferedReader reader, BufferedWriter writer, Scanner scanner, Socket socket)
			throws IOException {
		// TODO Auto-generated method stub
		while (true) {
			ReaderUtil.readShow(reader, 10);
			int choice = Integer.parseInt(scanner.nextLine().trim());
			ReaderUtil.write(writer, choice + "\n");
			switch (choice) {
			case 1:
				ReaderUtil.readShow(reader, 1);
				String sid = scanner.nextLine().trim() + "\n";
				ReaderUtil.write(writer, sid);
				ReaderUtil.readShow(reader, 1);
				String name = scanner.nextLine().trim() + "\n";
				ReaderUtil.write(writer, name);
				ReaderUtil.readShow(reader, 1);
				String sex = scanner.nextLine().trim() + "\n";
				ReaderUtil.write(writer, sex);
				ReaderUtil.readShow(reader, 1);
				String age = scanner.nextLine().trim() + "\n";
				ReaderUtil.write(writer, age);
				ReaderUtil.readShow(reader, 1);
				break;
			case 2:
				ReaderUtil.readShow(reader, 1);
				sid = scanner.nextLine().trim() + "\n";
				ReaderUtil.write(writer, sid);
				ReaderUtil.readShow(reader, 1);
				break;
			case 3:
				ReaderUtil.readShow(reader, 1);
				sid = scanner.nextLine().trim() + "\n";
				ReaderUtil.write(writer, sid);
				ReaderUtil.readShow(reader, 1);
				age = scanner.nextLine().trim() + "\n";
				ReaderUtil.write(writer, age);
				ReaderUtil.readShow(reader, 1);
				break;
			case 4:
				int num = ReaderUtil.readInt(reader);
				ReaderUtil.readShow(reader, num);
				break;
			case 5:
				num = ReaderUtil.readInt(reader);
				ReaderUtil.readShow(reader, num);
				break;
			case 6:
				num = ReaderUtil.readInt(reader);
				ReaderUtil.readShow(reader, num);
				break;
			case 7:
				num = ReaderUtil.readInt(reader);
				ReaderUtil.readShow(reader, num);
				break;
			case 8:
				menu(scanner, socket);
				return;
			case 9:
				System.exit(0);
				break;
			default:
				System.out.println("您输入的有误");
				break;
			}
		}
	}

}
