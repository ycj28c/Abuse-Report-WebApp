package mvc.servlet;

import java.awt.SystemTray;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import structure.Page;
import mvc.factory.*;
import mvc.vo.*;

public class SupervisorReportListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//set variable
		HttpSession session = req.getSession();
		String userid = session.getAttribute("userid").toString();
		String roleid = req.getParameter("roleid");
		//String groupid = "2";
		int pageindex = Integer.parseInt(req.getParameter("pageindex"));//current page
		//int totalpage = 0;
		int reportamount = 0;
		String path = "firstpage.jsp";
		String contentPage ="/jsp/supervisorRepList.jsp";
		ArrayList<Report> backinfo = new ArrayList<Report>();	
		boolean flag = false;
		//judge if the userid is really has this role
		AuthorityMapping authorityMapping = new AuthorityMapping();
		authorityMapping.setUserId(userid);
		authorityMapping.setRoleId(roleid);
		try {
			flag = DAOFactory.getIAuthorityMappingDAOInstance().verifyUser(authorityMapping);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!flag){
			System.out.println("the user don't have that role");
			req.getRequestDispatcher(path).forward(req, resp);
			return;
		}
		//set report
		Report report = new Report();
		report.setuserid(userid);	
		//set page
		try {
			reportamount = DAOFactory.getIReportDAOInstance().getAmountSupervisor(roleid);	//get amount of records the role's group have	
		} catch (Exception e) {
			e.printStackTrace();
		}
		int pagesize = 17;
		Page page = new Page(reportamount,pagesize,pageindex);
		page.generatepage();
		
		//set report
		try {
			backinfo = DAOFactory.getIReportDAOInstance().supervisorListReport(page,roleid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//jump to page
		req.setAttribute("backinfo", backinfo);// array report list
		req.setAttribute("reportamount", reportamount);// total number of user's report
		req.setAttribute("reportpage", page);// total page of user's report
		req.setAttribute("roleid", roleid);// total page of user's report
		req.setAttribute("contentPage", contentPage); //set the content page in the firstpage
		req.getRequestDispatcher(path).forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
