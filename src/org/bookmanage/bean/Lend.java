package org.bookmanage.bean;

import java.util.Date;

/**
 * Created by ���Ƽ on 2015/12/2.
 */
public class Lend {
    private String bookid;//����ͼ���isbn
    private Date ltime;//����ʱ��
    private Date rtime;//�黹ʱ��
    private String author;//����
    private String bookName;//����

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
