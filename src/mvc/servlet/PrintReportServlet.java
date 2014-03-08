package mvc.servlet;

import itext.DispositionLetter;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import mvc.factory.*;
import mvc.vo.*;

public class PrintReportServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = "printjump.jsp";
		String letter_path = req.getSession().getServletContext().getRealPath("");
		int reportid = Integer.parseInt(req.getParameter("reportid"));	
		Report report = new Report();// 实例化VO
		report.setreportid(reportid);
		try {
			DAOFactory.getIReportDAOInstance().readReportById(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DispositionLetter letter = new DispositionLetter(); 
		try {
			letter.setPath(letter_path);
			letter.makeLetter();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		req.setAttribute("report", report);
		req.setAttribute("PDFpath",letter.getPDFPath());
		//req.setAttribute("PDFpath","../../pdf/dispositionletter.pdf");
		req.getRequestDispatcher(path).forward(req, resp);// 跳转
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// 调用doGet()操作
	}
}
