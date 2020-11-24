package com.ttq.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ttq.db.Employee;
import com.ttq.util.JDBCUtil;

public class EmployeeDao1 {
	//按照月薪排序 按照入职时间排序 根据月薪的维度查询（下界，上界，部门） 查询10部门2000-6000的员工列表
	public void OrderBySal() {
		//加载驱动，创建连接
		Connection connection = JDBCUtil.getConnection();
		//编写sql
		String sql = "select * from tb_emp order by sal";
		Statement statement = null;
		ResultSet set = null;
		try {
			//创建Statement
			statement = connection.createStatement();
			//发送并执行
			set = statement.executeQuery(sql);
			//解析结果集
			ArrayList<Employee> employees = new ArrayList<Employee>();
			while (set.next()) {
				Employee employee = new Employee(set.getInt("empno"), set.getString(2), set.getString(3), set.getInt(4),
						set.getDate(5), set.getDouble("sal"), set.getDouble("comm"), set.getInt("did"));
				employees.add(employee);
			}
			System.out.println("员工列表：");
			employees.forEach(System.out::println);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭连接
			JDBCUtil.close(connection, statement, set);
		}
	}

	public void OrderByHiredate() {
		//加载驱动，创建连接
		Connection connection = JDBCUtil.getConnection();
		//编写sql
		String sql = "select * from tb_emp order by hiredate";
		Statement statement = null;
		ResultSet set = null;
		try {
			//创建Statement
			statement = connection.createStatement();
			//发送并执行
			set = statement.executeQuery(sql);
			//解析结果集
			ArrayList<Employee> employees = new ArrayList<Employee>();
			while (set.next()) {
				Employee employee = new Employee(set.getInt("empno"), set.getString(2), set.getString(3), set.getInt(4),
						set.getDate(5), set.getDouble("sal"), set.getDouble("comm"), set.getInt("did"));
				employees.add(employee);
			}
			System.out.println("员工列表：");
			employees.forEach(System.out::println);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭连接
			JDBCUtil.close(connection, statement, set);
		}
	}

	public void selectByChoiceSalAndDid(double up, double down, int did) {
		//加载驱动，创建连接
		Connection connection = JDBCUtil.getConnection();
		//编写sql
		String sql = "select * from tb_emp where sal between " + down + " and " + up + " and did=" + did;
		Statement statement = null;
		ResultSet set = null;
		try {
			//创建Statement
			statement = connection.createStatement();
			//发送并执行
			set = statement.executeQuery(sql);
			//解析结果集
			ArrayList<Employee> employees = new ArrayList<Employee>();
			while (set.next()) {
				Employee employee = new Employee(set.getInt("empno"), set.getString(2), set.getString(3), set.getInt(4),
						set.getDate(5), set.getDouble("sal"), set.getDouble("comm"), set.getInt("did"));
				employees.add(employee);
			}
			System.out.println("员工列表：");
			employees.forEach(System.out::println);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭连接
			JDBCUtil.close(connection, statement, set);
		}
	}
}
