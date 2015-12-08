package org.bookmanage.dao;

import org.bookmanage.bean.Book;
import org.bookmanage.bean.Lend;
import org.bookmanage.dbconnect.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LendDao {
    private static DbUtil dbUtil = new DbUtil();
    //根据借阅这的id，和图书id查找
    public List<Lend> lendBook(String lenderid)throws Exception{
        Connection con = dbUtil.getCon();
        String sql = "select ltime,rtime,author,bookName,bookid from lend,book where lenderid=? and lend.bookid=book.isbn";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, lenderid);
        ResultSet rs = pstmt.executeQuery();
        List<Lend> lendList = new ArrayList();
        while (rs.next()){
            Lend lend = new Lend();
            lend.setLtime(rs.getDate(1));
            lend.setRtime(rs.getDate(2));
            lend.setAuthor(rs.getString(3));
            lend.setBookName(rs.getString(4));
            lend.setBookid(rs.getString(5));
            lendList.add(lend);
        }
        dbUtil.close(pstmt, con);
        return lendList;
    }


    //还书
    public void returnBook(String isbn ) throws Exception {
        Connection con = dbUtil.getCon();
        String sql = "delete from lend where bookid=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, isbn);
        int rs = pstmt.executeUpdate();
        dbUtil.close(pstmt, con);
    }
    
    //借书
    public boolean lend(String bookid,String lenderid) throws Exception{
    	
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar c = Calendar.getInstance();
		String ltime = f.format(c.getTime());
		c.add(Calendar.MONTH, 1);//获取当前日期的后一个月
		String rtime = f.format(c.getTime());
    	
    	
    	Connection con = dbUtil.getCon();
    	String sql = "select * from lend where bookid=?";
    	PreparedStatement pstmt = con.prepareStatement(sql);
    	pstmt.setString(1,bookid);
    	ResultSet i = pstmt.executeQuery();
    	if(!i.next()){
    		String sql1 = "insert into lend values(?,?,?,?)";
        	PreparedStatement pstmt1 = con.prepareStatement(sql1);
        	pstmt1.setString(1,bookid);
        	pstmt1.setString(2,lenderid);
        	pstmt1.setString(3, ltime);
        	pstmt1.setString(4, rtime);
        	pstmt1.executeUpdate();
        	pstmt1.close();
        	return true;
    	}else{
    		dbUtil.close(pstmt, con);
    		return false;
    	}
    }
}
