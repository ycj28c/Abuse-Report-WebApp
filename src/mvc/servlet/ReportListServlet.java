package mvc.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import mvc.factory.*;
import mvc.vo.*;

public class ReportListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userid = req.getParameter("userid");// ����userid����
		// String userid = "1"; //����
		// String path = "report.jsp";
		String path = "firstpage.jsp";
		ArrayList<Report> backinfo = new ArrayList<Report>();// �������з�����Ϣ

		Report report = new Report();// ʵ����VO
		report.setuserid(userid);// ����userid
		try {
			backinfo = DAOFactory.getIReportDAOInstance().listreport(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("backinfo", backinfo);// ���������Ϣ
		req.getRequestDispatcher(path).forward(req, resp);// ��ת
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// ����doGet()����
	}
}
