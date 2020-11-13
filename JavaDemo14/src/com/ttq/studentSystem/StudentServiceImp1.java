package com.ttq.studentSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.ttq.util.ObjectIOUtil;

public class StudentServiceImp1 implements StudentService {
	private ArrayList<Student> studentList = null;
	private static final StudentServiceImp1 studentService = new StudentServiceImp1();

	public static StudentServiceImp1 getStudentService() {
		return studentService;
	}

	private StudentServiceImp1() {
		// TODO Auto-generated constructor stub
		studentList = ObjectIOUtil.fileToObject("student.txt");
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		studentList.add(student);
		ObjectIOUtil.ObjectToFile(studentList, "student.txt");
		return true;
	}

	@Override
	public boolean deleteStudent(int sid) {
		// TODO Auto-generated method stub
		boolean flag = false;//默认没有该学生
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == sid) {
				studentList.remove(i);
				flag = true;
				break;
			}
		}
		if (flag) {//更新文件
			ObjectIOUtil.ObjectToFile(studentList, "student.txt");
			return true;
		}
		System.out.println("该学生不存在");
		return false;
	}

	@Override
	public boolean updateStudentAge(int sid, int age) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == sid) {
				studentList.get(i).setAge(age);
				flag = true;
				break;
			}
		}
		if (flag) {

			ObjectIOUtil.ObjectToFile(studentList, "student.txt");
			return true;
		}
		System.out.println("该学生不存在");
		return false;
	}

	@Override
	public void showAllStudent() {
		// TODO Auto-generated method stub
		studentList.forEach(System.out::println);
	}

	@Override
	public void showAllStudentOrderById() {
		// TODO Auto-generated method stub
		Collections.sort(studentList, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.getId()).compareTo(o2.getId());
			}
		});
		studentList.forEach(System.out::println);
	}

	@Override
	public void showAllStudentOrderByAge() {
		// TODO Auto-generated method stub
		Collections.sort(studentList, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				int ageSort = Integer.valueOf(o1.getAge()).compareTo(o2.getAge());
				if (ageSort == 0) {
					return Integer.valueOf(o1.getId()).compareTo(o2.getId());
				}
				return ageSort;
			}
		});
		studentList.forEach(System.out::println);
	}

	@Override
	public void showAllStudentOrderByRegisterTime() {
		// TODO Auto-generated method stub
		Collections.sort(studentList, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stubint ageSort = Integer.valueOf(o1.getAge()).compareTo(o2.getAge());
				int daySort = o1.getRegisterTime().compareTo(o2.getRegisterTime());
				if (daySort == 0) {
					return Integer.valueOf(o1.getId()).compareTo(o2.getId());
				}
				return daySort;
			}
		});
		studentList.forEach(System.out::println);
	}
}
