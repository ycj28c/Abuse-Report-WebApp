package mvc.dao;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Investigation;

public class InvestigationDAOProxy implements IInvestigationDAO {
	private DatabaseConnection dbc = null;// 定义数据库连接
	private IInvestigationDAO dao = null;// 定义DAO接口

	public InvestigationDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// 实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new InvestigationDAOImpl(this.dbc.getConnection());
	}
	
	public boolean addInvestigation(Investigation investigation)
			throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.addInvestigation(investigation);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

}
