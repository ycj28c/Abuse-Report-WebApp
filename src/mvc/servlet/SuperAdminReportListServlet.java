package mvc.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import structure.Page;
import mvc.factory.*;
import mvc.vo.*;

public class SuperAdminReportListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//set variable
		HttpSession session = req.getSession();
		String userid = session.getAttribute("userid").toString();
		int pageindex = Integer.parseInt(req.getParameter("pageindex"));//current page
		//int totalpage = 0;
		int reportamount = 0;
		String path = "firstpage.jsp";
		String contentPage = "/jsp/superAdminRepList.jsp";
		ArrayList<Report> backinfo = new ArrayList<Report>();	
		Report report = new Report();
		report.setuserid(userid);
		boolean flag = false;
		//judge if the userid is really has this role
		AuthorityMapping authorityMapping = new AuthorityMapping();
		authorityMapping.setUserId(userid);
		authorityMapping.setRoleId("4"); //super admin authority
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
		//set page
		try {
			reportamount = DAOFactory.getIReportDAOInstance().getAmountSuperAdmin(); //get amount of records user have	
		} catch (Exception e) {
			e.printStackTrace();
		}
		int pagesize = 17; //each page display 17 record
		Page page = new Page(reportamount,pagesize,pageindex);
		page.generatepage();
		
		//set report
		try {
			backinfo = DAOFactory.getIReportDAOInstance().superAdminListReport(page);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		//jump to page
		req.setAttribute("backinfo", backinfo);// array report list
		req.setAttribute("reportamount", reportamount);// total number of user's report
		req.setAttribute("reportpage", page);// total page of user's report
		req.setAttribute("contentPage", contentPage); //set the content page in the firstpage
		req.getRequestDispatcher(path).forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
