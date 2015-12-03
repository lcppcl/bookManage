package org.bookmanage.bean;

import java.util.Date;

/**
 * Created by 李翠萍 on 2015/12/2.
 */
public class Lend {
    private String bookid;//借阅图书的isbn
    private Date ltime;//借阅时间
    private Date rtime;//归还时间
    private String author;//作者
    private String bookName;//书名

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public Date getLtime() {
        return ltime;
    }

    public void setLtime(Date ltime) {
        this.ltime = ltime;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
