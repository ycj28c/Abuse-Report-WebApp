package mvc.factory;

import mvc.dao.*;

public class DAOFactory {
	public static IUserDAO getIUserDAOInstance() {// ȡ��DAOʵ��
		return new UserDAOProxy();// ���ش���ʵ��
	}
	public static IReportDAO getIReportDAOInstance() {// ȡ��DAOʵ��
		return new ReportDAOProxy();// ���ش���ʵ��
	}
}