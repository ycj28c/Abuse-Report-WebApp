package itext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import mvc.factory.DAOFactory;
import mvc.vo.Patient;
import mvc.vo.Report;
import mvc.vo.User;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.*;

public class AbuseReportPDF implements LetterInterface{
	private Document document = null;
	private String path = null;
	private String PDFpath = null;
	private String PDFname = null;
	private static int num = 0;
	//set variable
	private Report report;
	
	public AbuseReportPDF() {
		Rectangle pageSize = new Rectangle(144, 720); // set the pagesize
		this.document = new Document();
	}
	
	public void setReport(Report report) {
		this.report = report;
	}

	public void setPath(String path){
		this.path = path;
		this.PDFname = "AbuseReport"+this.num+".pdf";
		this.PDFpath = this.path+"/pdf/"+this.PDFname;
		this.num++;
		try {
			PdfWriter.getInstance(this.document, new FileOutputStream(this.PDFpath));
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public String getPDFPath(){
		return this.PDFpath;	
	}
	
	public String getPDFname(){
		return this.PDFname;	
	}
	
	public void makeLetter() throws Exception{
		try {
			// document description
			document.addAuthor("Yan");
			document.addCreationDate();
			document.addCreator("Yan");
			document.addSubject("iText test");
			document.addTitle("Abuse Report");
			document.addKeywords("Abuse, Report, health, yan, 509");

			// open document
			document.open();

			// set font
			BaseFont baseFT = BaseFont.createFont(path+"/font/Arial.TTF",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			Font font0 = new Font(baseFT, 10, Font.BOLD); // 12������,����
			//BaseFont baseFT = BaseFont.createFont(path+"/font/STSong.TTF",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			//Font font0 = new Font(baseFT, 12); // 12������,����
			baseFT = BaseFont.createFont(path+"/font/Arial.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			Font font1 = new Font(baseFT, 10, Font.BOLD); // bold�Ӵ�,10��,Arial����
			baseFT = BaseFont.createFont(path+"/font/Arial.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			Font font2 = new Font(baseFT, 12, Font.BOLD); // bold�Ӵ�,12��,Arial����
			baseFT = BaseFont.createFont(path+"/font/Arial.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			Font font3 = new Font(baseFT, 10); // 11��,Arial����
			baseFT = BaseFont.createFont(path+"/font/Arial.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			Font font4 = new Font(baseFT, 16, Font.BOLD); // bold�Ӵ�,24��,Arial����


			/***********************************************************************************************/
			/**********************************************page one*****************************************/
			/***********************************************************************************************/
			// ���1
			PdfPTable t1 = new PdfPTable(11); // 11�еı��
			t1.setTotalWidth(500);// ���ñ����ܿ��
			t1.setLockedWidth(true); // ʹ��������������������ʹ�����º��������������
			//��ȡtable��Ĭ�ϵ�Ԫ��
			//t1.getDefaultCell().setMinimumHeight(30f); 
			//t1.getDefaultCell().setLeading(20f, 1.0f);
			//t1.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER); //getDefualtCell��������
			//����ʹ�÷���setSpacingBefore��setSpacingAfter�������ñ��֮��ļ��  
			//t1.setSpacingAfter(20f);
			//t1.setSpacingBefore(20f);
			// ��1�е�1��
			// ͼƬ
			Image png = Image.getInstance(path+"/image/dppc.png");
			png.scalePercent(33);
			PdfPCell c1 = new PdfPCell(png);
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setColspan(11);// ��ʾһ��ռ11��
			c1.disableBorderSide(1); // �����ϱ߿�
			//c1.disableBorderSide(2); // �����±ߌ�
			c1.disableBorderSide(4); // ������ߌ�
			c1.disableBorderSide(8); // �����ұߌ�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			// ��2�е�1-5��
			c1 = new PdfPCell(new Paragraph("Reporter:", font0));
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setColspan(5);// ��ʾһ��ռ5��
			c1.setBorderWidth(2f);
			t1.addCell(c1);// ���뵽table
			// ��2�е�6-11��
			c1 = new PdfPCell(new Paragraph("Alleged Victim:", font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setColspan(6);// ռ1��
			c1.setBorderWidth(2f);
			t1.addCell(c1);
			// ��3�е�1-5��
			User reporter = new User();
			reporter.setUserid(report.getUserid()); // test data
			try {
				reporter = DAOFactory.getIUserDAOInstance().getInfo(reporter);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String mandate = reporter.getMandated();
			String isMandated= (mandate=="yes"||mandate.equals("yes"))?"*":" ";
			String isNonMandated= (mandate=="yes"||mandate.equals("yes"))?" ":"*";
			c1 = new PdfPCell(
					new Paragraph( 30f,
							"Name: fakename"
								+ "\nAddress:"+ reporter.getAddress()
								+ "\n" 
								+ "\nDaytime telephone:("+ reporter.getTelephone()+")"
								+ "\n("+isMandated+")Mandated" 
								+ "\n("+isNonMandated+")Non-Mandated",
							font0));
			//c1.setPadding(20); //������������
			//c1.setMinimumHeight(200f); //���õ�Ԫ��ĸ߶�
			//c1.setFixedHeight(30f);
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			//c1.setRowspan(20); //����ռ�ö�������
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setColspan(5);// ��ʾһ��ռ5��
			c1.disableBorderSide(2); // �����±ߌ�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);// ���뵽table
			// ��3�е�6-11��
			Patient victim = new Patient();
			if(report.getVictimid().toString()==null||"".equals(report.getVictimid().toString())){
				victim.setPkPatient(2);
			}
			else{
				victim.setPkPatient(report.getVictimid()); // test data
			}	
			try {
				victim = DAOFactory.getIPatientDAOInstance().getinfo(victim);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String victimsex = victim.getSex();
			String isMale= (victimsex=="Male"||victimsex.equals("Male"))?"*":" ";
			String isFemale= (victimsex=="Female"||victimsex.equals("Female"))?"*":" ";
			c1 = new PdfPCell(
					new Paragraph(
							"Name: fakename"
							+"\nAddress:" + victim.getAddress()
							+"\n"
							+"\nTelephone:("+victim.getTelephone()+")"
							+"\nSex:("+isMale+")Male ("+isFemale+")Female     DOB:"+victim.getDob()
							+"\nAge:"+victim.getAge()+"		"+"Marital Status:"+victim.getMarStat(),
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ1��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			// ��4�е�1-5��
			c1 = new PdfPCell(
					new Paragraph(
							"Relationship to Alleged Victim:",
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			// ��4�е�6-11��
			HashMap<String, String> hashDisability = new HashMap<String, String>();
			String[] arrayDisability = victim.getDisability().split(",");
			for(int i=0;i<arrayDisability.length;i++){
				if(arrayDisability[i]=="Mental Retardation"||"Mental Retardation".equals(arrayDisability[i])
					||arrayDisability[i]=="Mental Illness"||"Mental Illness".equals(arrayDisability[i])
					||arrayDisability[i]=="Mobility"||"Mobility".equals(arrayDisability[i])
					||arrayDisability[i]=="Visual"||"Visual".equals(arrayDisability[i])
					||arrayDisability[i]=="Head Injury"||"Head Injury".equals(arrayDisability[i])
					||arrayDisability[i]=="Deaf/Hard of Hearing"||"Deaf/Hard of Hearing".equals(arrayDisability[i])
					||arrayDisability[i]=="Cerebral Palsy"||"Cerebral Palsy".equals(arrayDisability[i])
					||arrayDisability[i]=="Multiple Sclerosis"||"Multiple Sclerosis".equals(arrayDisability[i])
					||arrayDisability[i]=="Seizures"||"Seizures".equals(arrayDisability[i]))
					hashDisability.put(arrayDisability[i], arrayDisability[i]);
				else{
					hashDisability.put("Other", arrayDisability[i]);
				}
			}
			String isMentalRetardation = hashDisability.containsKey("Mental Retardation")?"*":" ";
			String isMentalIllness = hashDisability.containsKey("Mental Illness")?"*":" ";
			String isMobility = hashDisability.containsKey("Mobility")?"*":" ";
			String isVisual = hashDisability.containsKey("Visual")?"*":" ";
			String isHeadInjury = hashDisability.containsKey("Head Injury")?"*":" ";
			String isDeaf = hashDisability.containsKey("Deaf/Hard of Hearing")?"*":" ";
			String isCerebralPalsy = hashDisability.containsKey("Cerebral Palsy")?"*":" ";
			String isMultipleSclerosis = hashDisability.containsKey("Multiple Sclerosis")?"*":" ";
			String isSeizures = hashDisability.containsKey("Seizures")?"*":" ";
			String isDisOther = hashDisability.containsKey("Other")?"*":" ";
			String otherDisSpecify = hashDisability.containsKey("Other")?hashDisability.get("Other").toString():"";
			c1 = new PdfPCell(new Paragraph("Disability: (check as apply)",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ1��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			// ��5�е�1-5��
			c1 = new PdfPCell(new Paragraph("Alleged Abuser: (Alleged Victim's Caretaker)", font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			// ��5�е�6-11��
			c1 = new PdfPCell(new Paragraph("("+isMentalRetardation+") Mental Retardation ("+isMentalIllness+") Mental Illness",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(2); // �����±ߌ�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			// ��6�е�1-5��
			User abuser = new User();
			if(report.getAbuserid().toString()==null||"".equals(report.getAbuserid().toString())){
				abuser.setUserid("11111");
			}
			else{
				abuser.setUserid(report.getAbuserid().toString()); // test data
			}
			try {
				abuser = DAOFactory.getIUserDAOInstance().getInfo(abuser);
			} catch (Exception e) {
				e.printStackTrace();
			}
			c1 = new PdfPCell(
					new Paragraph(
							"Name(s): fakename"
							+"\nHome address:"+abuser.getAddress()
							+"\n"
							+"\nRelationship to victim:",
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(2); // �����±ߌ�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��6�е�6-11��
			c1 = new PdfPCell(
					new Paragraph(
							"("+isMobility+") Mobility ("+isHeadInjury+") Head Injury"
							+"\n("+isVisual+") Visual ("+isDeaf+") Deaf / Hard of Hearing"
							+"\n("+isCerebralPalsy+") Cerebral Palsy ("+isMultipleSclerosis+") Multiple Sclerosis"
							+"\n("+isSeizures+") Seizures ("+isDisOther+") Other (Specify:"+otherDisSpecify+")",
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			// ��7�е�1-5��
			c1 = new PdfPCell(new Paragraph( "\nSoc. Security #:"+abuser.getSSN()+"		"
					+"DOB:"+abuser.getDOB(),font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(1); // �����ϱߌ�
			c1.disableBorderSide(2); // �����±ߌ�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			// ��7�е�6-11��
			c1 = new PdfPCell(new Paragraph("Communication Needs:",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			// ��8�е�1-5��
			c1 = new PdfPCell(new Paragraph("Telephone: ("+abuser.getTelephone()+")",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.disableBorderSide(2); // �����±ߌ�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			// ��8�е�6-11��
			HashMap<String, String> hashCommNeed = new HashMap<String, String>();
			String[] arrayCommNeed = victim.getDisability().split(",");
			for(int i=0;i<arrayCommNeed.length;i++){
				if(arrayCommNeed[i]=="TTY"||"TTY".equals(arrayCommNeed[i])
					||arrayCommNeed[i]=="Sign Interpreter"||"Sign Interpreter".equals(arrayCommNeed[i]))
					hashCommNeed.put(arrayCommNeed[i], arrayCommNeed[i]);
				else{
					hashCommNeed.put("Other", arrayCommNeed[i]);
				}
			}
			String isTTY = hashCommNeed.containsKey("TTY")?"*":" ";
			String isSignInterpreter = hashCommNeed.containsKey("Sign Interpreter")?"*":" ";
			String isCommOther = hashCommNeed.containsKey("Other")?"*":" ";
			String otherCommSpecify = hashCommNeed.containsKey("Other")?hashCommNeed.get("Other").toString():"";
			c1 = new PdfPCell(
					new Paragraph("("+isTTY+") TTY ("+isSignInterpreter+") " +
							"Sign Interpreter ("+isCommOther+") Other (Specify:"+otherCommSpecify+")",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��9�е�1-5��
			c1 = new PdfPCell(
					new Paragraph("Client's Guardian(s): (If any)",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��9�е�6-11��
			c1 = new PdfPCell(
					new Paragraph("Currently Served By:",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��10�е�1-5��
			c1 = new PdfPCell(
					new Paragraph(
							"Name(s):"
							+"\nAddress:"
							+"\n"
							+"\nRelationship to Alleged Victim:"
							+"\nTelephone: ( )",
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��10�е�6-11��
			String servby = victim.getServBy();
			String isMentalHealth= (servby=="Dept. of Mental Health"||servby.equals("Dept. of Mental Health"))?"*":" ";
			String isMassCommBlind= (servby=="Mass Comm./Blind"||servby.equals("Mass Comm./Blind"))?"*":" ";
			String isDevelopmentalSvcs= (servby=="Dept. of Developmental Svcs."||servby.equals("Dept. of Developmental Svcs."))?"*":" ";
			String isMassCommDeaf= (servby=="Mass. Comm./Deaf/HH"||servby.equals("Mass. Comm./Deaf/HH"))?"*":" ";
			String isRehab= (servby=="Mass. Rehab. Comm."||servby.equals("Mass. Rehab. Comm."))?"*":" ";
			String isUnknown= (servby=="Unknown"||servby.equals("Unknown"))?"*":" ";
			String isCorrection= (servby=="Dept. of Correction"||servby.equals("Dept. of Correction"))?"*":" ";
			String isPublicHealth= (servby=="Dept. of Public Health"||servby.equals("Dept. of Public Health"))?"*":" ";
			String isNone= (servby=="None"||servby.equals("None"))?"*":" ";
			String isServByOther= (servby=="Other"||servby.equals("Other"))?"*":" ";
			c1 = new PdfPCell(
					new Paragraph(
							"("+isMentalHealth+") Dept. of Mental Health ("+isMassCommBlind+") Mass Comm./Blind"
							+"\n("+isDevelopmentalSvcs+") Dept. of Developmental Svcs. ("+isMassCommDeaf+") Mass. Comm./Deaf/HH"
							+"\n("+isRehab+") Mass. Rehab. Comm. ("+isUnknown+") Unknown"
							+"\n("+isCorrection+") Dept. of Correction ("+isServByOther+") Other (Specify:_____________)"
							+"\n("+isPublicHealth+") Dept. of Public Health ("+isNone+") None",
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��11�е�1-5��
			c1 = new PdfPCell(
					new Paragraph("Collateral contacts or notifications:",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(2); // �����±ߌ�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��11�е�6-11��
			c1 = new PdfPCell(new Paragraph("Type of Service:",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��12�е�1-5��
			c1 = new PdfPCell(
					new Paragraph("(Please list, including telephone numbers.)",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��12�е�6-11��
			String servtype = victim.getServType();
			String isInstitutional= (servtype=="Institutional"||servtype.equals("Institutional"))?"*":" ";
			String isServiceCoordination= (servtype=="Service Coordination"||servtype.equals("Service Coordination"))?"*":" ";
			String isResidential= (servtype=="Residential"||servtype.equals("Residential"))?"*":" ";
			String isHomeCare= (servtype=="Foster / Spec. Home Care"||servtype.equals("Foster / Spec. Home Care"))?"*":" ";
			String isDayProgram= (servtype=="Day Program"||servtype.equals("Day Program"))?"*":" ";
			String isRespite= (servtype=="Respite"||servtype.equals("Respite"))?"*":" ";
			String isCaseManagement= (servtype=="Case Management"||servtype.equals("Case Management"))?"*":" ";
			c1 = new PdfPCell(new Paragraph("("+isInstitutional+") Institutional ("+isServiceCoordination+") Service Coordination",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(2); // �����±ߌ�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��13�е�1-5��
			c1 = new PdfPCell(
					new Paragraph(
							"\n"+victim.getCollContact()
							+"\n"
							+"\n",
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(2); // �����±ߌ�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��13�е�6-11��
			c1 = new PdfPCell(
					new Paragraph(
							"("+isResidential+") Residential ("+isHomeCare+") Foster / Spec. Home Care"
							+"\n("+isDayProgram+") Day Program ("+isRespite+") Respite"
							+"\n("+isCaseManagement+") Case Management ( ) Other (Specify:_____________)",
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��14�е�1-5��
			c1 = new PdfPCell(new Paragraph("\n",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.disableBorderSide(2); // �����±ߌ�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��14�е�6-11��
			c1 = new PdfPCell(new Paragraph("Client's Ethnicity:",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��15�е�1-5��
			c1 = new PdfPCell(
					new Paragraph(
							"\n"
							+"\n"
							+"\n",
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��15�е�6-11��
			String ethnicity = victim.getEthnicity();
			String isCaucasian= (ethnicity=="Caucasian"||ethnicity.equals("Caucasian"))?"*":" ";		
			String isHispanic= (ethnicity=="Hispanic"||ethnicity.equals("Hispanic"))?"*":" ";	
			String isAsian= (ethnicity=="Asian"||ethnicity.equals("Asian"))?"*":" ";	
			String isAfricanAmerican= (ethnicity=="African American"||ethnicity.equals("African American"))?"*":" ";	
			String isNativeAmerican= (ethnicity=="Native American"||ethnicity.equals("Native American"))?"*":" ";	
			String isEthOther= (ethnicity=="Other"||ethnicity.equals("Other"))?"*":" ";	
			c1 = new PdfPCell(
					new Paragraph(
							"("+isCaucasian+") Caucasian ("+isHispanic+") Hispanic ("+isAsian+")Asian"
							+"\n("+isAfricanAmerican+") African American ("+isNativeAmerican+") Native American"
							+"\n("+isEthOther+") Other (Specify:______________)",
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��16�е�1-5��
			c1 = new PdfPCell(new Paragraph("Frequency of Abuse:",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��16�е�6-11��
			c1 = new PdfPCell(new Paragraph("Is victim aware of report?",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��17�е�1-5��
			String frequencyDate = report.getFrequency().split(",")[0];
			String frequencyTend = report.getFrequency().split(",")[1];
			String isDaily = (frequencyDate=="Daily"||frequencyDate.equals("Daily"))?"*":"";
			String isWeekly = (frequencyDate=="Weekly"||frequencyDate.equals("Weekly"))?"*":"";
			String isEpisodic= (frequencyDate=="Episodic"||frequencyDate.equals("Episodic"))?"*":"";
			String isIncreasing = (frequencyTend=="Increasing"||frequencyTend.equals("Increasing"))?"*":"";
			String isDecreasing = (frequencyTend=="Decreasing"||frequencyTend.equals("Decreasing"))?"*":"";
			String isConstant = (frequencyTend=="Constant"||frequencyTend.equals("Constant"))?"*":"";
			String isFreqUnknown = (frequencyTend=="Unknown"||frequencyTend.equals("Unknown"))?"*":"";
			c1 = new PdfPCell(new Paragraph(
					"("+isDaily+") Daily ("+isIncreasing+") Increasing",
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(2); // �����±ߌ�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��17�е�6-11��
			String isAwareOfYes = (report.getAwareof()=="yes"||report.getAwareof().equals("yes"))?"*":"";
			String isAwareOfNo = (report.getAwareof()=="no"||report.getAwareof().equals("no"))?"*":"";
			c1 = new PdfPCell(new Paragraph(
					"("+isAwareOfYes+") Yes ("+isAwareOfNo+") No"
					,font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��18�е�1-5��
			c1 = new PdfPCell(new Paragraph(
					"("+isWeekly+") Weekly ("+isDecreasing+") Decreasing",
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.disableBorderSide(2); // �����±ߌ�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��18�е�6-11��
			c1 = new PdfPCell(new Paragraph("Types of Abuse: ( List all which apply)",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��19�е�1-5��
			c1 = new PdfPCell(
					new Paragraph(
							"("+isEpisodic+") Episodic ("+isConstant+") Constant"
							+"\n			 ("+isFreqUnknown+") Unknown"
							+"\nDate of last incident:"+report.getTime(),
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			//��19�е�6-11��
			HashMap hashAbuseType = new HashMap();
			String[] arrayAbuseType = report.getAbusetype().split(",");
			for(int i=0;i<arrayAbuseType.length;i++){
				if(arrayAbuseType[i]=="Physical"||"Physical".equals(arrayAbuseType[i])
					||arrayAbuseType[i]=="Omission"||"Omission".equals(arrayAbuseType[i])
					||arrayAbuseType[i]=="Sexual"||"Sexual".equals(arrayAbuseType[i])
					||arrayAbuseType[i]=="Emotional"||"Emotional".equals(arrayAbuseType[i]))
					hashAbuseType.put(arrayAbuseType[i], arrayAbuseType[i]);
				else{
					hashAbuseType.put("Other", arrayAbuseType[i]);
				}
			}
			String isPhysical = hashAbuseType.containsKey("Physical")?"*":"";
			String isOmission = hashAbuseType.containsKey("Omission")?"*":"";
			String isSexual = hashAbuseType.containsKey("Sexual")?"*":"";
			String isEmotional = hashAbuseType.containsKey("Emotional")?"*":"";
			String isOther = hashAbuseType.containsKey("Other")?"*":"";
			String otherSpecify = hashAbuseType.containsKey("Other")?hashAbuseType.get("Other").toString():"";
			c1 = new PdfPCell(
					new Paragraph(
							"("+ isPhysical +") Physical ("+ isOmission +") Omission"
							+"\n("+ isSexual+") Sexual ("+ isOther +") Other (Specify:"+ otherSpecify +")"
							+"\n("+ isEmotional +" ) Emotional",
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			document.add(t1);// ����t1���ĵ�
			
			Paragraph ttext1 = new Paragraph("Please describe alleged abuse on the back side of this form.",font0); //����һ������  
			ttext1.setAlignment(Paragraph.ALIGN_CENTER);//����  
			document.add(ttext1);//����   
			Paragraph ttext2 = new Paragraph("*You must file an oral report of suspected abuse; please call 800-426-9009",font0); //����һ������  
			ttext2.setAlignment(Paragraph.ALIGN_CENTER);//����  
			document.add(ttext2);//����  
			

			/***********************************************************************************************/
			/**********************************************page two*****************************************/
			/***********************************************************************************************/
			document.newPage();
			
			Paragraph ttext3 = new Paragraph("Description - Please complete the following sections.",font4); //����һ������  
			ttext3.setAlignment(Paragraph.ALIGN_CENTER);//����  
			//ttext3.setLeading(15f,1.0f);
			document.add(ttext3);//����  
			// ���2
			PdfPTable t2 = new PdfPTable(11); // 11�еı��
			t2.setTotalWidth(500);// ���ñ����ܿ��
			t2.setLockedWidth(true); // ʹ��������������������ʹ�����º��������������
			
			PdfPCell c2;
			//��1��
			c2 = new PdfPCell(
					new Paragraph("1. In narrative form, please describe the alleged abuse:",font0));// ����
			c2.setColspan(11);// ռ6��
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c2.setBorderWidth(2f); //�߿���
			t2.addCell(c2);
			//��2��
			c2 = new PdfPCell(
					new Paragraph(
							report.getNarrativeform()
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n",
					font0));// ����
			c2.setColspan(11);// ռ6��
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c2.setBorderWidth(2f); //�߿���
			t2.addCell(c2);
			
			//��3��
			c2 = new PdfPCell(
					new Paragraph(
							"2. Please describe the level of risk to the alleged victim, including his/her current"
							+"\nphysical and emotional state:",
					font0));// ����
			c2.setColspan(11);// ռ6��
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c2.setBorderWidth(2f); //�߿���
			t2.addCell(c2);
			//��4��
			c2 = new PdfPCell(
					new Paragraph(
							report.getRisklevel()
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n",
					font0));// ����
			c2.setColspan(11);// ռ6��
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c2.setBorderWidth(2f); //�߿���
			t2.addCell(c2);
			//��5��
			c2 = new PdfPCell(
					new Paragraph("3. Please list any resulting injuries:",font0));// ����
			c2.setColspan(11);// ռ6��
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c2.setBorderWidth(2f); //�߿���
			t2.addCell(c2);
			//��6��
			c2 = new PdfPCell(
					new Paragraph(
							report.getResultinginjure()
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n",
					font0));// ����
			c2.setColspan(11);// ռ6��
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c2.setBorderWidth(2f); //�߿���
			t2.addCell(c2);
			//��7��
			c2 = new PdfPCell(new Paragraph("4. Please list witnesses, if any, including daytime phone numbers:",font0));// ����
			c2.setColspan(11);// ռ6��
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c2.setBorderWidth(2f); //�߿���
			t2.addCell(c2);
			//��8��
			c2 = new PdfPCell(
					new Paragraph(
							report.getWitness()
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n",
					font0));// ����
			c2.setColspan(11);// ռ6��
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c2.setBorderWidth(2f); //�߿���
			t2.addCell(c2);
			//��9��
			c2 = new PdfPCell(
					new Paragraph(
							"5. Please describe caregiver relationship between the alleged abuser and the alleged victim."
							+"\n(What assistance, if any, does the alleged abuser provide to the person with the disability?)",
					font0));// ����
			c2.setColspan(11);// ռ6��
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c2.setBorderWidth(2f); //�߿���
			t2.addCell(c2);
			//��10��
			c2 = new PdfPCell(
					new Paragraph(
							report.getCaregiverrelationship()
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n",
					font0));// ����
			c2.setColspan(11);// ռ6��
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c2.setBorderWidth(2f); //�߿���
			t2.addCell(c2);
			//��11��
			c2 = new PdfPCell(new Paragraph("6. Was an oral report filed with the DPPC Hotline?",font0));// ����
			c2.setColspan(11);// ռ6��
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c2.setBorderWidth(2f); //�߿���
			t2.addCell(c2);
			//��12��
			String dppcHotline = report.getDppchotline();
			String isHotlineYes = (dppcHotline!="no"&&!dppcHotline.equals("no"))?"*":"";
			String isHotlineNo = (dppcHotline=="no"||dppcHotline.equals("no"))?"*":"";
			c2 = new PdfPCell(
					new Paragraph(
							"("+isHotlineYes+") YES (Please note date and time of call:"+dppcHotline+")"
							+"\n("+isHotlineNo+") NO (If no, please call 800-426-9009 to file an oral report)",
					font0));// ����
			c2.setColspan(11);// ռ6��
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c2.setBorderWidth(2f); //�߿���
			t2.addCell(c2);
			//��13��
			c2 = new PdfPCell(new Paragraph("7. Is there any risk to the investigator?",font0));// ����
			c2.setColspan(11);// ռ6��
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c2.setBorderWidth(2f); //�߿���
			t2.addCell(c2);
			//��14��
			String investigatorRisk = report.getInvestigatorrisk();
			String isinvestigatorRiskYes = (investigatorRisk!="no"&&!investigatorRisk.equals("no"))?"*":"";
			String isinvestigatorRiskNo = (investigatorRisk=="no"||investigatorRisk.equals("no"))?"*":"";
			c2 = new PdfPCell(
					new Paragraph(
							"("+isinvestigatorRiskYes+") YES If yes, please specify:"+investigatorRisk
							+"\n("+isinvestigatorRiskNo+") NO",
					font0));// ����
			c2.setColspan(11);// ռ6��
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c2.setBorderWidth(2f); //�߿���
			t2.addCell(c2);
			
			document.add(t2);// ����t2���ĵ�
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		}
		finally{
			this.document.close();
		}	
	}

}
