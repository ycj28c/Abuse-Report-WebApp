/*
 * 需要修改当public log number 已存在的处理
 * 需要修改当插入执行错误，删除已经上传的无用文件
 * 需要修改后面插入执行错误，删除前面已经插入的数据
 * 需要修改reportid 和 investigation的关系
 */
package mvc.servlet;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import mvc.factory.*;
import mvc.vo.Decision;
import mvc.vo.Disposition;
import mvc.vo.Investigation;
import mvc.vo.Report;
import mvc.vo.Respond;
import structure.LetterFile;

public class UpdateInvestigationServlet extends HttpServlet {  
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get variable
		HttpSession session = req.getSession();
		String userid = session.getAttribute("userid").toString();
		String path = "newinvestigation.jsp";	
		HashMap<String, String> formelements = new HashMap<String, String>();
		boolean flag = false;
		List<LetterFile> arrayFile = new ArrayList<LetterFile>(2);
		int arraycount = 0;
		LetterFile dispositionLetter = new LetterFile();
		dispositionLetter.setdirectionName("disposition");
		LetterFile decisionLetter = new LetterFile();
		decisionLetter.setdirectionName("decision");
		arrayFile.add(dispositionLetter);
		arrayFile.add(decisionLetter);
		
		//attachment processing
		DiskFileItemFactory factory = new DiskFileItemFactory();  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        try {  
        	//upload.setFileSizeMax(5000000);//指定单个上传文件的最大尺寸  
        	//upload.setSizeMax(10000000);//指定一次上传多个文件的总尺寸
            List<FileItem> fileitems = upload.parseRequest(req);  
            for (FileItem item : fileitems) {  
                if (item.isFormField()) {  //不是file
                    String name = item.getFieldName();  
                    String value = item.getString();  
                    // 转换下字符集编码,it's only way to get date at "multipart/form-data" mode
                    value = new String(value.getBytes("iso-8859-1"), "utf-8");  
                    //System.out.println(name + "=" + value); 
                    formelements.put(name, value);
                } else {  //是file
                    String filename = item.getName(); 
                    if(filename!=null&&!"".equals(filename)){
	                    //upload path is...\\WebRoot\\upload\\decision or disposition\file  
	                    String ctxDir = session.getServletContext().getRealPath(String.valueOf(File.separatorChar));
	                    String uploadDir = "upload" + File.separatorChar + File.separatorChar;
	                    String CreateDir = arrayFile.get(arraycount).getdirectionName();  //分别存在disposition 和decision文件夹里
	                    File savePath = new File(ctxDir + uploadDir + CreateDir);
	            		if (!savePath.exists()) { //is doesn't exist the Directory, make it
	            			savePath.mkdirs();
	            		} 
	            		//generate the random filename and extension type
	            		String rename = java.util.UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(filename);
	            		File file = new File(savePath, rename);  
	                    file.createNewFile();  
	                      
	                    // 获得流，读取数据写入文件  
	                    InputStream in = item.getInputStream();  
	                    FileOutputStream fos = new FileOutputStream(file);  
	                      
	                    int len;  
	                    byte[] buffer = new byte[1024];  
	                    while ((len = in.read(buffer)) > 0)  
	                        fos.write(buffer, 0, len);  
	                      
	                    // 关闭资源文件操作  
	                    fos.close();  
	                    in.close();  
	                    // 删除临时文件  
	                    item.delete();  
	                    
	                    //arrayFile counter
	                    arrayFile.get(arraycount).setoldName(filename);
	            		arrayFile.get(arraycount).setnewName(rename);
	                    arrayFile.get(arraycount).setpath(uploadDir + CreateDir + File.separatorChar + rename);	                    
                    }
                    else{
                    	arrayFile.get(arraycount).setoldName("");
	            		arrayFile.get(arraycount).setnewName("");
	                    arrayFile.get(arraycount).setpath("");	
                    }  
                    arraycount ++;
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        
        //set variable
        String reportid = formelements.get("reportid").toString();
		String disdescription = formelements.get("disdescription").toString();
		String desdescription = formelements.get("desdescription").toString();
		String resdescription = formelements.get("resdescription").toString();
		String publiclognumber = formelements.get("publiclognumber").toString();
		int pkDisposition = Integer.parseInt(formelements.get("dispositionid").toString());
		int pkRespond = Integer.parseInt(formelements.get("respondid").toString());
		int pkDecision = Integer.parseInt(formelements.get("decisionid").toString());
		//System.out.println("reportid:"+reportid);
		//System.out.println("disdescription:"+disdescription);
		//System.out.println("desdescription:"+desdescription);
		//System.out.println("resdescription:"+resdescription);
		//System.out.println("publiclognumber:"+publiclognumber);
		      
		//report
        Report report = new Report();
        report.setReportid(Integer.parseInt(reportid));
        //获得report的status
        
		//disposition letter
        Disposition disposition = new Disposition();
        disposition.setPkDisposition(pkDisposition);
        disposition.setAttachnewname(arrayFile.get(0).getnewName());
        disposition.setAttacholdname(arrayFile.get(0).getoldName());
        disposition.setAttachpath(arrayFile.get(0).getpath());
        disposition.setDescription(disdescription);
        disposition.setInvestigationid(publiclognumber);
        disposition.setReportid(reportid);
        if(arrayFile.get(0).getoldName()==""&&"".equals(arrayFile.get(0).getoldName())){
        	//update part of data except attachment
        	try {
            	flag = DAOFactory.getIDispositionDAOInstance().updateDispositionWithoutAttach(disposition);
    		} catch (Exception e) {
    			e.printStackTrace();
    		} 
        }
        else{
        	try {
            	flag = DAOFactory.getIDispositionDAOInstance().updateDisposition(disposition);
    		} catch (Exception e) {
    			e.printStackTrace();
    		} 
        }
        
		//decision letter
        Decision decision = new Decision();
        decision.setPkDecision(pkDecision);
        decision.setAttachnewname(arrayFile.get(1).getnewName());
        decision.setAttacholdname(arrayFile.get(1).getoldName());
        decision.setAttachpath(arrayFile.get(1).getpath());
        decision.setDescription(desdescription);
        decision.setInvestigationid(publiclognumber);
        decision.setReportid(reportid);
        if(arrayFile.get(1).getoldName()==""&&"".equals(arrayFile.get(1).getoldName())){
        	//update part of data except attachment
        	try {
            	flag = DAOFactory.getIDecisionDAOInstance().updateDecisionWithoutAttach(decision);
    		} catch (Exception e) {
    			e.printStackTrace();
    		} 
        }
        else{
        	try {
            	flag = DAOFactory.getIDecisionDAOInstance().updateDecision(decision);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        }
		//agency respond
        Respond respond = new Respond();
        respond.setPkRespond(pkRespond);
        respond.setContent(resdescription);
        respond.setInvestigationid(publiclognumber);
        respond.setReportid(reportid);
        try {
        	flag = DAOFactory.getIRespondDAOInstance().updateRespond(respond);
        } catch (Exception e) {
        	e.printStackTrace();
    	}  
        //investigation report
        String status = "haha"; //waiting to fix
        Investigation investigation = new Investigation();
        investigation.setPubliclognumber(publiclognumber);
        investigation.setReportid(reportid);
        investigation.setStatus(status);
        try {
			flag = DAOFactory.getIInvestigationDAOInstance().updateInvestigationID(investigation);
		} catch (Exception e) {
			e.printStackTrace();
		}
        //jump to page			
        req.getRequestDispatcher(path).forward(req, resp);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
}
