package com.cao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {

	// 数据库连接参数
	private static final String URL = "jdbc:mysql://localhost:3306/miscoursedb?"
			+ "serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";

	// URL语法格式如下
	// jdbc:mysql:是固定的写法，后面跟主机名localhost，3306是默认的MySQL端口号
	// serverTimezone=UTC是指定时区时间为世界统一时间
	// useUnicode=true是指是否使用Unicode字符集，赋值为true
	// characterEncoding=utf-8是指定字符编码格式为UTF8

	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// 1. 加载 MySQL 驱动（JDBC 4.0+ 不需要显式加载）
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. 获取数据库连接
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// 3. 创建 SQL 更新语句（使用 ? 作为占位符）
			// 假设我们有一个 users 表，包含 name 和 email 字段
			String sql = "UPDATE users SET name = ?, sex = ? WHERE id = ?";

			// 4. 创建 PreparedStatement
			preparedStatement = connection.prepareStatement(sql);

			// 5. 设置参数
			preparedStatement.setString(1, "刘青"); // 第一个 ? 设置为新用户名
			preparedStatement.setString(2, "男"); // 第二个 ? 设置为新邮箱
			preparedStatement.setInt(3, 5); // 第三个 ? 设置为 id 为 5 的记录

			// 6. 执行更新操作
			int rowsAffected = preparedStatement.executeUpdate();

			// 7. 检查结果
			if (rowsAffected > 0) {
				System.out.println("数据更新成功！共更新了 " + rowsAffected + " 条记录。");
			} else {
				System.out.println("未找到匹配的数据，更新失败。");
			}

		} catch (ClassNotFoundException e) {
			System.err.println("MySQL JDBC Driver 未找到！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("数据库操作失败！");
			e.printStackTrace();
		} finally {
			// 8. 关闭资源（按顺序关闭）
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}