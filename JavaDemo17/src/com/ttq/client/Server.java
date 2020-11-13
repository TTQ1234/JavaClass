package com.ttq.client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("服务器已启动！");
		//客户端链接，对应一个socket
		while (true) {
			Socket socket = serverSocket.accept();//链接客户端
			new ServerThread(socket).start();//链接一个客户端创建一个线程，线程处理与该客户的业务
			//与服务器的操作
		}
	}
}
