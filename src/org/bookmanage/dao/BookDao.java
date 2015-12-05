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
    //根据图书证号进行查询
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
            book.setSummary(rs.getString(6));
            book.setPhoto(rs.getString(7));
            listBook.add(book);
        }
        dbUtil.close(pstmt, con);
        return listBook;
    }

    //添加图书
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


    //删除图书
    public boolean deleBook(String isbn ) throws Exception {
        Connection con = dbUtil.getCon();
        String sql2 = "select * from lend where bookid=?";
        PreparedStatement pstmt = con.prepareStatement(sql2);
        pstmt.setString(1, isbn);
        ResultSet resultSet = pstmt.executeQuery();
        if (resultSet.next()){
            pstmt.close();
            return false;
        }else {
            String sql = "delete from book where isbn=?";
            PreparedStatement pstmt2 = con.prepareStatement(sql);
            pstmt2.setString(1, isbn);
            int rs = pstmt2.executeUpdate();
            dbUtil.close(pstmt2, con);
            return true;
        }
    }

    //更新图书
    public void updateBook(Book book)throws Exception{
        Connection con = dbUtil.getCon();
        String sql = "update book set isbn=?,bookName=?,author=?,publish=?,price=?,summary=?,photo=? where isbn=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,book.getIsbn());
        pstmt.setString(2,book.getBookName());
        pstmt.setString(3,book.getAuthor());
        pstmt.setString(4,book.getPublish());
        pstmt.setFloat(5,book.getPrice());
        pstmt.setString(6,book.getSummary());
        pstmt.setString(7,book.getPhoto());
        pstmt.setString(8,book.getIsbn());
        int i = pstmt.executeUpdate();
        System.out.println("--------------");
        System.out.println(i);
        dbUtil.close(pstmt,con);
    }
}
