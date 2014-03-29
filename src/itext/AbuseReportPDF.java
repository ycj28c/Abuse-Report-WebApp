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
			Font font0 = new Font(baseFT, 10, Font.BOLD); // 12号字体,宋体
			//BaseFont baseFT = BaseFont.createFont(path+"/font/STSong.TTF",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			//Font font0 = new Font(baseFT, 12); // 12号字体,宋体
			baseFT = BaseFont.createFont(path+"/font/Arial.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			Font font1 = new Font(baseFT, 10, Font.BOLD); // bold加粗,10号,Arial字体
			baseFT = BaseFont.createFont(path+"/font/Arial.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			Font font2 = new Font(baseFT, 12, Font.BOLD); // bold加粗,12号,Arial字体
			baseFT = BaseFont.createFont(path+"/font/Arial.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			Font font3 = new Font(baseFT, 10); // 11号,Arial字体
			baseFT = BaseFont.createFont(path+"/font/Arial.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			Font font4 = new Font(baseFT, 16, Font.BOLD); // bold加粗,24号,Arial字体


			/***********************************************************************************************/
			/**********************************************page one*****************************************/
			/***********************************************************************************************/
			// 表格1
			PdfPTable t1 = new PdfPTable(11); // 11列的表格
			t1.setTotalWidth(500);// 设置表格的总宽度
			t1.setLockedWidth(true); // 使用以上两个函数，必须使用以下函数，将宽度锁定
			//获取table的默认单元格
			//t1.getDefaultCell().setMinimumHeight(30f); 
			//t1.getDefaultCell().setLeading(20f, 1.0f);
			//t1.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER); //getDefualtCell都不好用
			//可以使用方法setSpacingBefore和setSpacingAfter。来设置表格之间的间距  
			//t1.setSpacingAfter(20f);
			//t1.setSpacingBefore(20f);
			// 第1行第1列
			// 图片
			Image png = Image.getInstance(path+"/image/dppc.png");
			png.scalePercent(33);
			PdfPCell c1 = new PdfPCell(png);
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setColspan(11);// 表示一行占11列
			c1.disableBorderSide(1); // 隐藏上边框
			//c1.disableBorderSide(2); // 隐藏下边寛
			c1.disableBorderSide(4); // 隐藏左边寛
			c1.disableBorderSide(8); // 隐藏右边寛
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			// 第2行第1-5列
			c1 = new PdfPCell(new Paragraph("Reporter:", font0));
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setColspan(5);// 表示一行占5列
			c1.setBorderWidth(2f);
			t1.addCell(c1);// 加入到table
			// 第2行第6-11列
			c1 = new PdfPCell(new Paragraph("Alleged Victim:", font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setColspan(6);// 占1列
			c1.setBorderWidth(2f);
			t1.addCell(c1);
			// 第3行第1-5列
			c1 = new PdfPCell(
					new Paragraph( 30f,
							"Name:" + report.getUsername()
								+ "\nAddress" 
								+ "\n" 
								+ "\nDaytime telephone:()"
								+ "\n()Mandated" 
								+ "\n()Non-Mandated",
							font0));
			//c1.setPadding(20); //设置首行缩进
			//c1.setMinimumHeight(200f); //设置单元格的高度
			//c1.setFixedHeight(30f);
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			//c1.setRowspan(20); //设置占用多少行数
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setColspan(5);// 表示一行占5列
			c1.disableBorderSide(2); // 隐藏下边寛
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);// 加入到table
			// 第3行第6-11列
			c1 = new PdfPCell(
					new Paragraph(
							"Name:" +report.getVictimname()
							+"\nAddress"
							+"\n"
							+"\nTelephone:()"
							+"\nSex:()Male ()Female     DOB:"
							+"\nAge:		Marital Status:",
					font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占1列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			// 第4行第1-5列
			c1 = new PdfPCell(
					new Paragraph(
							"Relationship to Alleged Victim:",
					font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占5列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(1); // 隐藏上边框
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			// 第4行第6-11列
			c1 = new PdfPCell(new Paragraph("Disability: (check as apply)",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占1列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			// 第5行第1-5列
			c1 = new PdfPCell(new Paragraph("Alleged Abuser: (Alleged Victim's Caretaker)", font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占5列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			// 第5行第6-11列
			c1 = new PdfPCell(new Paragraph("( ) Mental Retardation ( ) Mental Illness",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(2); // 隐藏下边寛
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			// 第6行第1-5列
			c1 = new PdfPCell(
					new Paragraph(
							"Name(s):" + report.getAbusername()
							+"\nHome address:"
							+"\n"
							+"\nRelationship to victim:",
					font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占5列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(2); // 隐藏下边寛
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第6行第6-11列
			c1 = new PdfPCell(
					new Paragraph(
							"( ) Mobility ( ) Head Injury"
							+"\n( ) Visual ( ) Deaf / Hard of Hearing"
							+"\n( ) Cerebral Palsy ( ) Multiple Sclerosis"
							+"\n( ) Seizures ( ) Other (Specify: _____________)",
					font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(1); // 隐藏上边框
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			// 第7行第1-5列
			c1 = new PdfPCell(new Paragraph( "\nSoc. Security #:		DOB:",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占5列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(1); // 隐藏上边寛
			c1.disableBorderSide(2); // 隐藏下边寛
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			// 第7行第6-11列
			c1 = new PdfPCell(new Paragraph("Communication Needs:",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			// 第8行第1-5列
			c1 = new PdfPCell(new Paragraph("Telephone: ( )",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占5列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(1); // 隐藏上边框
			c1.disableBorderSide(2); // 隐藏下边寛
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			// 第8行第6-11列
			c1 = new PdfPCell(
					new Paragraph("( ) TTY ( ) Sign Interpreter ( ) Other (Specify: _____________)",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第9行第1-5列
			c1 = new PdfPCell(
					new Paragraph("Client's Guardian(s): (If any)",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第9行第6-11列
			c1 = new PdfPCell(
					new Paragraph("Currently Served By:",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第10行第1-5列
			c1 = new PdfPCell(
					new Paragraph(
							"Name(s):"
							+"\nAddress:"
							+"\n"
							+"\nRelationship to Alleged Victim:"
							+"\nTelephone: ( )",
					font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第10行第6-11列
			c1 = new PdfPCell(
					new Paragraph(
							"( ) Dept. of Mental Health ( ) Mass Comm./Blind"
							+"\n( ) Dept. of Developmental Svcs. ( ) Mass. Comm./Deaf/HH"
							+"\n( ) Mass. Rehab. Comm. ( ) Unknown"
							+"\n( ) Dept. of Correction ( ) Other (Specify:_____________)"
							+"\n( ) Dept. of Public Health ( ) None",
					font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第11行第1-5列
			c1 = new PdfPCell(
					new Paragraph("Collateral contacts or notifications:",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占5列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(2); // 隐藏下边寛
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第11行第6-11列
			c1 = new PdfPCell(new Paragraph("Type of Service:",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第12行第1-5列
			c1 = new PdfPCell(
					new Paragraph("(Please list, including telephone numbers.)",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占5列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(1); // 隐藏上边框
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第12行第6-11列
			c1 = new PdfPCell(new Paragraph("( ) Institutional ( ) Service Coordination",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(2); // 隐藏下边寛
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第13行第1-5列
			c1 = new PdfPCell(
					new Paragraph(
							"\n"
							+"\n"
							+"\n",
					font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占5列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(2); // 隐藏下边寛
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第13行第6-11列
			c1 = new PdfPCell(
					new Paragraph(
							"( ) Residential ( ) Foster / Spec. Home Care"
							+"\n( ) Day Program ( ) Respite"
							+"\n( ) Case Management ( ) Other (Specify:_____________)",
					font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(1); // 隐藏上边框
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第14行第1-5列
			c1 = new PdfPCell(new Paragraph("\n",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占5列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(1); // 隐藏上边框
			c1.disableBorderSide(2); // 隐藏下边寛
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第14行第6-11列
			c1 = new PdfPCell(new Paragraph("Client's Ethnicity:",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第15行第1-5列
			c1 = new PdfPCell(
					new Paragraph(
							"\n"
							+"\n"
							+"\n",
					font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占5列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(1); // 隐藏上边框
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第15行第6-11列
			c1 = new PdfPCell(
					new Paragraph(
							"( ) Caucasian ( ) Hispanic ( )Asian"
							+"\n( ) African American ( ) Native American"
							+"\n( ) Other (Specify:______________)",
					font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第16行第1-5列
			c1 = new PdfPCell(new Paragraph("Frequency of Abuse:",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占5列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第16行第6-11列
			c1 = new PdfPCell(new Paragraph("Is victim aware of report?",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第17行第1-5列
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
					font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占5列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(2); // 隐藏下边寛
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第17行第6-11列
			String isAwareOfYes = (report.getAwareof()=="yes"||report.getAwareof().equals("yes"))?"*":"";
			String isAwareOfNo = (report.getAwareof()=="no"||report.getAwareof().equals("no"))?"*":"";
			c1 = new PdfPCell(new Paragraph(
					"("+isAwareOfYes+") Yes ("+isAwareOfNo+") No"
					,font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第18行第1-5列
			c1 = new PdfPCell(new Paragraph(
					"("+isWeekly+") Weekly ("+isDecreasing+") Decreasing",
					font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占5列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(1); // 隐藏上边框
			c1.disableBorderSide(2); // 隐藏下边寛
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第18行第6-11列
			c1 = new PdfPCell(new Paragraph("Types of Abuse: ( List all which apply)",font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第19行第1-5列
			c1 = new PdfPCell(
					new Paragraph(
							"("+isEpisodic+") Episodic ("+isConstant+") Constant"
							+"\n			 ("+isUnknown+") Unknown"
							+"\nDate of last incident:"+report.getTime(),
					font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(5);// 占5列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.disableBorderSide(1); // 隐藏上边框
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			//第19行第6-11列
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
					font0));// 字体
			c1.setLeading(4f, 1.0f); //设置表格内行间距
			c1.setColspan(6);// 占6列
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直对齐方式
			c1.setBorderWidth(2f); //边框宽度
			t1.addCell(c1);
			document.add(t1);// 加入t1到文档
			
			Paragraph ttext1 = new Paragraph("Please describe alleged abuse on the back side of this form.",font0); //创建一个段落  
			ttext1.setAlignment(Paragraph.ALIGN_CENTER);//居中  
			document.add(ttext1);//加入   
			Paragraph ttext2 = new Paragraph("*You must file an oral report of suspected abuse; please call 800-426-9009",font0); //创建一个段落  
			ttext2.setAlignment(Paragraph.ALIGN_CENTER);//居中  
			document.add(ttext2);//加入  
			

			/***********************************************************************************************/
			/**********************************************page two*****************************************/
			/***********************************************************************************************/
			document.newPage();
			
			Paragraph ttext3 = new Paragraph("Description - Please complete the following sections.",font4); //创建一个段落  
			ttext3.setAlignment(Paragraph.ALIGN_CENTER);//居中  
			//ttext3.setLeading(15f,1.0f);
			document.add(ttext3);//加入  
			// 表格2
			PdfPTable t2 = new PdfPTable(11); // 11列的表格
			t2.setTotalWidth(500);// 设置表格的总宽度
			t2.setLockedWidth(true); // 使用以上两个函数，必须使用以下函数，将宽度锁定
			
			PdfPCell c2;
			//第1行
			c2 = new PdfPCell(
					new Paragraph("1. In narrative form, please describe the alleged abuse:",font0));// 字体
			c2.setColspan(11);// 占6列
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c2.setBorderWidth(2f); //边框宽度
			t2.addCell(c2);
			//第2行
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
					font0));// 字体
			c2.setColspan(11);// 占6列
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c2.setBorderWidth(2f); //边框宽度
			t2.addCell(c2);
			
			//第3行
			c2 = new PdfPCell(
					new Paragraph(
							"2. Please describe the level of risk to the alleged victim, including his/her current"
							+"\nphysical and emotional state:",
					font0));// 字体
			c2.setColspan(11);// 占6列
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c2.setBorderWidth(2f); //边框宽度
			t2.addCell(c2);
			//第4行
			c2 = new PdfPCell(
					new Paragraph(
							report.getRisklevel()
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n",
					font0));// 字体
			c2.setColspan(11);// 占6列
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c2.setBorderWidth(2f); //边框宽度
			t2.addCell(c2);
			//第5行
			c2 = new PdfPCell(
					new Paragraph("3. Please list any resulting injuries:",font0));// 字体
			c2.setColspan(11);// 占6列
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c2.setBorderWidth(2f); //边框宽度
			t2.addCell(c2);
			//第6行
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
					font0));// 字体
			c2.setColspan(11);// 占6列
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c2.setBorderWidth(2f); //边框宽度
			t2.addCell(c2);
			//第7行
			c2 = new PdfPCell(new Paragraph("4. Please list witnesses, if any, including daytime phone numbers:",font0));// 字体
			c2.setColspan(11);// 占6列
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c2.setBorderWidth(2f); //边框宽度
			t2.addCell(c2);
			//第8行
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
					font0));// 字体
			c2.setColspan(11);// 占6列
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c2.setBorderWidth(2f); //边框宽度
			t2.addCell(c2);
			//第9行
			c2 = new PdfPCell(
					new Paragraph(
							"5. Please describe caregiver relationship between the alleged abuser and the alleged victim."
							+"\n(What assistance, if any, does the alleged abuser provide to the person with the disability?)",
					font0));// 字体
			c2.setColspan(11);// 占6列
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c2.setBorderWidth(2f); //边框宽度
			t2.addCell(c2);
			//第10行
			c2 = new PdfPCell(
					new Paragraph(
							report.getCaregiverrelationship()
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n"
							+"\n",
					font0));// 字体
			c2.setColspan(11);// 占6列
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c2.setBorderWidth(2f); //边框宽度
			t2.addCell(c2);
			//第11行
			c2 = new PdfPCell(new Paragraph("6. Was an oral report filed with the DPPC Hotline?",font0));// 字体
			c2.setColspan(11);// 占6列
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c2.setBorderWidth(2f); //边框宽度
			t2.addCell(c2);
			//第12行
			String dppcHotline = report.getDppchotline();
			String isHotlineYes = (dppcHotline!="no"&&!dppcHotline.equals("no"))?"*":"";
			String isHotlineNo = (dppcHotline=="no"||dppcHotline.equals("no"))?"*":"";
			c2 = new PdfPCell(
					new Paragraph(
							"("+isHotlineYes+") YES (Please note date and time of call:"+dppcHotline+")"
							+"\n("+isHotlineNo+") NO (If no, please call 800-426-9009 to file an oral report)",
					font0));// 字体
			c2.setColspan(11);// 占6列
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c2.setBorderWidth(2f); //边框宽度
			t2.addCell(c2);
			//第13行
			c2 = new PdfPCell(new Paragraph("7. Is there any risk to the investigator?",font0));// 字体
			c2.setColspan(11);// 占6列
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c2.setBorderWidth(2f); //边框宽度
			t2.addCell(c2);
			//第14行
			String investigatorRisk = report.getInvestigatorrisk();
			String isinvestigatorRiskYes = (investigatorRisk!="no"&&!investigatorRisk.equals("no"))?"*":"";
			String isinvestigatorRiskNo = (investigatorRisk=="no"||investigatorRisk.equals("no"))?"*":"";
			c2 = new PdfPCell(
					new Paragraph(
							"("+isinvestigatorRiskYes+") YES If yes, please specify:"+investigatorRisk
							+"\n("+isinvestigatorRiskNo+") NO",
					font0));// 字体
			c2.setColspan(11);// 占6列
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);// 设置对齐方式
			c2.setBorderWidth(2f); //边框宽度
			t2.addCell(c2);
			
			document.add(t2);// 加入t2到文档
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		}
		finally{
			this.document.close();
		}	
	}

}
