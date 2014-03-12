package mvc.dao;

import java.sql.Connection;
import java.util.ArrayList;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Attach;
import mvc.vo.Report;

public class AttachDAOProxy implements IAttachDAO{
	private DatabaseConnection dbc = null;// 定义数据库连接
	private IAttachDAO dao = null;// 定义DAO接口

	public AttachDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// 实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new AttachDAOImpl(this.dbc.getConnection());
	}
	
	public boolean saveFile(Attach attach) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.saveFile(attach);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean deleteFileByPath(Attach attach) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.deleteFileByPath(attach);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean deleteEmptyReportId(Attach attach, String prjPath) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.deleteEmptyReportId(attach, prjPath);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean setReportId(Report report) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.setReportId(report);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public ArrayList<Attach> readAttachByReportId(Attach attach) throws Exception {
		ArrayList<Attach> attachlist = new ArrayList<Attach>();
		try {
			attachlist = this.dao.readAttachByReportId(attach);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return attachlist;
	}

}
