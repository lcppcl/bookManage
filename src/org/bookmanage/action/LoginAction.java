package org.bookmanage.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.bookmanage.bean.Book;
import org.bookmanage.bean.User;
import org.bookmanage.dao.BookDao;
import org.bookmanage.dao.LoginDao;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class LoginAction extends ActionSupport {
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpSession session = request.getSession();
	//登陆
	public String login() throws Exception {
		String readerid = request.getParameter("readerid");
		String password = request.getParameter("password");
		LoginDao loginDao = new LoginDao();
		User user = loginDao.login(readerid, password);
		BookDao bookDao = new BookDao();
		List<Book> listBook= bookDao.queryAllBook();
		String result = null;
		if(user!=null && user.getType() == 0 && readerid.equals(user.getReaderId())){
			if (listBook.size() != 0){
				session.setAttribute("listBook",listBook);
	        }
			session.setAttribute("student", user);
			return "student";
		}else if(user!=null && user.getType() == 1 && readerid.equals(user.getReaderId())){
			session.setAttribute("admin", user);
			if (listBook.size() != 0){
				session.setAttribute("listBook",listBook);
	        }
			return "admin";
		}else{
			return "error";
		}
	}

	//查找所有的用户
	public String queryAllUser()throws Exception{
		LoginDao loginDao = new LoginDao();
		List<User> listUser = loginDao.queryAllUser();
		if (listUser.size() != 0){
			request.setAttribute("listUser",listUser);
			return "listUser";
		}else {
			return "info";
		}
	}

	//删除学生
	public String  delUser() throws Exception{
		LoginDao loginDao = new LoginDao();
		String readerid = request.getParameter("readerId");
		boolean flag = loginDao.delUser(readerid);
		if (!flag){
			request.setAttribute("msg","书未还，不能删除");
			return "info";
		}else{
			request.setAttribute("msg","删除成功");
			return "delUser";
		}
	}
}
