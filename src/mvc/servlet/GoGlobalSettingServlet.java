package mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoGlobalSettingServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = "firstpage.jsp";
		String contentPage = "/jsp/grobalvariable.jsp";
		req.setAttribute("contentPage", contentPage); //set the content page in the firstpage
		req.getRequestDispatcher(path).forward(req, resp);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
