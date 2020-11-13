package com.ttq.copy;

import java.io.*;

//文件夹复制
public class DirectoryCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		File src = new File(pathname);
		//		File desc = new File(pathname);
		//		DirectorCopy(src, desc);
		System.out.println("复制完成");
	}

	//文件夹复制
	public static void DirectorCopy(File dirSrc, File dirDesc) {
		if (!dirDesc.exists()) {
			dirDesc.mkdir();//目标文件夹不存在，创建文件夹
		}
		//先获得文件夹里面的内容
		File[] chileFiles = dirSrc.listFiles();//文件夹里面的一级目录
		for (File child : chileFiles) {//一级目录
			//获得孩子的名字，然后再dirDesc里面创建一个一样的
			File descChild = new File(dirDesc, child.getName());//
			if (child.isFile()) {//源文件是文件，复制里面的内容
				FileCopy(child, descChild);//内容复制
			} else {
				//文件夹 递归处理
				DirectorCopy(child, descChild);
			}
		}

	}

	//文件复制，将src的内容写一份到desc中，写数据IO流
	public static void FileCopy(File src, File desc) {
		//和src创建读入 输入流
		//和desc创建写入 输出流
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream = new FileInputStream(src);
			fileOutputStream = new FileOutputStream(desc);
			byte[] array = new byte[1024];
			int len = -1;
			while ((len = fileInputStream.read(array)) != -1) {
				fileOutputStream.write(array, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
