package org.bookmanage.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//���ݿ�����
public class DBConnect {
	// ���ݿ��ַ
	private static String dbUrl = "jdbc:mysql://localhost:3306/db_book";
	// �û���
	private static String dbUserName = "root";
	// ����
	private static String dbPassword = "lcp8090";
	// ��������
	private static String jdbcName = "com.mysql.jdbc.Driver";

	/**
	 * ��ȡ���ݿ�����
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName,
				dbPassword);
		System.out.println("haha");
		return con;
	}

	/**
	 * �ر�����
	 * @param con
	 * @throws Exception
	 */
	public void close(Statement stmt, Connection con) throws Exception {
		if (stmt != null) {
			stmt.close();
			if (con != null) {
				con.close();
			}
		}
	}
}
