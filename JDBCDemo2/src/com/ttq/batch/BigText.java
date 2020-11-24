package com.ttq.batch;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ttq.util.JDBCUtil;

public class BigText {
	public static void insertImg() throws FileNotFoundException, SQLException {
		//流
		InputStream inputStream = new FileInputStream("src/com/ttq/batch/home-features3.png");
		//写到数据库
		Connection connection = JDBCUtil.getConnection();
		String sql = "insert into tb_test2 values(null,?,null)";
		PreparedStatement statement = connection.prepareStatement(sql);
		//绑定参数 流
		statement.setBlob(1, inputStream);
		int count = statement.executeUpdate();
		JDBCUtil.close(connection, statement, null);
	}

	public static void insertFile() throws FileNotFoundException, SQLException {
		Reader reader = new FileReader("src/com/ttq/batch/BatchTest.java");
		Connection connection = JDBCUtil.getConnection();
		String sql = "insert into tb_test2 values(null,null,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		//绑定参数 流 setClob 字符流（文本） sbtBlob字节流（多媒体）
		statement.setClob(1, reader);
		int count = statement.executeUpdate();
		JDBCUtil.close(connection, statement, null);

	}

	public static void main(String[] args) throws FileNotFoundException, SQLException {
		//insertImg();
		insertFile();
	}
}
