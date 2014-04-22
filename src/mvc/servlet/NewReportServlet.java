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
	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		//set variable
		HttpSession session = req.getSession();
		String userid = session.getAttribute("userid").toString();
		String username = session.getAttribute("username").toString();
		String groupid = session.getAttribute("groupid").toString();
		boolean flag = false;
		//String info = new String();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date time = new java.util.Date();
		java.sql.Date trans_time = new java.sql.Date(0);
		String path = "newreport.jsp";	
		String allegedabuser = req.getParameter("allegedabuser");
		int reportid = 0;
		try {
			time = sdf.parse(req.getParameter("time"));
			trans_time = new java.sql.Date(time.getTime()); 
		} catch (ParseException e1) {
			 System.out.println(e1.getMessage()); 
		}
		String allegedvictim = req.getParameter("allegedvictim");
		String abusefrequency ="";
		if(true){
			String abusefrequencydate = req.getParameter("abusefrequencydate");
			String abusefrequencytend = req.getParameter("abusefrequencytend");
			abusefrequency+=abusefrequencydate;
			abusefrequency+=",";
			abusefrequency+=abusefrequencytend;
		}
		String abusetypeArray[] = req.getParameterValues("abusetype");
		String abusetype = "";
		if(abusetypeArray!=null){
		for(int i=0;i<abusetypeArray.length;i++){
			if(abusetypeArray[i]=="Other"||abusetypeArray[i].equals("Other")){
				abusetypeArray[i] = req.getParameter("abusetypeothertext");
				if(abusetypeArray[i]==""||abusetypeArray[i].equals(""))
					abusetypeArray[i] = "None";
			}
			if(i == abusetypeArray.length-1)
				abusetype += abusetypeArray[i];
			else
				abusetype += abusetypeArray[i]+",";		
		}}
		String awareof = req.getParameter("awareof");
		String dppchotline = req.getParameter("dppchotline");
		if(dppchotline=="yes"||dppchotline.equals("yes")){
			dppchotline = req.getParameter("dppchotlinetext");
		}
		String investigatorrisk = req.getParameter("investigatorrisk");
		if(investigatorrisk=="yes"||investigatorrisk.equals("yes")){
			investigatorrisk = req.getParameter("investigatorrisktext");
		}
		String narrativeform = req.getParameter("narrativeform");
		String risklevel = req.getParameter("risklevel");
		String resultinginjure = req.getParameter("resultinginjure");
		String witness = req.getParameter("witness");
		String caregiverrelationship = req.getParameter("caregiverrelationship");
		//set report
		Report report = new Report();
		report.setUserid(userid);
		//report.setName(username);
		report.setAbusername(allegedabuser);
		report.setTime(trans_time); 
		report.setVictimname(allegedvictim);
		report.setFrequency(abusefrequency);
		report.setAbusetype(abusetype);
		report.setAwareof(awareof);
		report.setDppchotline(dppchotline);
		report.setInvestigatorrisk(investigatorrisk);
		report.setNarrativeform(narrativeform);
		report.setRisklevel(risklevel);
		report.setResultinginjure(resultinginjure);
		report.setWitness(witness);
		report.setCaregiverrelationship(caregiverrelationship);
		report.setStatus("initiated");
		report.setGroupid(groupid);
		report.setUsername(username);
		//set abuser id
		User abuser = new User();
		abuser.setName(allegedabuser);
		try {
			abuser = DAOFactory.getIUserDAOInstance().getInfoByName(abuser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(abuser.getUserid()==null||"".equals(abuser.getUserid())){
			report.setAbuserid(11111);
		}
		else{
			report.setAbuserid(Integer.parseInt(abuser.getUserid()));
		}
		//set victim id
		Patient victim = new Patient();
		victim.setName(allegedvictim);
		try {
			victim = DAOFactory.getIPatientDAOInstance().getinfoByName(victim);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(victim.getPkPatient()==null){
			report.setVictimid(2);
		}
		else{
			report.setVictimid(victim.getPkPatient());
		}
		
		try {
			reportid = DAOFactory.getIReportDAOInstance().addreport(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//add the reportid for attachment
		report.setReportid(reportid);
		try {
			flag = DAOFactory.getIAttachDAOInstance().setReportId(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//jump to page
		/*if(reportid!=0){
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
		req.setAttribute("info", info);// back message*/
		req.getRequestDispatcher(path).forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
