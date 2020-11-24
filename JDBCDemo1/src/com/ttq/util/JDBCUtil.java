package com.ttq.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
	private static String driver = "";
	private static String url = "";
	private static String username = "";
	private static String password = "";
	static {

		//读取配置文件，获得配置文件里面的驱动，URL，用户名和密码
		//读文件：io流
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/com/ttq/util/db.properties"));
			//key value map 多线程 安全的 Hashtable（安全）-> 子类Properties HashMap（不安全）
			Properties properties = new Properties();//Hashtable子类
			properties.load(reader);//加载***properties的文件，内容读取成->变成map集合
			//文件=左边是map的key，右边是map的value
			//根据key获得value值
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//加载驱动,获得连接
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	//关闭
	public static void close(Connection connection, Statement statement, ResultSet set) {
		if (set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
