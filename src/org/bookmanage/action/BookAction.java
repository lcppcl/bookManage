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

    //更具书的名字查询图书
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


    //更具书的名字查询图书
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


    //查询所有的图书
    public String queryAll()throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        BookDao bookDao = new BookDao();
        List<Book> listBook = bookDao.queryAllBook();
        if (listBook.size() != 0){
            request.setAttribute("listBook",listBook);
            return "bookList";
        }else {
            request.setAttribute("info","没有你想要的信息");
            return "info";
        }
    }

    //查询所有的图书
    public String queryAll2()throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        BookDao bookDao = new BookDao();
        List<Book> listBook = bookDao.queryAllBook();
        if (listBook.size() != 0){
            request.setAttribute("listBook2",listBook);
            return "bookList2";
        }else {
            request.setAttribute("info","没有你想要的信息");
            return "info2";
        }
    }



    //文件上传
    private File uploadFile;//上传文件
    private String uploadFileFileName;//文件名
    private String uploadContentType;//文件类型

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

    //添加图书
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
                //对图片进行压缩上传
                ImgCompress imgCom = new ImgCompress(uploadFile);
                //压缩图片 宽，高，图片名称，原图片名称
                String filename = imgCom.resize(130, 150, request.getParameter("isbn"), this.getUploadFileFileName());
                book.setIsbn(isbn);
                book.setBookName(bookName);
                book.setAuthor(author);
                book.setPublish(publish);
                book.setPrice(Float.valueOf(price));
                book.setSummary(summary);
                book.setPhoto(filename);
                bookDao.insertBook(book);
                request.setAttribute("msg", "添加成功");
            }
        }else{
            request.setAttribute("msg", "添加失败");
            return "info";
        }
        return "insertBook";
    }

    //删除学生
    public String  deleBook() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        BookDao bookDao = new BookDao();
        String isbn = request.getParameter("isbn");
        boolean flag = bookDao.deleBook(isbn);
        if (!flag){
            request.setAttribute("msg","书未还，不能删除");
            return "info";
        }else{
            request.setAttribute("msg","删除成功");
            return "deleBook";
        }
    }

    //修改图书信息
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
                //对图片进行压缩上传
                ImgCompress imgCom = new ImgCompress(uploadFile);
                //压缩图片 宽，高，图片名称，原图片名称
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
                request.setAttribute("msg", "修改成功");
            }
        }else{
            request.setAttribute("msg", "修改失败");
            return "info2";
        }
        return "updateBook";
    }
}
