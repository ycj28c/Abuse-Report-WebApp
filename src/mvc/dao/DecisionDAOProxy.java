package mvc.dao;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Decision;

public class DecisionDAOProxy implements IDecisionDAO {
	private DatabaseConnection dbc = null;// �������ݿ�����
	private IDecisionDAO dao = null;// ����DAO�ӿ�

	public DecisionDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// ʵ�������ݿ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new DecisionDAOImpl(this.dbc.getConnection());
	}
	
	public int addDecision(Decision decision) throws Exception {
		int PKdecision = 0;
		try {
			PKdecision = this.dao.addDecision(decision);// ������ʵ����
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return PKdecision;
	}

	public Decision getDecisionById(Decision decision) throws Exception {
		try {
			decision = this.dao.getDecisionById(decision);// ������ʵ����
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return decision;
	}

}
