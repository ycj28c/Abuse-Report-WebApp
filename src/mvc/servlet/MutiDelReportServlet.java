package mvc.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import mvc.factory.*;
import mvc.vo.Report;

public class MutiDelReportServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//set variable
		HttpSession session = req.getSession();
		String userid = session.getAttribute("userid").toString();
		boolean flag = false;
		String path = "firstpage.jsp";
		String reportIdArrary[] = req.getParameterValues("num");
		Report report = new Report();
		report.setuserid(userid);
		//database operation
		try {
			flag = DAOFactory.getIReportDAOInstance().mutiDelReport(reportIdArrary,report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//jump to page
		req.getRequestDispatcher(path).forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
