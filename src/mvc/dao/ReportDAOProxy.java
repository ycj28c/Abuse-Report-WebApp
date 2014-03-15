package mvc.dao;

import java.util.ArrayList;

import structure.Page;

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

	public ArrayList<Report> listAllReport(Report report) throws Exception {
		ArrayList<Report> reportlist = new ArrayList<Report>();
		try {
			reportlist = this.dao.listAllReport(report);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return reportlist;
	}

	public int addreport(Report report) throws Exception {
		int reportid = 0;
		try {
			reportid = this.dao.addreport(report);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return reportid;
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

	public boolean mutiDelReport(String[] reportid,Report report) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.mutiDelReport(reportid,report);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public Report readReportById(Report report) throws Exception {
		try {
			report = this.dao.readReportById(report);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return report;
	}

	public boolean updatereport(Report report) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.updatereport(report);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public ArrayList<Report> listReport(Report report, Page page) throws Exception {
		ArrayList<Report> reportlist = new ArrayList<Report>();
		try {
			reportlist = this.dao.listReport(report, page);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return reportlist;
	}

	public int getAmount(Report report) throws Exception {
		int amount = 0;
		try {
			amount = this.dao.getAmount(report);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return amount;
	}

	public ArrayList<Report> supervisorListReport(Page page, String roleid) throws Exception {
		ArrayList<Report> reportlist = new ArrayList<Report>();
		try {
			reportlist = this.dao.supervisorListReport(page, roleid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return reportlist;
	}

	public int getAmountSupervisor(String roleid) throws Exception {
		int amount = 0;
		try {
			amount = this.dao.getAmountSupervisor(roleid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return amount;
	}

	public ArrayList<Report> superAdminListReport(Page page) throws Exception {
		ArrayList<Report> reportlist = new ArrayList<Report>();
		try {
			reportlist = this.dao.superAdminListReport(page);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return reportlist;
	}

	public int getAmountSuperAdmin() throws Exception {
		int amount = 0;
		try {
			amount = this.dao.getAmountSuperAdmin();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return amount;
	}


}
