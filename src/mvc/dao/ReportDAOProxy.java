package mvc.dao;

import java.util.ArrayList;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Report;

public class ReportDAOProxy implements IReportDAO {
	private DatabaseConnection dbc = null;// �������ݿ�����
	private IReportDAO dao = null;// ����DAO�ӿ�

	public ReportDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// ʵ�������ݿ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new ReportDAOImpl(this.dbc.getConnection());
	}

	public ArrayList<Report> listreport(Report report) throws Exception {
		ArrayList<Report> reportlist = new ArrayList<Report>();
		try {
			reportlist = this.dao.listreport(report);// ������ʵ����
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
			flag = this.dao.addreport(report);// ������ʵ����
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
			flag = this.dao.delReportById(report);// ������ʵ����
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
			flag = this.dao.mutiDelReport(reportid);// ������ʵ����
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}




}
