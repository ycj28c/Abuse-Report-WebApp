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
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//set variable
		HttpSession session = req.getSession();
		String userid = session.getAttribute("userid").toString();
		int reportid = Integer.parseInt(req.getParameter("reportid"));
		boolean flag = false;
		String info = new String();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		String succ_path = "firstpage.jsp";	
		String fail_path = "editreport.jsp";	
		String name = req.getParameter("username");
		String description = req.getParameter("description");
		try {
			time = sdf.parse(req.getParameter("time"));
		} catch (ParseException e1) {
			 System.out.println(e1.getMessage()); 
		}
		//set report
		Report report = new Report();
		report.setuserid(userid);
		report.setName(name);
		report.settime(time);
		report.setdiscript(description);
		report.setreportid(reportid);
		try {
			flag = DAOFactory.getIReportDAOInstance().updatereport(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//add the reportid for attachment
		report.setreportid(reportid);
		try {
			DAOFactory.getIAttachDAOInstance().setReportId(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//jump to page
		if(flag){
			req.getRequestDispatcher(succ_path).forward(req, resp);
		}
		else{
			info  = "Fail when updating report!";
			req.setAttribute("info", info);
			req.getRequestDispatcher(fail_path).forward(req, resp);
		}	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
