package org.bookmanage.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.bookmanage.bean.Book;
import org.bookmanage.dao.BookDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BookAction extends ActionSupport{
    HttpServletRequest request = ServletActionContext.getRequest();
    //更具书的名字查询图书
    public String queryByBookIsbn() throws Exception {
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

    //查询所有的图书
    public String queryAll()throws Exception{
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
}
