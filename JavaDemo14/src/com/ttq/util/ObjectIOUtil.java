package com.ttq.util;

import java.io.*;
import java.util.ArrayList;

/**
 * 工具类，将任何对象序列化到文件和反序列化成对象
 * 		泛型：在定义这个类，为了保证通用性，加形式符号代替
 * 		<T> 泛型，用T代替之后真实的类型
 * 
 *  工具类中的方法建议静态的，类名.*** 
 * */
public class ObjectIOUtil<T> {
	//对象->文件
	public static <T> void ObjectToFile(ArrayList<T> list, String fileName) {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
			outputStream.writeObject(list);
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

	//文件->对象
	public static <T> ArrayList<T> fileToObject(String fileName) {
		ObjectInputStream inputStream = null;
		ArrayList<T> list = new ArrayList<T>();
		try {
			inputStream = new ObjectInputStream(new FileInputStream(fileName));
			list = (ArrayList<T>) inputStream.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}
		return list;
	}
}
