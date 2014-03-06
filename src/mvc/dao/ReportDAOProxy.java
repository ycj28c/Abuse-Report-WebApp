package mvc.dao;

import java.util.ArrayList;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Report;

public class ReportDAOProxy implements IReportDAO {
	private DatabaseConnection dbc = null;// 定义数据库连接
	private IReportDAO dao = null;// 定义DAO接口

	public ReportDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// 实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new ReportDAOImpl(this.dbc.getConnection());
	}

	public ArrayList<Report> listreport(Report report) throws Exception {
		ArrayList<Report> reportlist = new ArrayList<Report>();
		try {
			reportlist = this.dao.listreport(report);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return reportlist;
	}

	public boolean addreport(Report report) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.addreport(report);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean delReportById(Report report) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.delReportById(report);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean mutiDelReport(String[] reportid) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.mutiDelReport(reportid);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}




}
