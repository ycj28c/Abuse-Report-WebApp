package mvc.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import mvc.factory.*;

public class MutiDelReportServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//session verify
		if(req.getSession(false).getAttribute("userid")==null){
			String errorpath = "sessionloss.jsp";
			req.getRequestDispatcher(errorpath).forward(req, resp);
		}
		else{
			//set variable
			boolean flag = false;
			String path = "firstpage.jsp";
			String reportIdArrary[] = req.getParameterValues("num");
			//database operation
			try {
				flag = DAOFactory.getIReportDAOInstance().mutiDelReport(reportIdArrary);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//jump to page
			req.getRequestDispatcher(path).forward(req, resp);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
