package com.ttq.inputstreamDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 1.开输入通道
 * 2.读取，字节数组，准备字节数组
 * 3.关通道
 * */
public class InPutStreamDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//utf-8占3个字节，一个一个字节走，一个中文3个字节，劈开成3段，就乱码
		//2014b 如果卡在两辆车之间，可能会乱，所以可能会乱，可能不乱
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream("/Users/tianqi/Desktop/学号姓名/index.html");
			//byte[] 准备 建议1024的倍数
			byte[] array = new byte[1024];
			//5.4kb 最后一趟数组不满，个数位400b
			int len = inputStream.read(array);//读到数组中，len上的字节个数
			while (len != -1) {
				System.out.print(new String(array, 0, len));//字节数组->字符串 new String(byte[] bytes)
				//数组里面有多少个字节，就读取多少个字节
				len = inputStream.read(array);
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
