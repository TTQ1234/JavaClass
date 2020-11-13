package com.ttq.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.ttq.entity.Student;
import com.ttq.service.StudentService;
import com.ttq.util.ObjectUtil;

public class StudentServiceImp1 implements StudentService {
	private ArrayList<Student> studentList = null;

	public static StudentServiceImp1 getStudentServiceImp1() {
		return studentServiceImp1;
	}

	private static final StudentServiceImp1 studentServiceImp1 = new StudentServiceImp1();

	private StudentServiceImp1() {
		// TODO Auto-generated constructor stub
		studentList = ObjectUtil.fileToObject("studet.txt");
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		studentList.add(student);
		ObjectUtil.objectToFile(studentList, "studet.txt");
		return true;
	}

	@Override
	public boolean deleteStudent(int sid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == sid) {
				studentList.remove(i);
				flag = true;
				break;
			}
		}
		if (flag) {
			ObjectUtil.objectToFile(studentList, "studet.txt");
			return true;
		}
		System.out.println("没有找到该学生");
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
			ObjectUtil.objectToFile(studentList, "studet.txt");
			return true;
		}
		System.out.println("没有找到该学生");
		return false;
	}

	@Override
	public String[] showAllStudent() {
		// TODO Auto-generated method stub
		//studentList.forEach(System.out::println);
		String[] stu = new String[studentList.size()];
		for (int i = 0; i < studentList.size(); i++) {
			stu[i] = studentList.get(i).toString() + "\n";
		}
		return stu;
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
		//		studentList.forEach(System.out::println);
	}

	@Override
	public void showAllStudentOrderByAge() {
		// TODO Auto-generated method stub
		Collections.sort(studentList, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				int sort = Integer.valueOf(o1.getAge()).compareTo(o2.getAge());
				if (sort == 0) {
					Integer.valueOf(o1.getId()).compareTo(o2.getId());
				}
				return sort;
			}
		});
		//		studentList.forEach(System.out::println);
	}

	@Override
	public void showAllStudentOrderByRegisterTime() {
		// TODO Auto-generated method stub
		Collections.sort(studentList, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				int timeSort = o1.getRegisterTime().compareTo(o2.getRegisterTime());
				if (timeSort == 0) {
					Integer.valueOf(o1.getId()).compareTo(o2.getId());
				}
				return timeSort;
			}
		});
		//		studentList.forEach(System.out::println);
	}

}
