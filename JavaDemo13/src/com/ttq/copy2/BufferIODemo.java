package com.ttq.copy2;

import java.io.*;

public class BufferIODemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//把普通流装饰成高效流
		BufferedInputStream inputStream = null;
		BufferedOutputStream outputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream("1.txt"));
			outputStream = new BufferedOutputStream(new FileOutputStream("1c.txt"));
			byte[] array = new byte[100];
			int len = inputStream.read(array);
			while (len != -1) {
				outputStream.write(array, 0, len);
				len = inputStream.read(array);
			}
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
