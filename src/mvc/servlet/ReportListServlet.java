package mvc.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import structure.Page;
import mvc.factory.*;
import mvc.vo.*;

public class ReportListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//set variable
		HttpSession session = req.getSession();
		String userid = session.getAttribute("userid").toString();
		int pageindex = Integer.parseInt(req.getParameter("pageindex"));//当前page
		//int totalpage = 0;
		int reportamount = 0;
		String path = "firstpage.jsp";
		String contentPage = "/jsp/report.jsp";
		ArrayList<Report> backinfo = new ArrayList<Report>();// 保存所有返回信息		
		Report report = new Report();// 实例化VO
		report.setUserid(userid);// 设置userid
		
		//set page
		try {
			reportamount = DAOFactory.getIReportDAOInstance().getAmount(report); //get amount of records user have	
		} catch (Exception e) {
			e.printStackTrace();
		}
		int pagesize = 17;
		Page page = new Page(reportamount,pagesize,pageindex);
		page.generatepage();
		
		//set report
		try {
			backinfo = DAOFactory.getIReportDAOInstance().listReport(report,page);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		//jump to page
		req.setAttribute("backinfo", backinfo);// array report list
		req.setAttribute("reportamount", reportamount);// total number of user's report
		req.setAttribute("reportpage", page);// total page of user's report
		req.setAttribute("contentPage", contentPage); //set the content page in the firstpage
		req.getRequestDispatcher(path).forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
