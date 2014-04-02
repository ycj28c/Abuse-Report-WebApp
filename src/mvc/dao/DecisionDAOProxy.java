package mvc.dao;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Decision;

public class DecisionDAOProxy implements IDecisionDAO {
	private DatabaseConnection dbc = null;// 定义数据库连接
	private IDecisionDAO dao = null;// 定义DAO接口

	public DecisionDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// 实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new DecisionDAOImpl(this.dbc.getConnection());
	}
	
	public int addDecision(Decision decision) throws Exception {
		int PKdecision = 0;
		try {
			PKdecision = this.dao.addDecision(decision);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return PKdecision;
	}

	public Decision getDecisionById(Decision decision) throws Exception {
		try {
			decision = this.dao.getDecisionById(decision);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return decision;
	}

}
