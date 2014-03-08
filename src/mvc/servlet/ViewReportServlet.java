package mvc.servlet;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import mvc.factory.*;
import mvc.vo.*;

public class ViewReportServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = "viewreport.jsp";
		int reportid = Integer.parseInt(req.getParameter("reportid"));	
		Report report = new Report();// ʵ����VO
		report.setreportid(reportid);
		try {
			DAOFactory.getIReportDAOInstance().readReportById(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("report", report);
		req.getRequestDispatcher(path).forward(req, resp);// ��ת
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// ����doGet()����
	}
}
