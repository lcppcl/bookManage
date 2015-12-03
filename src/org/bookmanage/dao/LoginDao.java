package org.bookmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bookmanage.bean.User;
import org.bookmanage.dbconnect.DbUtil;

public class LoginDao {
	private static DbUtil dbUtil = new DbUtil();

	public User login(String readerId, String passwd) throws Exception {

		Connection con = dbUtil.getCon();
		String sql = "select * from user where readerId=? and passwd=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, readerId);
		pstmt.setString(2, passwd);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			User user = new User();
			user.setReaderId(rs.getString(1));
			user.setName(rs.getString(2));
			user.setSex(rs.getInt(3));
			user.setSpec(rs.getString(4));
			user.setNum(rs.getInt(5));
			user.setType(rs.getInt(6));
			user.setPasswd(rs.getString(7));
			dbUtil.close(pstmt, con);
			return user;
		} else {
			dbUtil.close(pstmt, con);
			return null;
		}		
	}
}
