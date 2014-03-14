package mvc.servlet;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import mvc.factory.*;
import mvc.vo.*;

public class DeleteReportServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		//set variable
		HttpSession session = req.getSession();
		String userid = session.getAttribute("userid").toString();
		boolean flag = false;
		//String info = new String();
		String path = "firstpage.jsp";
		int reportid = Integer.parseInt(req.getParameter("reportid"));
		Report report = new Report();
		report.setreportid(reportid);
		report.setuserid(userid);
		try {
			flag = DAOFactory.getIReportDAOInstance().delReportById(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//jump to page
		/*if (flag) {
			info = "delete report successfully!";
		} else {
			info = "Fail when deleting report!";
		}
		req.setAttribute("info", info);*/		
		req.getRequestDispatcher(path).forward(req, resp);// Ìø×ª
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
