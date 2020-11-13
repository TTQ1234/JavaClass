package com.ttq.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 复制：文件是不是在磁盘（磁盘读到内存中），写到磁盘中
 * 读 输入流
 * 写 输出流
 * 内存一边读（源文件）一边写（复制的文件）
 * */
public class FileCopy1 {
	public static void main(String[] args) {
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream("/Users/tianqi/Desktop/1.jpg");
			outputStream = new FileOutputStream(
					"/Users/tianqi/Desktop/workspace/eclipse-workspace/JavaDemo13/copy/1.jpg");
			byte[] array = new byte[1024];
			int len = inputStream.read(array);//上车
			while (len != -1) {
				//读一次，写一次
				outputStream.write(array, 0, len);
				//System.out.println(new String(array, 0, len));
				len = inputStream.read(array);
			}
			System.out.println("复制成功");
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
