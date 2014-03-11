package mvc.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.dao.IAttachDAO;
import mvc.factory.DAOFactory;
import mvc.vo.Attach;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * @author huangshuang
 * @version 2011-5-1
 */
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = -3096800116651263134L;

	private String fileSizeLimit;
	private File oldFile;

	public void init(ServletConfig config) throws ServletException {
		this.fileSizeLimit = config.getInitParameter("fileSizeLimit");
	}

	public void destroy() {
		this.fileSizeLimit = null;
		super.destroy();
	}

	class MyFileRenamePolicy implements FileRenamePolicy {
		public File rename(File file) {
			oldFile = file;
			String fileSaveName = StringUtils.join(new String[] { java.util.UUID.randomUUID().toString(), ".",
					FilenameUtils.getExtension(file.getName()) });
			File result = new File(file.getParentFile(), fileSaveName);
			return result;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--- BEGIN DOPOST ---");
		HttpSession session = request.getSession();
		//int reportid = Integer.parseInt(request.getParameter("reportid"));
		//System.out.println("reportid:"+request.getParameter("reportid"));
		String userid = session.getAttribute("userid").toString();
		System.out.println("userid:"+userid);
		boolean flag = false;
		//�ļ�����λ�ã���ǰ��Ŀ�µ�upload/mail
		String uploadDir = "upload" + File.separatorChar + File.separatorChar;
		//ÿ���ϴ����ļ��������ڴ���ڲ�ͬ���ļ���
		String autoCreatedDateDirByParttern = "yyyy" + File.separatorChar + "MM" + File.separatorChar + "dd"
				+ File.separatorChar;
		String autoCreatedDateDir = DateFormatUtils.format(new java.util.Date(), autoCreatedDateDirByParttern);
		String ctxDir = session.getServletContext().getRealPath(String.valueOf(File.separatorChar));
		if (!ctxDir.endsWith(String.valueOf(File.separatorChar))) {
			ctxDir = ctxDir + File.separatorChar;
		}
		File savePath = new File(ctxDir + uploadDir + autoCreatedDateDir);
		if (!savePath.exists()) {
			savePath.mkdirs();
		}
		System.out.println(savePath.getName()+"======");
		String saveDirectory = ctxDir + uploadDir + autoCreatedDateDir;
		
		if (StringUtils.isBlank(this.fileSizeLimit.toString())) {
			this.fileSizeLimit = "80";// Ĭ��100M
		}
		int maxPostSize = Integer.parseInt(this.fileSizeLimit) * 1024 * 1024;
		String encoding = "UTF-8";
		FileRenamePolicy rename = new MyFileRenamePolicy();
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, rename);
			System.out.println(oldFile.getName()+"==================");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// ���
		Enumeration files = multi.getFileNames();
		while (files.hasMoreElements()) {
			String name = (String) files.nextElement();
			File f = multi.getFile(name);
			System.out.println(f.getName());
			if (f != null) {
				String fileName = multi.getFilesystemName(name);
				String lastFileName = saveDirectory + "\\" + fileName;
				String fileSavePath = uploadDir + autoCreatedDateDir + fileName;
				System.out.println("SimpleUploaderServlet");
				System.out.println("�ļ���ַ:" + lastFileName);
				System.out.println("����·��:" + fileSavePath);
				//set attchment database
				Attach attach = new Attach();
				attach.setNewName(fileName);
				attach.setOldName(oldFile.getName());
				attach.setPath(fileSavePath);
				//attach.setReportid(reportid);
				attach.setUserId(userid);
				try {
					flag = DAOFactory.getIAttachDAOInstance().saveFile(attach);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//
				response.getWriter().print(fileSavePath);
			}
		}

		System.out.println("--- END DOPOST ---");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public String getFileSizeLimit() {
		return fileSizeLimit;
	}

	public void setFileSizeLimit(String fileSizeLimit) {
		this.fileSizeLimit = fileSizeLimit;
	}

}
