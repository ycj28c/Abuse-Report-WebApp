//����Servlet����Servlet��Ҫ���ܿͻ��˷������������� 
//ͬʱҪ����DAO������Ҫ����DAO�Ľ��������Ӧ����Ϣ 
//��Servlet�У����ȶ���Խ��ܵ�userid��userpass��������������֤�����û���������//����������Ĳ���Ϊ�գ������info������������Ӧ�Ĵ�����Ϣ�� 
//����֤ͨ���󣬳��򽫵���DAO�������ݲ����֤��������DAO�ķ��ؽ������������//���ͻ��˵���Ϣ 
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
		String userid = req.getParameter("userid");// ����userid����
		String userpass = req.getParameter("userpass");// ����password����
		List<String> info = new ArrayList<String>();// �������з�����Ϣ
		if (userid == null || "".equals(userid)) {
			info.add("User id can not be empty!");
		}
		if (userpass == null || "".equals(userpass)) {
			info.add("Password can not be empty!");
		}
		if (info.size() == 0) {// �û�����������֤ͨ��
			User user = new User();// ʵ����VO
			user.setUserid(userid);// ����userid
			user.setPassword(userpass);// ����password
			try {
				if (DAOFactory.getIUserDAOInstance().findLogin(user)) {// ��֤ͨ��
					// info.add("login in successful " + user.getName()+
					// " welcome!");
					// req.setAttribute("info", info);// ���������Ϣ
					req.setAttribute("userid", user.getUserid());
					req.setAttribute("username", user.getName());
					req.setAttribute("user", user);
					req.getRequestDispatcher(succ_path).forward(req, resp);// ��ת
				} else {
					info.add("fail login��wrong user id or password!");
					req.setAttribute("info", info);// ���������Ϣ
					req.getRequestDispatcher(fail_path).forward(req, resp);// ��ת
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// ����doGet()����
	}
}