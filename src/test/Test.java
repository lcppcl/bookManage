package test;

import java.sql.Connection;

import org.bookmanage.dbconnect.DbUtil;

public class Test {
	private static DbUtil dbUtil = new DbUtil();

	public static void main(String[] args) throws Exception {
		Connection con = dbUtil.getCon(); // 获取连接
		if(con != null){
			System.out.println("lianjie");
		}else{
			System.out.println("bucheng");
		}
	}
}
