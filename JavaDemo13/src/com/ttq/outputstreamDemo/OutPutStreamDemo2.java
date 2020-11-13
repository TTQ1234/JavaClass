package com.ttq.outputstreamDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutPutStreamDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutputStream outputStream = null;
		//开通到
		try {
			outputStream = new FileOutputStream("demo1.txt", true);//true 代表追加 相对路径
			try {
				outputStream.write("\nmercy\t我很好".getBytes());//会覆盖
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
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
