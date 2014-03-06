package mvc.dao;

import java.util.ArrayList;

import mvc.vo.Report;

public interface IReportDAO {
	public ArrayList<Report> listreport(Report report) throws Exception;
	public boolean addreport(Report report) throws Exception;
	public boolean delReportById(Report report) throws Exception;
	public boolean mutiDelReport(String[] reportid) throws Exception;
}
