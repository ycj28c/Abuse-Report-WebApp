package mvc.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import mvc.factory.*;
import mvc.vo.*;

public class PrepareNewReport extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//session verify
		if(req.getSession(false).getAttribute("userid")==null){
			String errorpath = "sessionloss.jsp";
			req.getRequestDispatcher(errorpath).forward(req, resp);
		}
		else{
			//set variable
			String prjPath = req.getSession().getServletContext().getRealPath("/");
			HttpSession session = req.getSession();
			String userid = session.getAttribute("userid").toString();
			//System.out.println("userid:"+userid);
			boolean flag = false;
			String path = "newreport.jsp";
			//set attachment attribute	
			Attach attach = new Attach();
			attach.setUserId(userid);
			//databse operation
			try {
				flag = DAOFactory.getIAttachDAOInstance().deleteEmptyReportId(attach,prjPath);
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
