package com.ttq.reader;

import java.io.*;

//字符流的作用就是处理中文乱码，有中文的地方，我们用字符流
public class ReaderDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream("class.txt"));
			//字符流，一个个字符读取 中文乱码解决
			char[] array = new char[1024];
			int len = -1;
			while ((len = reader.read(array)) != -1) {
				System.out.println(new String(array, 0, len));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
