package com.ttq.scoket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入：");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine().trim();
		Socket socket = null;
		BufferedWriter writer = null;
		BufferedReader reader = null;
		BufferedOutputStream outputStream = null;
		try {
			socket = new Socket("127.0.0.1", 9000);//服务器的ip和端口号
			//写到socket
			//			outputStream = new BufferedOutputStream(socket.getOutputStream());
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			writer.write(line);//写到socket
			writer.flush();//刷新缓冲区
			System.out.println(reader.readLine());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
