package com.ttq.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ttq.db.Dept;
import com.ttq.db.Employee;
import com.ttq.util.JDBCUtil;

/**
 * Dao:Database Accecc Object
 * 对表的curd 增删改查
 * 
 * */
//添加部门 根据部门的id删除部门 修改部门的位置和部门名 根据部门名查询该部门员工列表
public class DeptDao {
	public boolean addDept(Dept dept) {
		//加载驱动，创建连接
		Connection connection = JDBCUtil.getConnection();
		//编写sql
		String sql = "insert into tb_dept values(" + dept.getDid() + ",'" + dept.getDname() + "','" + dept.getLoc()
				+ "')";
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

	public boolean deleteByDid(int did) {
		Connection connection = JDBCUtil.getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sql = "delete from tb_dept where did=" + did;
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

	public boolean updateByLocAndDname(String loc, String dname, int did) {
		Connection connection = JDBCUtil.getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sql = "update tb_dept set loc='" + loc + "',dname='" + dname + "' where did=" + did;
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

	public void selectEmpByDname(String dname) {
		//加载驱动，创建连接
		Connection connection = JDBCUtil.getConnection();
		//编写sql
		String sql = "select * from tb_emp e left join tb_dept d on e.did=d.did where d.dname='" + dname + "'";
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
