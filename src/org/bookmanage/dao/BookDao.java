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
    //����ͼ��֤�Ž��в�ѯ
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
            book.setSummary(rs.getString(6));
            book.setPhoto(rs.getString(7));
            return book;
        } else {
            dbUtil.close(pstmt, con);
            return null;
        }
    }
    //�õ����е�ͼ��
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
            book.setSummary(rs.getString(6));
            book.setPhoto(rs.getString(7));
            listBook.add(book);
        }
        dbUtil.close(pstmt, con);
        return listBook;
    }

    //���ͼ��
    public void insertBook(Book book)throws Exception{
        Connection con = dbUtil.getCon();
        String sql = "insert into book values(?,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,book.getIsbn());
        pstmt.setString(2,book.getBookName());
        pstmt.setString(3,book.getAuthor());
        pstmt.setString(4,book.getPublish());
        pstmt.setFloat(5,book.getPrice());
        pstmt.setString(6,book.getSummary());
        pstmt.setString(7,book.getPhoto());
        pstmt.executeUpdate();
        dbUtil.close(pstmt,con);
    }
}
