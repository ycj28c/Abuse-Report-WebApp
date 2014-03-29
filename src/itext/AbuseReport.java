package itext;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
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

public class AbuseReport implements LetterInterface{
	private Document document = null;
	private String path = null;
	private String PDFpath = null;
	private String PDFname = null;
	private static int num = 0;
	public String description = null;
	public String name = null;
	
	public void setPath(String path) {
		Rectangle pageSize = new Rectangle(144, 720); // set the pagesize A4
		this.document = new Document();	
	}

	public String getPDFPath() {
		this.path = path;
		this.PDFname = "dispositionletter"+this.num+".pdf";
		this.PDFpath = this.path+"/pdf/"+this.PDFname;
		//this.num++;
		try {
			PdfWriter.getInstance(this.document, new FileOutputStream(this.PDFpath));
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPDFname() {
		// TODO Auto-generated method stub
		return null;
	}

	public void makeLetter() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
