package mvc.dao;

import java.util.ArrayList;

import structure.Page;

import mvc.vo.Report;

public interface IReportDAO {
	public ArrayList<Report> listAllReport(Report report) throws Exception;
	public ArrayList<Report> listReport(Report report,Page page) throws Exception;
	public boolean addreport(Report report) throws Exception;
	public boolean delReportById(Report report) throws Exception;
	public boolean mutiDelReport(String[] reportid) throws Exception;
	public Report readReportById(Report report) throws Exception;
	public boolean updatereport(Report report) throws Exception;
	public int getAmount(Report report) throws Exception;
}
