package mvc.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import structure.Page;
import mvc.factory.*;
import mvc.vo.*;

public class ReportListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userid = req.getParameter("userid");// 接受userid内容
		String path = "firstpage.jsp";
		ArrayList<Report> backinfo = new ArrayList<Report>();// 保存所有返回信息
		int amount = 0;

		Report report = new Report();// 实例化VO
		report.setuserid(userid);// 设置userid
		
		Page page = new Page();
		page.setPageIndex(1);
		page.setpageSize(10);
		try {
			amount = DAOFactory.getIReportDAOInstance().getAmount(report);
			backinfo = DAOFactory.getIReportDAOInstance().listReport(report,page);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("backinfo", backinfo);// array report list
		req.setAttribute("amount", amount);// total number of user's report
		req.getRequestDispatcher(path).forward(req, resp);// 跳转
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// 调用doGet()操作
	}
}
