package org.bookmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.bookmanage.bean.Book;
import org.bookmanage.bean.User;
import org.bookmanage.dbconnect.DbUtil;

public class LoginDao {
	private static DbUtil dbUtil = new DbUtil();

	//登陆
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
	//获取到所有的学生
	public List<User> queryAllUser() throws Exception{
		Connection con = dbUtil.getCon();
		String sql = "select readerId,name,sex,spec,type from user";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<User> listUser = new ArrayList();
		while (rs.next()) {
			if (rs.getInt(5) == 0){
				User user = new User();
				user.setReaderId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setSex(rs.getInt(3));
				user.setSpec(rs.getString(4));
				user.setType(rs.getInt(5));
				listUser.add(user);
			}
		}
		dbUtil.close(pstmt, con);
		return listUser;
	}

	//删除学生
	public boolean delUser(String readerId)throws Exception{
		Connection con = dbUtil.getCon();
		String sql1 = "select * from lend where lenderid=?";
		PreparedStatement pstmt1 = con.prepareStatement(sql1);
		pstmt1.setString(1, readerId);
		ResultSet rs1 = pstmt1.executeQuery();
		if(!rs1.next()){
			String sql = "delete from user where readerId=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, readerId);
			int rs = pstmt.executeUpdate();
			pstmt.close();
			return true;
		}
		con.close();
		return false;
	}
}
