package org.bookmanage.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.bookmanage.bean.Lend;
import org.bookmanage.bean.User;
import org.bookmanage.dao.LendDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LendAction extends ActionSupport {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();
    public String queryLend()throws Exception{
        LendDao lendDao  = new LendDao();
        User student = (User) session.getAttribute("student");
        List<Lend> lendList = lendDao.lendBook(student.getReaderId());
        if (lendList.size() !=0 ){
            request.setAttribute("lendList",lendList);
            return "lendList";
        }else {
            return "info";
        }
    }

    //还书
    public String returnBook() throws Exception {
        LendDao lendDao  = new LendDao();
        String isbn = request.getParameter("isbn");
        lendDao.returnBook(isbn);
        return "returnBook";
    }
}
