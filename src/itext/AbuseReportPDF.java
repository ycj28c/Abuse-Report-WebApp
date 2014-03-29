package itext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import mvc.vo.Report;

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
			c1 = new PdfPCell(
					new Paragraph( 30f,
							"Name:" + report.getUsername()
								+ "\nAddress" 
								+ "\n" 
								+ "\nDaytime telephone:()"
								+ "\n()Mandated" 
								+ "\n()Non-Mandated",
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
			c1 = new PdfPCell(
					new Paragraph(
							"Name:" +report.getVictimname()
							+"\nAddress"
							+"\n"
							+"\nTelephone:()"
							+"\nSex:()Male ()Female     DOB:"
							+"\nAge:		Marital Status:",
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
			c1 = new PdfPCell(new Paragraph("( ) Mental Retardation ( ) Mental Illness",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(2); // �����±ߌ�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			// ��6�е�1-5��
			c1 = new PdfPCell(
					new Paragraph(
							"Name(s):" + report.getAbusername()
							+"\nHome address:"
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
							"( ) Mobility ( ) Head Injury"
							+"\n( ) Visual ( ) Deaf / Hard of Hearing"
							+"\n( ) Cerebral Palsy ( ) Multiple Sclerosis"
							+"\n( ) Seizures ( ) Other (Specify: _____________)",
					font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(6);// ռ6��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			// ��7�е�1-5��
			c1 = new PdfPCell(new Paragraph( "\nSoc. Security #:		DOB:",font0));// ����
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
			c1 = new PdfPCell(new Paragraph("Telephone: ( )",font0));// ����
			c1.setLeading(4f, 1.0f); //���ñ�����м��
			c1.setColspan(5);// ռ5��
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// ���ö��뷽ʽ
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//���ô�ֱ���뷽ʽ
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.disableBorderSide(2); // �����±ߌ�
			c1.setBorderWidth(2f); //�߿���
			t1.addCell(c1);
			// ��8�е�6-11��
			c1 = new PdfPCell(
					new Paragraph("( ) TTY ( ) Sign Interpreter ( ) Other (Specify: _____________)",font0));// ����
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
			c1 = new PdfPCell(
					new Paragraph(
							"( ) Dept. of Mental Health ( ) Mass Comm./Blind"
							+"\n( ) Dept. of Developmental Svcs. ( ) Mass. Comm./Deaf/HH"
							+"\n( ) Mass. Rehab. Comm. ( ) Unknown"
							+"\n( ) Dept. of Correction ( ) Other (Specify:_____________)"
							+"\n( ) Dept. of Public Health ( ) None",
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
			c1 = new PdfPCell(new Paragraph("( ) Institutional ( ) Service Coordination",font0));// ����
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
							"\n"
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
							"( ) Residential ( ) Foster / Spec. Home Care"
							+"\n( ) Day Program ( ) Respite"
							+"\n( ) Case Management ( ) Other (Specify:_____________)",
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
			c1 = new PdfPCell(
					new Paragraph(
							"( ) Caucasian ( ) Hispanic ( )Asian"
							+"\n( ) African American ( ) Native American"
							+"\n( ) Other (Specify:______________)",
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
			String isUnknown = (frequencyTend=="Unknown"||frequencyTend.equals("Unknown"))?"*":"";
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
							+"\n			 ("+isUnknown+") Unknown"
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
