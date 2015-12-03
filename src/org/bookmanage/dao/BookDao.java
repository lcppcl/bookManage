package org.bookmanage.dao;

import org.bookmanage.bean.Book;
import org.bookmanage.dbconnect.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private static DbUtil dbUtil = new DbUtil();
    public Book queryByBookIsbn(String isbn) throws Exception{
        Connection con = dbUtil.getCon();
        String sql = "select * from book where isbn=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, isbn);
        System.out.println("id--"+isbn);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Book book = new Book();
            book.setIsbn(rs.getString(1));
            book.setBookName(rs.getString(2));
            book.setAuthor(rs.getString(3));
            book.setPublish(rs.getString(4));
            book.setPrice(rs.getFloat(5));
            book.setSunm(rs.getInt(6));
            book.setSummary(rs.getString(7));
            book.setPhoto(rs.getString(8));
            return book;
        } else {
            dbUtil.close(pstmt, con);
            return null;
        }
    }
    //得到所有的图书
    public List<Book> queryAllBook() throws Exception{
        Connection con = dbUtil.getCon();
        String sql = "select * from book";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Book> listBook = new ArrayList();
        while (rs.next()) {
            Book book = new Book();
            book.setIsbn(rs.getString(1));
            book.setBookName(rs.getString(2));
            book.setAuthor(rs.getString(3));
            book.setPublish(rs.getString(4));
            book.setPrice(rs.getFloat(5));
            book.setSunm(rs.getInt(6));
            book.setSummary(rs.getString(7));
            book.setPhoto(rs.getString(8));
            listBook.add(book);
        }
        dbUtil.close(pstmt, con);
        return listBook;
    }
}
