package com.ttq.client;

import java.io.*;
import java.net.Socket;
import java.util.Date;

import com.ttq.entity.Admin;
import com.ttq.entity.Gender;
import com.ttq.entity.Student;
import com.ttq.service.impl.AdminServiceImpl;
import com.ttq.service.impl.StudentServiceImp1;
import com.ttq.util.ReaderUtil;

/*
 * 服务器处理的业务，多线程
 * 	服务器处理客户端的，输入客户端
 */
public class ServerThread extends Thread {//实现runnable；继承thread；线程池
	private Socket socket;//客户端

	public ServerThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		//与客户端交互的方法
		try {
			showMenu(socket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//显示页面
	public void showMenu(Socket socket) throws IOException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		//		writer.write(str);
		//		writer.flush();
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		AdminServiceImpl adminServiceImpl = AdminServiceImpl.getAdminService();
		while (true) {
			String str = "**********欢迎进入学生管理系统**********\n1.登陆\n2.注册\n3.退出\n请输入您的选择：\n";
			ReaderUtil.write(writer, str);
			String choice = ReaderUtil.read(reader);
			//			System.out.println(choice);
			switch (choice) {
			case "1":
				ReaderUtil.write(writer, "请输入用户名\n");
				String name = ReaderUtil.read(reader);//获取用户名
				ReaderUtil.write(writer, "请输入密码\n");
				String password = ReaderUtil.read(reader);//获取密码
				Admin admin = adminServiceImpl.login(name, password);
				if (admin != null) {
					ReaderUtil.write(writer, "登录成功\n");

					secondMenu(writer, reader);

				} else {
					ReaderUtil.write(writer, "用户名或密码错误\n");
				}
				break;
			case "2":
				ReaderUtil.write(writer, "请输入用户名\n");
				name = ReaderUtil.read(reader);//获取用户名
				ReaderUtil.write(writer, "请输入密码\n");
				password = ReaderUtil.read(reader);//获取密码
				admin = new Admin(name, password);
				boolean flag = adminServiceImpl.register(admin);
				if (flag) {
					ReaderUtil.write(writer, "注册成功\n");
				} else {
					ReaderUtil.write(writer, "注册失败\n");
				}
				break;
			case "3":
				break;

			default:
				break;
			}
		}

		//		System.out.println(reader.readLine());//获得客户端发送的选择
		//		writer.close();
		//		ReaderUtil.write(socket, str);
		//		String choice = ReaderUtil.read(socket);//读取客户端发送的数据
		//		System.out.println(choice);
	}

	private void secondMenu(BufferedWriter writer, BufferedReader reader) throws IOException {
		// TODO Auto-generated method stub
		StudentServiceImp1 studentService = StudentServiceImp1.getStudentServiceImp1();
		while (true) {
			String str = "1.添加学生\n2.删除学生\n3.修改学生年龄\n4.查询全部学生\n5.按照学生ID排序\n6.按照学生年龄排序\n7.按照学生入学时间排序\n8.返回上一层\n9.退出\n请输入您的选择：\n";
			ReaderUtil.write(writer, str);
			String choice = ReaderUtil.read(reader);
			//System.out.println(choice);
			switch (choice) {
			case "1"://添加学生
				ReaderUtil.write(writer, "请输入学生ID：\n");
				int sid = Integer.parseInt(ReaderUtil.read(reader));
				ReaderUtil.write(writer, "请输入学生姓名：\n");
				String name = ReaderUtil.read(reader);
				ReaderUtil.write(writer, "请输入学生性别：\n");
				Gender gender = ReaderUtil.read(reader).equals("男") ? Gender.MAN : Gender.WOMAN;
				ReaderUtil.write(writer, "请输入学生年龄：\n");
				int age = Integer.parseInt(ReaderUtil.read(reader));
				Student student = new Student(sid, name, gender, age, new Date());
				boolean b = studentService.addStudent(student);
				if (b) {
					ReaderUtil.write(writer, "添加成功\n");
				} else {
					ReaderUtil.write(writer, "添加失败\n");
				}
				break;
			case "2"://删除学生
				ReaderUtil.write(writer, "请输入要删除的学生ID：\n");
				sid = Integer.parseInt(ReaderUtil.read(reader));
				b = studentService.deleteStudent(sid);
				if (b) {
					ReaderUtil.write(writer, "删除成功\n");
				} else {
					ReaderUtil.write(writer, "删除失败\n");
				}
				break;
			case "3"://修改学生年龄
				ReaderUtil.write(writer, "请输入要修改的学生ID：\n");
				sid = Integer.parseInt(ReaderUtil.read(reader));
				ReaderUtil.write(writer, "请输入修改的年龄：\n");
				age = Integer.parseInt(ReaderUtil.read(reader));
				b = studentService.updateStudentAge(sid, age);
				if (b) {
					ReaderUtil.write(writer, "修改成功\n");
				} else {
					ReaderUtil.write(writer, "修改失败\n");
				}
				break;
			case "4"://查询全部学生
				String[] stu = new String[100];
				stu = studentService.showAllStudent();
				ReaderUtil.write(writer, stu.length);
				//System.out.println(stu.length);
				for (int i = 0; i < stu.length; i++) {
					ReaderUtil.write(writer, stu[i]);
				}
				break;
			case "5"://按照学生ID排序
				studentService.showAllStudentOrderById();
				stu = new String[100];
				ReaderUtil.write(writer, stu.length);
				stu = studentService.showAllStudent();
				for (int i = 0; i < stu.length; i++) {
					ReaderUtil.write(writer, stu[i]);
				}
				break;
			case "6"://按照学生年龄排序
				studentService.showAllStudentOrderByAge();
				stu = new String[100];
				ReaderUtil.write(writer, stu.length);
				stu = studentService.showAllStudent();
				for (int i = 0; i < stu.length; i++) {
					ReaderUtil.write(writer, stu[i]);
				}
				break;
			case "7"://按照学生年入学时间排序
				studentService.showAllStudentOrderByRegisterTime();
				stu = new String[100];
				ReaderUtil.write(writer, stu.length);
				stu = studentService.showAllStudent();
				for (int i = 0; i < stu.length; i++) {
					ReaderUtil.write(writer, stu[i]);
				}
				break;
			case "8":
				showMenu(socket);
				return;
			case "9":
				break;
			default:
				break;
			}
		}

	}
}
