//定义Servlet，在Servlet中要接受客户端发来的输入数据 
//同时要调用DAO，并且要根据DAO的结果返回响应的信息 
//在Servlet中，首先定义对接受的userid和userpass两个参数进行验证，如果没有输入参数//或者是输入的参数为空，则会在info对象中增加相应的错误信息。 
//当验证通过后，程序将调用DAO进行数据层的验证，并根据DAO的返回结果来决定返回//给客户端的信息 
package mvc.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import mvc.factory.*;
import mvc.vo.*;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fail_path = "login.jsp";
		String succ_path = "firstpage.jsp";
		String userid = req.getParameter("userid");
		String userpass = req.getParameter("userpass");
		List<String> info = new ArrayList<String>();
		ArrayList<Authority> authorityList = new ArrayList<Authority>();
		if (userid == null || "".equals(userid)) {
			info.add("User id can not be empty!");
		}
		if (userpass == null || "".equals(userpass)) {
			info.add("Password can not be empty!");
		}
		if (info.size() == 0) {// if the userid and password pass
			User user = new User();
			user.setUserid(userid);
			user.setPassword(userpass);
			try {
				if (DAOFactory.getIUserDAOInstance().findLogin(user)) {// verify pass
					//get the user's authority, return to page
					authorityList = DAOFactory.getIAuthorityMappingDAOInstance().getAuthorityMenu(user);
					if(authorityList.size()<=0){ //if no authority
						Authority fake = new Authority();
						authorityList.add(fake);
					}
					//jump to page
					req.setAttribute("userid", user.getUserid());
					req.setAttribute("username", user.getName());
					req.setAttribute("groupid", user.getGroupid());
					req.setAttribute("authorityList", authorityList);
					req.getRequestDispatcher(succ_path).forward(req, resp);
				} else {
					info.add("fail login，wrong user id or password!");
					req.setAttribute("info", info);// return error message
					req.getRequestDispatcher(fail_path).forward(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// 调用doGet()操作
	}
}