package org.bookmanage.dao;

import org.bookmanage.bean.Book;
import org.bookmanage.bean.Lend;
import org.bookmanage.dbconnect.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
}
