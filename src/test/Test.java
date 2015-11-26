package test;

import java.sql.Connection;

import org.bookmanage.dbconnect.DBConnect;

public class Test {
	private static DBConnect dbUtil = new DBConnect();

	public static void main(String[] args) throws Exception {
		Connection con = dbUtil.getCon(); // 获取连接
		if(con != null){
			System.out.println("lianjie");
		}else{
			System.out.println("bucheng");
		}
	}
}
