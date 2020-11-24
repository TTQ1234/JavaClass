package com.ttq.batch;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.ttq.util.JDBCUtil;

public class CallableStatementTest {

	public static void main(String[] args) {
		//1.获得连接
		Connection connection = JDBCUtil.getConnection();
		//编写sql
		String sql = "call pro3(?,?,?,?)";
		CallableStatement statement = null;
		try {
			statement = connection.prepareCall(sql);
			//绑定参数  输入还是输出
			//PROCEDUER `pro3`(in eid int,out empname varchar(50),out salary double,out hdate date)
			statement.setInt(1, 7369);//查询7369的员工名，月薪和入职时间
			//输出值先注册到statement中
			statement.registerOutParameter(2, Types.VARCHAR);
			statement.registerOutParameter(2, Types.DOUBLE);
			statement.registerOutParameter(3, Types.DATE);
			statement.execute();//执行存储过程，返回值就全部注册到statement中
			//获得返回值
			System.out.println(statement.getString(2));
			System.out.println(statement.getDouble(3));
			System.out.println(statement.getDate(4));
			JDBCUtil.close(connection, statement, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
