package com.cao.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库连接工具类 封装了获取连接、关闭资源等常用操作
 */
public class DBUtilsExample {

	// 测试方法
	public static void main(String[] args) {
		// 测试连接
		Connection conn = DBUtils.getConnection();

		if (conn != null) {
			System.out.println("连接测试成功！");

			// 测试执行更新操作
			String insertSql = "INSERT INTO users (name, age, sex) VALUES (?, ?, ?)";
			int insertResult = DBUtils.executeUpdate(insertSql, "新用户", 25, "男");
			System.out.println("插入操作结果: " + insertResult);

			// 测试执行查询操作
			String selectSql = "SELECT * FROM users WHERE age > ?";
			ResultSet rs = DBUtils.executeQuery(selectSql, 20);
			if (rs != null) {
				try {
					while (rs.next()) {
						System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: "
								+ rs.getInt("age") + ", Sex: " + rs.getString("sex"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 关闭链接
			DBUtils.closeConnection(conn);
		} else {
			System.out.println("连接测试失败！");
		}
	}
}
