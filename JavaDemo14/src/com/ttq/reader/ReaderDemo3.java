package com.ttq.reader;

import java.io.*;

public class ReaderDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("开始书写：");
		BufferedWriter writer = null;
		BufferedReader reader = null;
		//高效字符流写
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new BufferedWriter(new FileWriter("read.txt"));
			String line = reader.readLine();
			while (!line.equals("end")) {
				writer.write(line);
				writer.newLine();
				writer.flush();
				line = reader.readLine();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
