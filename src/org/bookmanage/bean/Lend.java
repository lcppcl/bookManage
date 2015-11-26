package org.bookmanage.bean;

import java.util.Date;

/*
 * 借书模型
 */
public class Lend {
	private String bookId;//图书id
	private String readerId;//借书证号
	private String bookName;//书名
	private String publisher;//出版社
	private float price;//价格
	private String ISBN;//isbn号
	private Date lTime;//借书时间
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getReaderId() {
		return readerId;
	}
	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Date getlTime() {
		return lTime;
	}
	public void setlTime(Date lTime) {
		this.lTime = lTime;
	}
	
}
