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
		String userid = req.getParameter("userid");// 接受userid内容
		String name = req.getParameter("username");
		String description = req.getParameter("description");
		try {
			time = sdf.parse(req.getParameter("time"));
		} catch (ParseException e1) {
			 System.out.println(e1.getMessage()); 
		}
		Report report = new Report();// 实例化VO
		report.setuserid(userid);// 设置userid
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
		req.setAttribute("info", info);// 保存错误信息
		req.getRequestDispatcher(path).forward(req, resp);// 跳转
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// 调用doGet()操作
	}
}
