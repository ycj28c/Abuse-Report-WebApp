package mvc.dao;

import java.util.ArrayList;

import structure.Page;

import mvc.vo.Report;

public interface IReportDAO {
	public ArrayList<Report> listAllReport(Report report) throws Exception;
	public ArrayList<Report> listReport(Report report,Page page) throws Exception;
	public ArrayList<Report> supervisorListReport(Page page,String roleid) throws Exception;
	public ArrayList<Report> superAdminListReport(Page page) throws Exception;
	public int addreport(Report report) throws Exception;
	public boolean delReportById(Report report) throws Exception;
	public boolean mutiDelReport(String[] reportid,Report report) throws Exception;
	public Report readReportById(Report report) throws Exception;
	public boolean updatereport(Report report) throws Exception;
	public int getAmount(Report report) throws Exception;
	public int getAmountSupervisor(String roleid) throws Exception;
	public int getAmountSuperAdmin() throws Exception;
}
