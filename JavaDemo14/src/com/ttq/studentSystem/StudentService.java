package com.ttq.studentSystem;

/*
 * 学生业务*/
public interface StudentService {
	//添加学生
	boolean addStudent(Student student);

	//删除学生
	boolean deleteStudent(int sid);

	//修改学生信息(年龄)
	boolean updateStudentAge(int sid, int age);

	//查询全部的学生
	void showAllStudent();

	//按照学生的id排序
	void showAllStudentOrderById();

	//按照学生的年龄排序
	void showAllStudentOrderByAge();

	//按照学生的入学时间排序
	void showAllStudentOrderByRegisterTime();
}
