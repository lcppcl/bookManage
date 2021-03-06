package org.bookmanage.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//数据库连接
public class DbUtil {
	// 数据库地址
	private static String dbUrl = "jdbc:mysql://localhost:3306/bookmanage";
	// 用户名
	private static String dbUserName = "root";
	// 密码
	private static String dbPassword = "";
	// 驱动名称
	private static String jdbcName = "com.mysql.jdbc.Driver";

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		System.out.println("haha");
		return con;
	}

	/**
	 * 关闭连接
	 * 
	 * @param con
	 * @throws Exception
	 */
	public void close(PreparedStatement pstmt, Connection con) throws Exception {
		if (pstmt != null) {
			pstmt.close();
			if (con != null) {
				con.close();
			}
		}
	}
}
