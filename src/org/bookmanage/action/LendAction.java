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
    //��ѯ���е���
    HttpSession session = request.getSession();
    public String queryLend()throws Exception{
        LendDao lendDao  = new LendDao();
        User student = (User) session.getAttribute("user");
        List<Lend> lendList = lendDao.lendBook(student.getReaderId());
        if (lendList.size() !=0 ){
            request.setAttribute("lendList",lendList);
            return "lendList";
        }else {
            return "info";
        }
    }

    //����
    public String returnBook() throws Exception {
    	HttpServletRequest request = ServletActionContext.getRequest();
        LendDao lendDao  = new LendDao();
        String isbn = request.getParameter("isbn");
        lendDao.returnBook(isbn);
        request.setAttribute("msg","����ɹ�");
        return "returnBook";
    }
    
    //����
    public String lend() throws Exception{
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String isbn = request.getParameter("isbn");
    	User student = (User) session.getAttribute("user");
    	LendDao lendDao  = new LendDao();
    	boolean flag = lendDao.lend(isbn, student.getReaderId());
    	if(flag){
    		request.setAttribute("msg","����ɹ�");
 
    	}else{
    		request.setAttribute("msg","���Ѿ�����");
    	}
    	return "lend";
    }
}
