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
		String userid = req.getParameter("userid");// ����userid����
		int pageindex = Integer.parseInt(req.getParameter("pageindex"));//��ǰpage
		int totalpage = 0;
		int reportamount = 0;
		String path = "firstpage.jsp";
		ArrayList<Report> backinfo = new ArrayList<Report>();// �������з�����Ϣ		
		Report report = new Report();// ʵ����VO
		report.setuserid(userid);// ����userid
		
		//set page
		try {
			reportamount = DAOFactory.getIReportDAOInstance().getAmount(report);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		int pagesize = 31;
		Page page = new Page(reportamount,pagesize,pageindex);
		page.generatepage();
		
		//set report
		try {
			backinfo = DAOFactory.getIReportDAOInstance().listReport(report,page);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("backinfo", backinfo);// array report list
		req.setAttribute("reportamount", reportamount);// total number of user's report
		req.setAttribute("reportpage", page);// total page of user's report
		req.getRequestDispatcher(path).forward(req, resp);// ��ת
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// ����doGet()����
	}
}
