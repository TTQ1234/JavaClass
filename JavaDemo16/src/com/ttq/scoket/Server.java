package com.ttq.scoket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端向服务器发消息 TCP/IP 百度服务器 qq服务器
 * */
//在你的机器上 ip是电脑的ip 服务器的端口号【软件】 0-65535
//服务器端口号
//接受客户端的信息 只能接受一个客户端的传端
public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Myrunable myrunable = new Myrunable();
		Thread ser1 = new Thread(myrunable);
		ser1.start();

	}
}

class Myrunable implements Runnable {
	String string1 = "1.登录\t2.注册\t3.退出";

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		System.out.println("服务器已启动");
		try {
			serverSocket = new ServerSocket(9000);
			while (true) {
				Socket socket = serverSocket.accept();
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				//				writer.write(string1);
				//				writer.flush();
				PrintWriter bufferedWriter = new PrintWriter(writer, true);
				bufferedWriter.println(string1);
				System.out.println(reader.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (serverSocket != null) {
					serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
