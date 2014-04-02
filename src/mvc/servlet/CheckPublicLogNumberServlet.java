package mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import mvc.factory.DAOFactory;
import mvc.vo.Decision;
import mvc.vo.Disposition;
import mvc.vo.Investigation;
import mvc.vo.Report;
import mvc.vo.Respond;

public class CheckPublicLogNumberServlet extends HttpServlet {
	private String publiclognumber;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cahce,must-revalidate");
		PrintWriter out = response.getWriter();

		publiclognumber = request.getParameter("publiclognumber");
		publiclognumber = new String(publiclognumber.getBytes("iso-8859-1"),"utf-8"); // from chinese to english

		createXML(out);

		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void createXML(PrintWriter out) {
		Document doc = null;

		Investigation investigation = new Investigation();
		investigation.setPubliclognumber(publiclognumber);
		try {
			investigation = DAOFactory.getIInvestigationDAOInstance()
					.isPublicLogNumberExist(investigation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (investigation.getPkInvestigation() != null) { // if this public log
															// number is existed
			Element root = null;
			// if the status if done, then return done
			// if the report id exist,get the detail
			// if disposition id exist,get the detail
			// if respond id exist,get the detail
			// if the decision id exist,get the detail
			try {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				doc = db.newDocument();
				root = doc.createElement("investigation");
				doc.appendChild(root);
				Element Elstatus = doc.createElement("status");
				Elstatus.appendChild(doc.createTextNode("existed investigation"));
				root.appendChild(Elstatus);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(investigation.getReportid()!=null){
				Report report = new Report();
				report.setReportid(Integer.parseInt(investigation.getReportid()));
				try {
					report = DAOFactory.getIReportDAOInstance().readReportById(report);
					Element Elreport = doc.createElement("report");
					root.appendChild(Elreport);

					Element ELreportid = doc.createElement("reportid");
					ELreportid.appendChild(doc.createTextNode(String.valueOf(report.getReportid())));
					Elreport.appendChild(ELreportid);

					Element Eldate = doc.createElement("date");
					Eldate.appendChild(doc.createTextNode(String.valueOf(report.getTime())));
					Elreport.appendChild(Eldate);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (investigation.getDispositionid() != null) { // if it has disposition letter
				Disposition disposition = new Disposition();
				disposition.setPkDisposition(Integer.parseInt(investigation.getDispositionid()));
				try {
					disposition = DAOFactory.getIDispositionDAOInstance().getDispositionById(disposition);
					Element Eldisposition = doc.createElement("disposition");
					root.appendChild(Eldisposition);

					Element ELreportid = doc.createElement("reportid_dis");
					ELreportid.appendChild(doc.createTextNode(disposition.getReportid()));
					Eldisposition.appendChild(ELreportid);

					Element Elinvestigationid = doc.createElement("investigationid_dis");
					Elinvestigationid.appendChild(doc.createTextNode(disposition.getInvestigationid()));
					Eldisposition.appendChild(Elinvestigationid);

					Element ELdescription = doc.createElement("description_dis");
					ELdescription.appendChild(doc.createTextNode(disposition.getDescription()));
					Eldisposition.appendChild(ELdescription);

					Element ELattacholdname = doc.createElement("attacholdname_dis");
					ELattacholdname.appendChild(doc.createTextNode(disposition.getAttacholdname()));
					Eldisposition.appendChild(ELattacholdname);

					Element ELattachnewname = doc.createElement("attachnewname_dis");
					ELattachnewname.appendChild(doc.createTextNode(disposition.getAttachnewname()));
					Eldisposition.appendChild(ELattachnewname);

					Element ELattachpath = doc.createElement("attachpath_dis");
					ELattachpath.appendChild(doc.createTextNode(disposition.getAttachpath()));
					Eldisposition.appendChild(ELattachpath);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if (investigation.getRespondid() != null) {
				Respond respond = new Respond();
				respond.setPkRespond(Integer.parseInt(investigation.getRespondid()));
				try {
					respond = DAOFactory.getIRespondDAOInstance().getRespondById(respond);
					Element Elrespond = doc.createElement("respond");
					root.appendChild(Elrespond);

					Element ELreportid = doc.createElement("reportid_res");
					ELreportid.appendChild(doc.createTextNode(respond.getReportid()));
					Elrespond.appendChild(ELreportid);

					Element Elinvestigationid = doc.createElement("investigationid_res");
					Elinvestigationid.appendChild(doc.createTextNode(respond.getInvestigationid()));
					Elrespond.appendChild(Elinvestigationid);

					Element ELcontent = doc.createElement("content_res");
					ELcontent.appendChild(doc.createTextNode(respond.getContent()));
					Elrespond.appendChild(ELcontent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(investigation.getDecisionid()!=null){
				Decision decision = new Decision();
				decision.setPkDecision(Integer.parseInt(investigation.getDecisionid()));
				try{
					decision = DAOFactory.getIDecisionDAOInstance().getDecisionById(decision);
					Element Eldicision = doc.createElement("decision");
					root.appendChild(Eldicision);

					Element ELreportid = doc.createElement("reportid_dec");
					ELreportid.appendChild(doc.createTextNode(decision.getReportid()));
					Eldicision.appendChild(ELreportid);

					Element Elinvestigationid = doc.createElement("investigationid_dec");
					Elinvestigationid.appendChild(doc.createTextNode(decision.getInvestigationid()));
					Eldicision.appendChild(Elinvestigationid);

					Element ELdescription = doc.createElement("description_dec");
					ELdescription.appendChild(doc.createTextNode(decision.getDescription()));
					Eldicision.appendChild(ELdescription);

					Element ELattacholdname = doc.createElement("attacholdname_dec");
					ELattacholdname.appendChild(doc.createTextNode(decision.getAttacholdname()));
					Eldicision.appendChild(ELattacholdname);

					Element ELattachnewname = doc.createElement("attachnewname_dec");
					ELattachnewname.appendChild(doc.createTextNode(decision.getAttachnewname()));
					Eldicision.appendChild(ELattachnewname);

					Element ELattachpath = doc.createElement("attachpath_dec");
					ELattachpath.appendChild(doc.createTextNode(decision.getAttachpath()));
					Eldicision.appendChild(ELattachpath);
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		} 
		else {
			try {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				doc = db.newDocument();
				Element root = doc.createElement("investigation");
				doc.appendChild(root);
				Element Elstatus = doc.createElement("status");
				Elstatus.appendChild(doc.createTextNode("new investigation"));
				root.appendChild(Elstatus);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer ts = tf.newTransformer();
			ts.transform(new DOMSource(doc), new StreamResult(out));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
