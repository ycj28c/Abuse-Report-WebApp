package mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.factory.DAOFactory;
import mvc.vo.Patient;
import mvc.vo.Report;

public class NewPatientServlet extends HttpServlet {

	public NewPatientServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//session verify
		if(request.getSession(false).getAttribute("userid")==null){
			String errorpath = "sessionloss.jsp";
			request.getRequestDispatcher(errorpath).forward(request, response);
		}
		else{
			//set variable
			HttpSession session = request.getSession();
			String userid = session.getAttribute("userid").toString();
			boolean flag = false;
			//String info = new String();
			String path = "newpatient.jsp";	
			String address = request.getParameter("address");
			int	age = 0;
			if(request.getParameter("age")!=""||!request.getParameter("age").equals("")){
				age = Integer.parseInt(request.getParameter("age"));
			}
			String collContact = request.getParameter("collcontact");
			String commNeed = request.getParameter("commneed");
			if(commNeed=="Other"||commNeed.equals("Other")){
				if(request.getParameter("commNeedothertext")!=""||!request.getParameter("commNeedothertext").equals(""))
					commNeed = request.getParameter("commNeedothertext");
				else
					commNeed = "Empty";
			}
			String dob = request.getParameter("dob");
			String disabilityArray[] = request.getParameterValues("disability");
			String disability = "";
			if(disabilityArray!=null){
			for(int i=0;i<disabilityArray.length;i++){
				if(disabilityArray[i]=="other"||disabilityArray[i].equals("other")){
					disabilityArray[i] = request.getParameter("disabilityothertext");
				}
				if(i == disabilityArray.length-1)
					disability +=disabilityArray[i];
				else
					disability += disabilityArray[i]+",";		
			}}
			String ethnicity = request.getParameter("ethnicity");
			if(ethnicity=="Other"||ethnicity.equals("Other")){
				if(request.getParameter("ethnicityothertext")!=""||!request.getParameter("ethnicityothertext").equals(""))
					ethnicity = request.getParameter("ethnicityothertext");
				else
					ethnicity = "Empty";
			}
			String marStat = request.getParameter("marStat");
			String name = request.getParameter("name");
			String servBy = request.getParameter("servby");
			if(servBy=="Other"||servBy.equals("Other")){
				if(request.getParameter("servbyothertext")!=""||!request.getParameter("servbyothertext").equals(""))
					servBy = request.getParameter("servbyothertext");
				else
					servBy = "Empty";
			}
			String servType = request.getParameter("servtype");
			if(servType=="Other"||servType.equals("Other")){
				if(request.getParameter("servtypeothertext")!=""||!request.getParameter("servtypeothertext").equals(""))
					servBy = request.getParameter("servtypeothertext");
				else
					servBy = "Empty";
			}
			String sex = request.getParameter("sex");
			String telephone = request.getParameter("telephone");
			int patientid = 0;
			//set patient VO
			Patient patient = new Patient();
			patient.setAddress(address);
			patient.setAge(age);
			patient.setCollContact(collContact);
			patient.setCommNeed(commNeed);
			patient.setDisability(disability);
			patient.setDob(dob);
			patient.setEthnicity(ethnicity);
			patient.setMarStat(marStat);
			patient.setName(name);
			patient.setServBy(servBy);
			patient.setServType(servType);
			patient.setSex(sex);
			patient.setTelephone(telephone);
			//debug
			/*System.out.println("NewPatientServlet-getParameter-address:"+address);
			System.out.println("NewPatientServlet-getParameter-age:"+age);
			System.out.println("NewPatientServlet-getParameter-collContact:"+collContact);
			System.out.println("NewPatientServlet-getParameter-commNeed:"+commNeed);
			System.out.println("NewPatientServlet-getParameter-disability:"+disability);
			System.out.println("NewPatientServlet-getParameter-dob:"+dob);
			System.out.println("NewPatientServlet-getParameter-ethnicity:"+ethnicity);
			System.out.println("NewPatientServlet-getParameter-marStat:"+marStat);
			System.out.println("NewPatientServlet-getParameter-name:"+name);
			System.out.println("NewPatientServlet-getParameter-servBy:"+servBy);
			System.out.println("NewPatientServlet-getParameter-servType:"+servType);
			System.out.println("NewPatientServlet-getParameter-sex:"+sex);
			System.out.println("NewPatientServlet-getParameter-telephone:"+telephone);*/
			//database operation
			try {
				patientid = DAOFactory.getIPatientDAOInstance().addPatient(patient);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//jump to page			
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
