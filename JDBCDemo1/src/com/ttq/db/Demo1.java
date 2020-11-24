package com.ttq.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * JDBC的步骤：
        1）加载驱动（第三方的一些实现类）
        2）开连接
        3）创建Statement，编写sql并发生
        4）执行sql
        5）如果有结果集，解析结果集
        6）关连接
        
    问题：
    	1)导包 可能是第三方的，可能是java的，建议全部是java
    	2）8用的是新包com.mysql.cj.jdbc.Driver 8可以用5的
    	   5用的旧包com.mysql.jdbc.Driver
    	3）url：重点 ip：端口号/数据库名
    	4）用户名和密码
 * */

public class Demo1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//加载驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		//获得连接 数据库的地址	数据库的用户名 数据库的密码
		//url jdbc:mysql://ip:3360/库名
		String url = "jdbc:mysql://localhost:3306/employee?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
		String password = "ttq971117";
		String username = "root";
		Connection connection = DriverManager.getConnection(url, username, password);
		//System.out.println(connection);
		//编写sql
		String sql = "select * from tb_emp";
		//发送到数据库端，准备statement
		Statement statement = connection.createStatement();//在连接上创建Statement
		//发送sql并执行，返回结果集
		ResultSet set = statement.executeQuery(sql);
		//解析结果集 set和itator迭代器很像，指针，指向结果集的第一个的前一位
		ArrayList<Employee> employees = new ArrayList<Employee>();
		while (set.next()) {//后面有没有
			//取一行，一个个单元格解析 get***（列号/列名【建议如果列数多用列名】）
			//一行一个对象，对象的属性值和单元格一一对象
			Employee employee = new Employee(set.getInt("empno"), set.getString(2), set.getString(3), set.getInt(4),
					set.getDate(5), set.getDouble("sal"), set.getDouble("comm"), set.getInt("did"));
			//读取一行，封装成一行，添加到集合
			employees.add(employee);
		}
		employees.forEach(System.out::println);
		if (set != null) {
			set.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

}
