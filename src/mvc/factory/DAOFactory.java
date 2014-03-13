package mvc.factory;

import mvc.dao.*;

public class DAOFactory {
	public static IUserDAO getIUserDAOInstance() {// 取得DAO实例
		return new UserDAOProxy();// 返回代理实例
	}
	public static IReportDAO getIReportDAOInstance() {// 取得DAO实例
		return new ReportDAOProxy();// 返回代理实例
	}
	public static IAttachDAO getIAttachDAOInstance() {// 取得DAO实例
		return new AttachDAOProxy();// 返回代理实例
	}
	public static IPatientDAO getIPatientDAOInstance() {// 取得DAO实例
		return new PatientDAOProxy();// 返回代理实例
	}
}