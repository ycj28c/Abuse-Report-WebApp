package mvc.servlet;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import mvc.factory.*;
import mvc.vo.*;

public class MutiDelReportServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean flag = false;
		// String info = new String();
		String path = "firstpage.jsp";
		String reportid[] = req.getParameterValues("num");
		Report report = new Report();// ʵ����VO
		try {
			flag = DAOFactory.getIReportDAOInstance().mutiDelReport(reportid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher(path).forward(req, resp);// ��ת
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// ����doGet()����
	}
}
