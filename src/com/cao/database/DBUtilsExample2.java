package com.cao.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库连接工具类 封装了获取连接、关闭资源等常用操作
 */
public class DBUtilsExample2 {

	// 数据库连接参数（可以从配置文件读取）
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	// 静态代码块，在类加载时执行一次，用于初始化数据库连接参数
	static {
		loadConfig();
	}

	/**
	 * 从配置文件加载数据库连接参数
	 */
	private static void loadConfig() {
		Properties props = new Properties();
		try (InputStream input = DBUtilsExample2.class.getClassLoader().getResourceAsStream("db.properties")) {
			if (input == null) {
				System.err.println("找不到 db.properties 配置文件，使用默认参数");
				// 设置默认值
				driver = "com.mysql.cj.jdbc.Driver";
				url = "jdbc:mysql://localhost:3306/miscoursedb?useSSL=false&serverTimezone=UTC";
				username = "root";
				password = "password";
				return;
			}

			props.load(input);
			driver = props.getProperty("driver", "com.mysql.cj.jdbc.Driver");
			url = props.getProperty("url", "jdbc:mysql://localhost:3306/miscoursedb?useSSL=false&serverTimezone=UTC");
			username = props.getProperty("username", "root");
			password = props.getProperty("password", "password");

		} catch (IOException e) {
			System.err.println("加载数据库配置文件失败: " + e.getMessage());
			e.printStackTrace();
			// 设置默认值以避免空指针异常
			driver = "com.mysql.cj.jdbc.Driver";
			url = "jdbc:mysql://localhost:3306/miscoursedb?useSSL=false&serverTimezone=UTC";
			username = "root";
			password = "password";
		}

		try {
			Class.forName(driver);
			System.out.println("数据库驱动加载成功");
		} catch (ClassNotFoundException e) {
			System.err.println("数据库驱动加载失败: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return Connection 数据库连接对象
	 */
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("数据库连接成功");
			return conn;
		} catch (SQLException e) {
			System.err.println("获取数据库连接失败: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 关闭数据库资源
	 * 
	 * @param rs   ResultSet 结果集
	 * @param stmt Statement 或 PreparedStatement
	 * @param conn Connection 连接
	 */
	public static void closeResource(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.err.println("关闭 ResultSet 失败: " + e.getMessage());
				e.printStackTrace();
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.err.println("关闭 Statement 失败: " + e.getMessage());
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
				System.out.println("数据库连接已关闭");
			} catch (SQLException e) {
				System.err.println("关闭 Connection 失败: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭数据库连接（仅关闭连接）
	 * 
	 * @param conn Connection 连接
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("数据库连接已关闭");
			} catch (SQLException e) {
				System.err.println("关闭 Connection 失败: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * 执行查询操作
	 * 
	 * @param sql    SQL 查询语句
	 * @param params 参数数组
	 * @return ResultSet 查询结果
	 */
	public static ResultSet executeQuery(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			// 设置参数
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
			}

			rs = pstmt.executeQuery();
			return rs;

		} catch (SQLException e) {
			System.err.println("执行查询失败: " + e.getMessage());
			e.printStackTrace();
			closeResource(rs, pstmt, conn);
			return null;
		}
	}

	/**
	 * 执行更新操作（INSERT, UPDATE, DELETE）
	 * 
	 * @param sql    SQL 更新语句
	 * @param params 参数数组
	 * @return int 影响的行数
	 */
	public static int executeUpdate(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			// 设置参数
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
			}

			result = pstmt.executeUpdate();
			System.out.println("执行更新操作成功，影响行数: " + result);

		} catch (SQLException e) {
			System.err.println("执行更新失败: " + e.getMessage());
			e.printStackTrace();
		} finally {
			closeResource(null, pstmt, conn);
		}

		return result;
	}

	// 测试方法
	public static void main(String[] args) {
		// 测试连接
		Connection conn = getConnection();
		if (conn != null) {
			System.out.println("连接测试成功！");

			// 测试执行更新操作
			String insertSql = "INSERT INTO test_table (name, age) VALUES (?, ?)";
			int insertResult = executeUpdate(insertSql, "测试用户", 25);
			System.out.println("插入操作结果: " + insertResult);

			// 测试执行查询操作
			String selectSql = "SELECT * FROM users WHERE age > ?";
			ResultSet rs = executeQuery(selectSql, 20);
			if (rs != null) {
				try {
					while (rs.next()) {
						System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: "
								+ rs.getInt("age"));
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

			closeConnection(conn);
		} else {
			System.out.println("连接测试失败！");
		}
	}
}
