package com.ttq.objectIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectClient {
	/**
	 * 反序列化：文件读成对象 ObjectInputStream
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectInputStream inputStream = null;
		//没有办法判断存了多少个用户
		try {
			inputStream = new ObjectInputStream(new FileInputStream("user.txt"));
			User user = (User) inputStream.readObject();
			System.out.println(user);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
