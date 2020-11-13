package com.ttq.studentSystem;

import java.util.Date;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminService adminService = AdminServiceImp1.getAdminServiceImp1();
		StudentService studentService = StudentServiceImp1.getStudentService();
		Scanner scanner = new Scanner(System.in);
		System.out.println("*******欢迎进入学生管理系统********");
		menu(adminService, studentService, scanner);
	}

	private static void menu(AdminService adminService, StudentService studentService, Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("1.注册");
		System.out.println("2.登录");
		System.out.println("3.退出");
		System.out.println("请输入您的选择：");
		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 1:
			System.out.println("请输入管理员账号：");
			String username = scanner.nextLine().trim();
			System.out.println("请输入密码：");
			String password = scanner.nextLine().trim();
			Admin admin = new Admin(username, password);
			boolean b = adminService.register(admin);
			if (b) {
				System.out.println("注册成功");
			} else {
				System.out.println("注册失败");
			}
			break;
		case 2:
			System.out.println("请输入管理员账号：");
			username = scanner.nextLine().trim();
			System.out.println("请输入密码：");
			password = scanner.nextLine().trim();
			admin = adminService.login(username, password);
			if (admin != null) {
				System.out.println("登录成功");
				secondMenu(scanner, studentService, adminService);
			} else {
				System.out.println("登录失败");
			}
			break;
		case 3:
			System.exit(0);
			break;

		default:
			System.out.println("你输入的有误");
			break;
		}
	}

	private static void secondMenu(Scanner scanner, StudentService studentService, AdminService adminService) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1.添加学生");
			System.out.println("2.删除学生");
			System.out.println("3.修改学生年龄");
			System.out.println("4.查询全部学生");
			System.out.println("5.按照学生ID排序");
			System.out.println("6.按照学生年龄排序");
			System.out.println("7.按照学生入学时间排序");
			System.out.println("8.返回上一层");
			System.out.println("9.退出");
			System.out.println("请输入您的选择：");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				System.out.println("请输入学生ID：");
				int sid = Integer.parseInt(scanner.nextLine().trim());
				System.out.println("请输入学生姓名：");
				String name = scanner.nextLine().trim();
				System.out.println("请输入学生性别：");
				String sex = scanner.nextLine().trim();
				Gender gender = sex == "男" ? Gender.MAN : Gender.WOMAN;
				System.out.println("请输入学生年龄：");
				int age = Integer.parseInt(scanner.nextLine().trim());
				Student student = new Student(sid, name, gender, age, new Date());
				boolean b = studentService.addStudent(student);
				if (b) {
					System.out.println("添加成功");
				} else {
					System.out.println("添加失败");
				}
				break;
			case 2:
				System.out.println("请输入要删除的学生ID：");
				sid = Integer.parseInt(scanner.nextLine().trim());
				b = studentService.deleteStudent(sid);
				if (b) {
					System.out.println("删除成功");
				} else {
					System.out.println("删除失败");
				}
				break;
			case 3:
				System.out.println("请输入要修改的学生ID：");
				sid = Integer.parseInt(scanner.nextLine().trim());
				System.out.println("请输入修改的年龄：");
				age = Integer.parseInt(scanner.nextLine().trim());
				b = studentService.updateStudentAge(sid, age);
				if (b) {
					System.out.println("修改成功");
				} else {
					System.out.println("修改失败");
				}
				break;
			case 4:
				studentService.showAllStudent();
				break;
			case 5:
				studentService.showAllStudentOrderById();
				break;
			case 6:
				studentService.showAllStudentOrderByAge();
				break;
			case 7:
				studentService.showAllStudentOrderByRegisterTime();
				break;
			case 8:
				menu(adminService, studentService, scanner);
				return;
			case 9:
				System.exit(0);
				break;

			default:
				System.out.println("您输入的有误");
				break;
			}
		}
	}
}
