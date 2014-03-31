package mvc.factory;

import mvc.dao.*;

public class DAOFactory {
	public static IUserDAO getIUserDAOInstance() {// ȡ��DAOʵ��
		return new UserDAOProxy();// ���ش���ʵ��
	}
	public static IReportDAO getIReportDAOInstance() {// ȡ��DAOʵ��
		return new ReportDAOProxy();// ���ش���ʵ��
	}
	public static IAttachDAO getIAttachDAOInstance() {// ȡ��DAOʵ��
		return new AttachDAOProxy();// ���ش���ʵ��
	}
	public static IPatientDAO getIPatientDAOInstance() {// ȡ��DAOʵ��
		return new PatientDAOProxy();// ���ش���ʵ��
	}
	public static IAuthorityMappingDAO getIAuthorityMappingDAOInstance() {// ȡ��DAOʵ��
		return new AuthorityMappingDAOProxy();// ���ش���ʵ��
	}
	public static IDecisionDAO getIDecisionDAOInstance() {// ȡ��DAOʵ��
		return new DecisionDAOProxy();// ���ش���ʵ��
	}
	public static IDispositionDAO getIDispositionDAOInstance() {// ȡ��DAOʵ��
		return new DispositionDAOProxy();// ���ش���ʵ��
	}
	public static IRespondDAO getIRespondDAOInstance() {// ȡ��DAOʵ��
		return new RespondDAOProxy();// ���ش���ʵ��
	}
	public static IInvestigationDAO getIInvestigationDAOInstance() {// ȡ��DAOʵ��
		return new InvestigationDAOProxy();// ���ش���ʵ��
	}
}