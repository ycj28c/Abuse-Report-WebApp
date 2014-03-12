package mvc.servlet;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import mvc.factory.*;
import mvc.vo.*;

public class NewReportServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//set variable
		HttpSession session = req.getSession();
		String userid = session.getAttribute("userid").toString();
		boolean flag = false;
		String info = new String();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		String path = "newreport.jsp";	
		String name = req.getParameter("username");
		String description = req.getParameter("description");
		int reportid = 0;
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
		try {
			reportid = DAOFactory.getIReportDAOInstance().addreport(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//add the reportid for attachment
		report.setreportid(reportid);
		try {
			flag = DAOFactory.getIAttachDAOInstance().setReportId(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//jump to page
		if(reportid!=0){
			info  = "Add report successfully!";	
			if(flag)
				info += " Set reportid for attachment successfully!";
			else
				info += " No attachment were seted!";
		}
		else{
			info  = "Fail when adding report!";
			if(flag)
				info += " Set reportid for attachment successfully!";
			else
				info += " No attachment were seted!";
		}
		req.setAttribute("info", info);// back message
		req.getRequestDispatcher(path).forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// µ÷ÓÃdoGet()²Ù×÷
	}
}
