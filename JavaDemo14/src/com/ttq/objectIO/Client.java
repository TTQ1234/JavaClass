package com.ttq.objectIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//实例化user对象，序列化文件中
		ObjectOutputStream outputStream = null;
		User user = new User("张三", "123", 20);
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream("user.txt"));
			outputStream.writeObject(user);
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

}
