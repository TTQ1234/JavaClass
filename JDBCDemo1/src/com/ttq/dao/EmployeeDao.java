package com.ttq.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.ttq.db.Employee;
import com.ttq.util.JDBCUtil;

public class EmployeeDao {
	//查询所有的员工
	public void selectAll() {
		//加载驱动，创建连接
		Connection connection = JDBCUtil.getConnection();
		//编写sql
		String sql = "select * from tb_emp";
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

	//根据用户名查询员工
	public void selectLikeEname(String name) {
		//加载驱动，创建连接
		Connection connection = JDBCUtil.getConnection();
		//编写sql
		String sql = "select * from tb_emp where ename like '%" + name + "%'";
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

	//根据用户的id查询员工
	public void selectById(int id) {
		//加载驱动，创建连接
		Connection connection = JDBCUtil.getConnection();
		//编写sql
		String sql = "select * from tb_emp where empno=" + id;
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

	//根据did部门号查询员工
	public void selectByDid(int did) {
		//加载驱动，创建连接
		Connection connection = JDBCUtil.getConnection();
		//编写sql
		String sql = "select * from tb_emp where did =" + did;
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

	//添加员工
	public boolean insertEmployee(Employee employee) {
		//加载驱动，创建连接
		Connection connection = JDBCUtil.getConnection();
		//编写sql
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String shiredate = format.format(employee.getHireDate());
		String sql = "insert into tb_emp values(" + employee.getEmpno() + ",'" + employee.getEname() + "','"
				+ employee.getJob() + "'," + employee.getMgr() + ",'" + shiredate + "'," + employee.getSal() + ","
				+ employee.getComm() + "," + employee.getDid() + ")";
		Statement statement = null;

		try {
			//创建Statement
			statement = connection.createStatement();
			//执行sql修改
			int count = statement.executeUpdate(sql);
			return count > 0 ? true : false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭连接
			JDBCUtil.close(connection, statement, null);
		}
		return false;
	}

	//删除员工
	public boolean deleteById(int empno) {
		Connection connection = JDBCUtil.getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sql = "delete from tb_emp where empno=" + empno;
			int count = statement.executeUpdate(sql);
			return count > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭连接
			JDBCUtil.close(connection, statement, null);
		}
		return false;
	}

	//修改员工的sal和comm
	public boolean updateSalAndComm(int empno, double sal, double comm, String job) {
		Connection connection = JDBCUtil.getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sql = "update tb_emp set sal=" + sal + ",comm=" + comm + ",job='" + job + "' where empno=" + empno;
			int count = statement.executeUpdate(sql);
			return count > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭连接
			JDBCUtil.close(connection, statement, null);
		}
		return false;
	}

}
