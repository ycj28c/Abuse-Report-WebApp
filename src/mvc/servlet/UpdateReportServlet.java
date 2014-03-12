package mvc.servlet;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import mvc.factory.*;
import mvc.vo.*;

public class UpdateReportServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//set variable
		boolean flag = false;
		String info = new String();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();	
		String name = req.getParameter("username");
		String description = req.getParameter("description");
		int reportid = Integer.parseInt(req.getParameter("reportid"));
		String succ_path = "firstpage.jsp";	
		String fail_path = "editreport.jsp";
		try {
			time = sdf.parse(req.getParameter("time"));
		} catch (ParseException e1) {
			 System.out.println(e1.getMessage()); 
		}
		//set report vo
		Report report = new Report();
		report.setName(name);
		report.settime(time);
		report.setdiscript(description);
		report.setreportid(reportid);
		try {
			flag = DAOFactory.getIReportDAOInstance().updatereport(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//jump to page
		if(flag){
			req.getRequestDispatcher(succ_path).forward(req, resp);// 跳转
		}
		else{
			info  = "Fail when updating report!";
			req.setAttribute("info", info);// 保存错误信息
			req.getRequestDispatcher(fail_path).forward(req, resp);// 跳转
		}		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// 调用doGet()操作
	}
}
