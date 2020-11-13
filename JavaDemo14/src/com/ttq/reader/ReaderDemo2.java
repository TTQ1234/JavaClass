package com.ttq.reader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReaderDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请开始输入：");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine().trim();
		FileWriter writer = null;
		//字符输出流
		try {
			writer = new FileWriter("text.txt");
			while (!line.equals("end")) {
				writer.write(line);//char[] ->字符串
				line = scanner.nextLine().trim();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
