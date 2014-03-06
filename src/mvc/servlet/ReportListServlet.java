package mvc.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import mvc.factory.*;
import mvc.vo.*;

public class ReportListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userid = req.getParameter("userid");// 接受userid内容
		// String userid = "1"; //测试
		// String path = "report.jsp";
		String path = "firstpage.jsp";
		ArrayList<Report> backinfo = new ArrayList<Report>();// 保存所有返回信息

		Report report = new Report();// 实例化VO
		report.setuserid(userid);// 设置userid
		try {
			backinfo = DAOFactory.getIReportDAOInstance().listreport(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("backinfo", backinfo);// 保存错误信息
		req.getRequestDispatcher(path).forward(req, resp);// 跳转
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// 调用doGet()操作
	}
}
