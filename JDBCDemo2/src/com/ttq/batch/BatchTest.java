package com.ttq.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ttq.util.JDBCUtil;

/**
 * 
 * 创痛方案插入1万条数据
 * 批处理插入一万条数据
 * 看性能
 * */
public class BatchTest {
	//传统的
	public static void insertUser() throws SQLException {
		Connection connection = JDBCUtil.getConnection();
		PreparedStatement statement = null;
		String sql = "insert into tb_test values(null,?,'123')";
		statement = connection.prepareStatement(sql);//编译一次
		for (int i = 0; i < 10000; i++) {//基本写法，发送一条执行一次
			//发送sql
			statement.setString(1, "张三" + i);//绑定参数
			int count = statement.executeUpdate();//执行
		}
		JDBCUtil.close(connection, statement, null);
	}

	//批处理
	public static void insertBatchUser() throws SQLException {
		Connection connection = JDBCUtil.getConnection();
		PreparedStatement statement = null;
		String sql = "insert into tb_test values(null,?,'123')";
		statement = connection.prepareStatement(sql);//编译一次
		//运的部分，批量运
		for (int i = 10000; i < 20000; i++) {
			statement.setString(1, "李四" + i);
			//批处理运
			statement.addBatch();
			if (1 % 1000 == 0) {//1000处理一次
				statement.executeBatch();
				statement.clearBatch();//清空再次搬运下1000条sql执行
			}

		}
		statement.executeBatch();//为了放置车有没有执行的sql，最后再执行一次
		JDBCUtil.close(connection, statement, null);
	}

	public static void main(String[] args) throws SQLException {
		long begin = System.currentTimeMillis();
		insertUser();
		long end = System.currentTimeMillis();
		System.out.println("普通执行了" + (end - begin) + "毫秒");

		begin = System.currentTimeMillis();
		insertBatchUser();
		end = System.currentTimeMillis();
		System.out.println("批处理执行了" + (end - begin) + "毫秒");
		//		普通执行了3506毫秒
		//		批处理执行了89毫秒

	}
}
