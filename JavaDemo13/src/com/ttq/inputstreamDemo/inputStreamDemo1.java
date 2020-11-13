package com.ttq.inputstreamDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * inputStream 输入流父类，抽象的，文件数据读到内存
 * 			FileInputStream 文件输入流
 * 				read（）一个字节一个字节的读，当为-1代表读到文件的尾部
 * 				read（byte[] bytes）一个字节数组一个字节数组的读取，速度快，读取到-1，文件文档
 * 				建议数组的长度为1024的倍数，1kb的倍数
 * 			1）开通到
 * 			2）循环读取
 * 			3）关通到
 * 
 * */
public class inputStreamDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream("src/com/ttq/outputstreamDemo/OutPutStreamDemo1.java");
			//			int r = inputStream.read();
			//			int r1 = inputStream.read();
			//			int r2 = inputStream.read();
			//			int r3 = inputStream.read();
			//			System.out.println((char) r);//p
			//			System.out.println((char) r1);//p
			//			System.out.println((char) r2);//p
			//			System.out.println((char) r3);//p
			int r = inputStream.read();
			while (r != -1) {
				System.out.print((char) r);
				r = inputStream.read();
			}
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
