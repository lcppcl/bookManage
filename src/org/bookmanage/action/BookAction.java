package org.bookmanage.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.bookmanage.bean.Book;
import org.bookmanage.dao.BookDao;
import org.bookmanage.dbconnect.ImgCompress;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class BookAction extends ActionSupport{

    //����������ֲ�ѯͼ��
    public String queryByBookIsbn() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String isbn = request.getParameter("isbn");
        System.out.print("---"+isbn);
        BookDao bookDao = new BookDao();
        Book book = bookDao.queryByBookIsbn(isbn);
        if (book.getIsbn().length() > 0){
            request.setAttribute("book",book);
            return "book";
        }else {
            return "info";
        }
    }


    //����������ֲ�ѯͼ��
    public String queryByBookIsbn2() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String isbn = request.getParameter("isbn");
        System.out.print("---"+isbn);
        BookDao bookDao = new BookDao();
        Book book = bookDao.queryByBookIsbn(isbn);
        if (book.getIsbn().length() > 0){
            request.setAttribute("book2",book);
            return "book";
        }else {
            return "info";
        }
    }


    //��ѯ���е�ͼ��
    public String queryAll()throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        BookDao bookDao = new BookDao();
        List<Book> listBook = bookDao.queryAllBook();
        if (listBook.size() != 0){
            request.setAttribute("listBook",listBook);
            return "bookList";
        }else {
            request.setAttribute("info","û������Ҫ����Ϣ");
            return "info";
        }
    }

    //��ѯ���е�ͼ��
    public String queryAll2()throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        BookDao bookDao = new BookDao();
        List<Book> listBook = bookDao.queryAllBook();
        if (listBook.size() != 0){
            request.setAttribute("listBook2",listBook);
            return "bookList2";
        }else {
            request.setAttribute("info","û������Ҫ����Ϣ");
            return "info2";
        }
    }



    //�ļ��ϴ�
    private File uploadFile;//�ϴ��ļ�
    private String uploadFileFileName;//�ļ���
    private String uploadContentType;//�ļ�����

    public File getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getUploadFileFileName() {
        return uploadFileFileName;
    }

    public void setUploadFileFileName(String uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    //���ͼ��
    public String insertBook()throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String isbn = request.getParameter("isbn");
        String bookName = request.getParameter("bookname");
        String author = request.getParameter("author");
        String publish = request.getParameter("publish");
        String price = request.getParameter("price");
        String summary = request.getParameter("summary");
        if (isbn != null && !isbn.equals("") && bookName != null && !bookName.equals("") &&
                author != null && !author.equals("") && publish != null && !publish.equals("") &&
                Float.valueOf(price) != 0 && summary != null && !summary.equals("")) {
            Book book = new Book();
            BookDao bookDao = new BookDao();
            if (uploadFile != null) {
                //��ͼƬ����ѹ���ϴ�
                ImgCompress imgCom = new ImgCompress(uploadFile);
                //ѹ��ͼƬ ���ߣ�ͼƬ���ƣ�ԭͼƬ����
                String filename = imgCom.resize(130, 150, request.getParameter("isbn"), this.getUploadFileFileName());
                book.setIsbn(isbn);
                book.setBookName(bookName);
                book.setAuthor(author);
                book.setPublish(publish);
                book.setPrice(Float.valueOf(price));
                book.setSummary(summary);
                book.setPhoto(filename);
                bookDao.insertBook(book);
                request.setAttribute("msg", "��ӳɹ�");
            }
        }else{
            request.setAttribute("msg", "���ʧ��");
            return "info";
        }
        return "insertBook";
    }

    //ɾ��ѧ��
    public String  deleBook() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        BookDao bookDao = new BookDao();
        String isbn = request.getParameter("isbn");
        boolean flag = bookDao.deleBook(isbn);
        if (!flag){
            request.setAttribute("msg","��δ��������ɾ��");
            return "info";
        }else{
            request.setAttribute("msg","ɾ���ɹ�");
            return "deleBook";
        }
    }

    //�޸�ͼ����Ϣ
    public String updateBook()throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        BookDao bookDao = new BookDao();
        String isbn = request.getParameter("isbn");
        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        String publish = request.getParameter("publish");
        String price = request.getParameter("price");
        String summary = request.getParameter("summary");
        if (isbn != null && !isbn.equals("") && bookName != null && !bookName.equals("") &&
                author != null && !author.equals("") && publish != null && !publish.equals("") &&
                Float.valueOf(price) != 0 && summary != null && !summary.equals("")) {
            Book book = new Book();
            if (uploadFile != null) {
                //��ͼƬ����ѹ���ϴ�
                ImgCompress imgCom = new ImgCompress(uploadFile);
                //ѹ��ͼƬ ���ߣ�ͼƬ���ƣ�ԭͼƬ����
                String filename = imgCom.resize(130, 150, request.getParameter("isbn"), this.getUploadFileFileName());
                book.setIsbn(isbn);
                book.setBookName(bookName);
                book.setAuthor(author);
                book.setPublish(publish);
                book.setPrice(Float.valueOf(price));
                book.setSummary(summary);
                book.setPhoto(filename);
                bookDao.updateBook(book);
                System.out.println(book);
                request.setAttribute("msg", "�޸ĳɹ�");
            }
        }else{
            request.setAttribute("msg", "�޸�ʧ��");
            return "info2";
        }
        return "updateBook";
    }
}
