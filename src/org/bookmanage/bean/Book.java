package org.bookmanage.bean;
public class Book {
    private String isbn;//isbn��
    private String bookName;//����
    private String author;//����
    private String publish;//������
    private Float price;//�۸�
    private int sunm;//���
    private String summary;//ժҪ
    private String photo;//ͼƬ

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getSunm() {
        return sunm;
    }

    public void setSunm(int sunm) {
        this.sunm = sunm;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
