package com.ttq.dao;

import java.util.Date;

import org.junit.Test;

import com.ttq.db.Dept;
import com.ttq.db.Employee;

/**
 * 测试方法不能有参数，也不能有返回值
 * 加@Test 注解
 * */
public class EmployeeTest {
	EmployeeDao employeeDao = new EmployeeDao();
	EmployeeDao1 EmployeeDao1 = new EmployeeDao1();
	DeptDao DeptDao = new DeptDao();

	@Test
	public void test1() {
		employeeDao.selectAll();
	}

	@Test
	public void test2() {
		employeeDao.selectLikeEname("S");
	}

	@Test
	public void test3() {
		employeeDao.selectById(7369);
	}

	@Test
	public void test4() {
		employeeDao.selectByDid(10);
	}

	@Test
	public void test5() {
		Employee employee = new Employee(2000, "李四", "测试", null, new Date(), 10000.0, 50000.0, 30);
		System.out.println(employeeDao.insertEmployee(employee));
	}

	@Test
	public void test6() {
		System.out.println(employeeDao.deleteById(2000));
	}

	@Test
	public void test7() {
		System.out.println(employeeDao.updateSalAndComm(7369, 3000, 4000, "worker"));
	}

	@Test
	public void testHomework1() {
		EmployeeDao1.OrderBySal();
	}

	@Test
	public void testHomework2() {
		EmployeeDao1.OrderByHiredate();
	}

	@Test
	public void testHomework3() {
		EmployeeDao1.selectByChoiceSalAndDid(6000, 2000, 10);
	}

	@Test
	public void testHomework4() {
		Dept dept = new Dept(50, "杂物", "常州");
		System.out.println(DeptDao.addDept(dept));
	}

	@Test
	public void testHomework5() {
		System.out.println(DeptDao.deleteByDid(10));
	}

	@Test
	public void testHomework6() {
		System.out.println(DeptDao.updateByLocAndDname("上海", "开发", 10));
	}

	@Test
	public void testHomework7() {
		DeptDao.selectEmpByDname("开发");
	}

	//作业：按照月薪排序 按照入职时间排序 根据月薪的维度查询（下界，上界，部门） 查询10部门2000-6000的员工列表
	//添加部门 根据部门的id删除部门 修改部门的位置和部门名 根据部门名查询该部门员工列表
	//单元测试
}
