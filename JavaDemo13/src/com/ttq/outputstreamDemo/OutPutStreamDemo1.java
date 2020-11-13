package com.ttq.outputstreamDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * outputStream 输出流的父类，抽象类，内存写到磁盘
 *  FileOutputStream 写到文件
 *  	1）创建通道
 *  	2）写数据
 *  	3）关通道
 * */
public class OutPutStreamDemo1 {
	public static void main(String[] args) {
		FileOutputStream outputStream = null;
		try {
			//1.开通到
			outputStream = new FileOutputStream("/Users/tianqi/Desktop/workspace/eclipse-workspace/JavaDemo13/1.txt");
			//写数据
			try {
				outputStream.write(97);
				outputStream.write("今天天气真好".getBytes());
				outputStream.write("但我好痛苦".getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {//关闭通道，不管有没有异常，关闭通道
			if (outputStream != null) {
				try {
					//2.关通道
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
