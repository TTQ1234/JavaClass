package com.ttq.copy2;

import java.io.*;
import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//  public static final InputStream in = null; 标准输入流，键盘输入
		//写到文件
		Scanner scanner = new Scanner(System.in);
		File file = new File("text.txt");
		try {
			file.createNewFile();
			writeFile(scanner, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void writeFile(Scanner scanner, File file) {
		//准备输出流，写文件
		BufferedOutputStream outputStream = null;
		try {
			outputStream = new BufferedOutputStream(new FileOutputStream(file));
			String line = "";
			while (!line.equals("end")) {
				System.out.println("请输入用户名");
				String name = scanner.nextLine().trim();
				System.out.println("请输入密码");
				String password = scanner.nextLine().trim();
				System.out.println("请输入年龄");
				String age = scanner.nextLine().trim();
				outputStream.write((name + "\t" + password + "\t" + age + "\n").getBytes());
				System.out.println("是否继续：（输入end结束，其他任意符号继续）");
				line = scanner.nextLine().trim();
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
		}
	}
}
