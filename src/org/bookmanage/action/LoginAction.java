package org.bookmanage.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.bookmanage.bean.User;
import org.bookmanage.dao.LoginDao;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	public String login() throws Exception {
		String readerid = request.getParameter("readerid");
		String password = request.getParameter("password");

		LoginDao loginDao = new LoginDao();
		User user = loginDao.login(readerid, password);
		if(user!=null && user.getType() == 0){
			session.setAttribute("student", user);
			return "student";
		}else if(user!=null && user.getType() == 1){
			session.setAttribute("admin", user);
			return "admin";
		}else{
			return "error";
		}
	}
}
