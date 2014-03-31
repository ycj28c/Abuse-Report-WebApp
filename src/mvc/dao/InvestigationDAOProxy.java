package mvc.dao;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Investigation;

public class InvestigationDAOProxy implements IInvestigationDAO {
	private DatabaseConnection dbc = null;// �������ݿ�����
	private IInvestigationDAO dao = null;// ����DAO�ӿ�

	public InvestigationDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// ʵ�������ݿ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new InvestigationDAOImpl(this.dbc.getConnection());
	}
	
	public boolean addInvestigation(Investigation investigation)
			throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.addInvestigation(investigation);// ������ʵ����
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

}
