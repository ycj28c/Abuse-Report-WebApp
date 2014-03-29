package itext;

import java.io.FileOutputStream;
import java.io.IOException;

//import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.*;

public class DispositionLetter implements LetterInterface{
	private Document document = null;
	private String path = null;
	private String PDFpath = null;
	private String PDFname = null;
	private static int num = 0;
	
	public String description = null;
	public String name = null;
	//private date time = null;

	public DispositionLetter() {
		Rectangle pageSize = new Rectangle(144, 720); // set the pagesize
		this.document = new Document();
	}

	public void setPath(String path){
		this.path = path;
		this.PDFname = "dispositionletter"+this.num+".pdf";
		this.PDFpath = this.path+"/pdf/"+this.PDFname;
		this.num++;
		try {
			PdfWriter.getInstance(this.document, new FileOutputStream(this.PDFpath));
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
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
			// �ĵ�˵��
			document.addAuthor("Yan");
			document.addCreationDate();
			document.addCreator("Yan");
			document.addSubject("iText test");
			document.addTitle("Disposition Letter");
			document.addKeywords("disposition, health, yan, 509");

			// ���ĵ�
			document.open();

			// ����
			BaseFont baseFT = BaseFont.createFont(path+"/font/STSong.TTF",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			Font font0 = new Font(baseFT, 12); // 12������,����
			baseFT = BaseFont.createFont(path+"/font/Arial.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			Font font1 = new Font(baseFT, 10, Font.BOLD); // bold�Ӵ�,10��,Arial����
			baseFT = BaseFont.createFont(path+"/font/Arial.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			Font font2 = new Font(baseFT, 12, Font.BOLD); // bold�Ӵ�,12��,Arial����
			baseFT = BaseFont.createFont(path+"/font/Arial.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			Font font3 = new Font(baseFT, 10); // 11��,Arial����
			baseFT = BaseFont.createFont(path+"/font/Arial.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			Font font4 = new Font(baseFT, 20, Font.BOLD); // bold�Ӵ�,24��,Arial����

			// ���1
			PdfPTable t1 = new PdfPTable(5); // 4�еı��
			t1.setTotalWidth(500);// ���ñ����ܿ��
			t1.setLockedWidth(true); // ʹ��������������������ʹ�����º��������������
			// ��һ�е�һ��
			// ͼƬ
			Image png = Image.getInstance(path+"/image/image001.png");
			png.scalePercent(40);
			PdfPCell c1 = new PdfPCell(png);
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.disableBorderSide(2); // �����±ߌ�
			c1.disableBorderSide(4); // ������ߌ�
			c1.disableBorderSide(8); // �����ұߌ�
			t1.addCell(c1);
			// ��һ�еڶ���
			c1 = new PdfPCell(
					new Paragraph(
							"The Commonwealth of Massachusetts\n\n"
									+ "Executive Office of Health & Human Services\n\n"
									+ "Department Of Developmental Services\n\n"
									+ "Division of Investigations - Central/West Region",
							font2));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);// ���ö��뷽ʽ
			c1.setColspan(4);// ��ʾһ��ռ3��
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.disableBorderSide(2); // �����±ߌ�
			c1.disableBorderSide(4); // ������ߌ�
			c1.disableBorderSide(8); // �����ұߌ�
			t1.addCell(c1);// ���뵽table
			// �ڶ��е�һ��
			c1 = new PdfPCell(new Paragraph("Deval L. Patrick\n" + "Governor\n"
					+ "\n" + "Timothy P. Murray\n" + "Lieutenant Governor\n"
					+ "\n" + "John W. Polanowicz\n" + "Secretary", font3));// ����
			c1.setColspan(1);// ռ1��
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);// ���ö��뷽ʽ
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.disableBorderSide(2); // �����±ߌ�
			c1.disableBorderSide(4); // ������ߌ�
			c1.disableBorderSide(8); // �����ұߌ�
			t1.addCell(c1);
			// �ڶ��еڶ���
			c1 = new PdfPCell(new Paragraph("214 Lake Street\n"
					+ "Shrewsbury, MA01545\n" + "\n" + "\n" + "\n" + "\n"
					+ "DISPOSITION\n" + "", font1));// ����
			c1.setColspan(3);// ռ2��
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);// ���ö��뷽ʽ
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.disableBorderSide(2); // �����±ߌ�
			c1.disableBorderSide(4); // ������ߌ�
			c1.disableBorderSide(8); // �����ұߌ�
			t1.addCell(c1);
			// �ڶ��е�����
			c1 = new PdfPCell(new Paragraph("Elin M. Howe\n" + "Commissioner\n"
					+ "\n" + "Bernard J. Murphy\n"
					+ "Director of Investigations\n" + "\n" + "Janet Auger\n"
					+ "Senior Investigator\n" + "Tel (508) 845-9111\n"
					+ "Fax(508) 791-7432", font3));// ����
			c1.setColspan(1);// ռ1��
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);// ���ö��뷽ʽ
			c1.disableBorderSide(1); // �����ϱ߿�
			c1.disableBorderSide(2); // �����±ߌ�
			c1.disableBorderSide(4); // ������ߌ�
			c1.disableBorderSide(8); // �����ұߌ�
			t1.addCell(c1);
			document.add(t1);// ����t1���ĵ�

			// document.add(new Paragraph("\n",font0));
			document.add(new Paragraph("TO:     Parties to the Complaint",font0));
			document.add(new Paragraph("FROM: "+ this.name, font0));
			document.add(new Paragraph("DATE:", font0));
			document.add(new Paragraph("RE:     Complaint Log Number:", font0));
			document.add(new Paragraph("\n", font0));
			document.add(new Paragraph("Pursuant to 115 CMR9.07(3)-(8), I have made the following decision on the above complaint received by DDS",font0));
			document.add(new Paragraph("on DATE concerning the following alleged victim(s):",font0));

			document.add(new Paragraph("0 a.  Dismiss the complaint as filed because it did not meet the criteria of a reportable condition.",font0));
			document.add(new Paragraph("0 b1. Resolve the matter without an investigation as the matter involves no dispute of facts.",font0));
			document.add(new Paragraph("0 b2. Resolve the matter without an investigation as the matter may be resolved fairly and efficiently within",font0));
			document.add(new Paragraph("      five business days.", font0));
			document.add(new Paragraph("0 c.  Refer to the Regional and/or Area director. See below for further explanation.",font0));
			document.add(new Paragraph("0 d.  Assign the complaintto an investigator. The investigator is:",font0));
			document.add(new Paragraph("           The due date as applicable are:", font0));
			document.add(new Paragraph("           DPPCInitial Response                                       DPPC REPORT:         ",font0));
			document.add(new Paragraph("           115 CMR9.00 DDS Investigation Report and Decision Letter Due:",font1));
			// ֱ��1
			Paragraph p1 = new Paragraph("0 e.  Defer investigation of the complaint pending completion of an investigation by",font0);
			p1.add(new Chunk(new LineSeparator()));
			document.add(p1);
			document.add(new Paragraph("         who is/are conducting an investigation into the matter.",font0));
			// ֱ��2
			Paragraph p2 = new Paragraph("0 f.  I am changing the disposition of", font0);
			p2.add(new Chunk(new LineSeparator()));
			p2.add("from");
			p2.add(new Chunk(new LineSeparator()));
			p2.add("to");
			p2.add(new Chunk(new LineSeparator()));
			document.add(p2);
			document.add(new Paragraph("         This is based on the aSSigned investigator's racommandatton. See below for further explanation.",font0));

			document.add(new Paragraph("Explanation:", font1));
			document.add(new Paragraph(this.description + "\n\n\n\n\n\n", font0));

			document.add(new Paragraph("Any of the parties aggrieved by Disposition A may file an appeal "
							+ "within 10 days of receipt of this disposition,using the attached Appeal Form, "
							+ "Inv. Form No.9. Receipt of this disposition will be presumed to have occurredwithin "
							+ "7 days of mailing.", font3));

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		}
		finally{
			this.document.close();
		}	
	}
}