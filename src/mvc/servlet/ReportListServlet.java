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
		String path = "firstpage.jsp";
		ArrayList<Report> backinfo = new ArrayList<Report>();// �������з�����Ϣ
		int amount = 0;

		Report report = new Report();// ʵ����VO
		report.setuserid(userid);// ����userid
		
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
		req.getRequestDispatcher(path).forward(req, resp);// ��ת
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// ����doGet()����
	}
}
