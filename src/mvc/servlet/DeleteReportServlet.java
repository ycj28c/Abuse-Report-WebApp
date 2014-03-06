package mvc.servlet;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import mvc.factory.*;
import mvc.vo.*;

public class DeleteReportServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean flag = false;
		//String info = new String();
		String path = "firstpage.jsp";
		int reportid = Integer.parseInt(req.getParameter("reportid"));
		//System.out.println("reportid:" + reportid);		
		Report report = new Report();// ʵ����VO
		report.setreportid(reportid);
		try {
			flag = DAOFactory.getIReportDAOInstance().delReportById(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*if (flag) {
			info = "delete report successfully!";
		} else {
			info = "Fail when deleting report!";
		}
		req.setAttribute("info", info);// ���������Ϣ*/
		req.getRequestDispatcher(path).forward(req, resp);// ��ת
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// ����doGet()����
	}
}
