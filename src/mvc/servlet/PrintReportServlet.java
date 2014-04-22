package mvc.servlet;

import itext.AbuseReportPDF;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import mvc.factory.*;
import mvc.vo.*;

public class PrintReportServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//set variable
		String path = "printjump.jsp";
		HttpSession session = req.getSession();
		String pdf_path = session.getServletContext().getRealPath("/");//the location in tomcat
		//System.out.println("letter_path:"+letter_path);
		//String userid = session.getAttribute("userid").toString();
		int reportid = Integer.parseInt(req.getParameter("reportid"));	
		//System.out.println("dddddd:"+reportid);
		Report report = new Report();
		report.setReportid(reportid);
		//report.setUserid(userid);
		try {
			DAOFactory.getIReportDAOInstance().readReportById(report);
			//after send report change the status
			report.setStatus("created");
			DAOFactory.getIReportDAOInstance().updateStatus(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("cccccc:"+report.getAbusername());
		//make the disposition itext pdf
		//DispositionLetter letter = new DispositionLetter(); 
		AbuseReportPDF pdf = new AbuseReportPDF(); 
		pdf.setPath(pdf_path);
		pdf.setReport(report);
		try {
			pdf.makeLetter();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		//jump to page
		req.setAttribute("report", report);
		req.setAttribute("PDFpath","../../pdf/"+pdf.getPDFname());
		//req.setAttribute("PDFpath","../../pdf/dispositionletter.pdf");
		req.getRequestDispatcher(path).forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
