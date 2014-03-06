package mvc.servlet;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import mvc.factory.*;
import mvc.vo.*;

public class NewReportServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean flag = false;
		String info = new String();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		String path = "newreport.jsp";	
		String userid = req.getParameter("userid");// ����userid����
		String name = req.getParameter("username");
		String description = req.getParameter("description");
		try {
			time = sdf.parse(req.getParameter("time"));
		} catch (ParseException e1) {
			 System.out.println(e1.getMessage()); 
		}
		Report report = new Report();// ʵ����VO
		report.setuserid(userid);// ����userid
		report.setName(name);
		report.settime(time);
		report.setdiscript(description);
		try {
			flag = DAOFactory.getIReportDAOInstance().addreport(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			info  = "Add report successfully!";		
		}
		else{
			info  = "Fail when adding report!";
		}
		req.setAttribute("info", info);// ���������Ϣ
		req.getRequestDispatcher(path).forward(req, resp);// ��ת
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// ����doGet()����
	}
}
