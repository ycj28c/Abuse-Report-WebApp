package mvc.dao;

import mvc.vo.Investigation;

public interface IInvestigationDAO {
	public boolean addInvestigation(Investigation investigation) throws Exception;
	public Investigation isPublicLogNumberExist(Investigation investigation) throws Exception;
	public boolean updateInvestigationID(Investigation investigation) throws Exception;
}
