package org.bookmanage.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//���ݿ�����
public class DbUtil {
	// ���ݿ��ַ
	private static String dbUrl = "jdbc:mysql://localhost:3306/bookmanage";
	// �û���
	private static String dbUserName = "root";
	// ����
	private static String dbPassword = "";
	// ��������
	private static String jdbcName = "com.mysql.jdbc.Driver";

	/**
	 * ��ȡ���ݿ�����
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
	 * �ر�����
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
