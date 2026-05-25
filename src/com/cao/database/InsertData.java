package com.cao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertData {
	public static void main(String[] args) throws SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";// 数据库驱动类所对应的字符串
		String URL = "jdbc:mysql://localhost:3306/miscoursedb?"
				+ "serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";

		// URL语法格式如下
		// jdbc:mysql:是固定的写法，后面跟主机名localhost，3306是默认的MySQL端口号
		// serverTimezone=UTC是指定时区时间为世界统一时间
		// useUnicode=true是指是否使用Unicode字符集，赋值为true
		// characterEncoding=utf-8是指定字符编码格式为UTF8
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		// Connection接口代表Java程序和数据库的连接对象，只有获得该连接对象后，才能访问数据库，并操作数据表
		try {

			Class.forName(driver);// 加载MySQL数据库驱动

		} catch (java.lang.ClassNotFoundException e) {// 如果找不到这个类，执行下面的异常处理
			System.out.println("驱动程序配置未配置成功!!!");
		}

		try {
			conn = DriverManager.getConnection(URL, "root", "668899");// 建立和数据库的连接，并返回表示连接的Connection对象

			System.out.println("数据库连接成功!!!");

			String insertSql = "INSERT INTO users (id, name, age, sex) VALUES (?,?, ?, ?)";
			// String insertSql = "INSERT INTO users (name, age, sex) VALUES (?, ?, ?)";
			preparedStatement = conn.prepareStatement(insertSql);

			preparedStatement.setInt(1, 10);
			preparedStatement.setString(2, "王老六");
			preparedStatement.setInt(3, 35);
			preparedStatement.setString(4, "男");

			int rowsAffected = preparedStatement.executeUpdate();

			System.out.println("交互式插入完成，影响行数：" + rowsAffected);

		} catch (Exception e) {// 未连接成功，执行下面的异常处理

			System.out.println("数据库连接失败!!!");
			e.printStackTrace();

		} finally {

			// 关闭数据库链接
			preparedStatement.close();
			conn.close();
			System.out.println("关闭数据库链接!!!");
		}
	}
}