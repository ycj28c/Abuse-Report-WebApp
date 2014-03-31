package mvc.dao;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Respond;

public class RespondDAOProxy implements IRespondDAO {
	private DatabaseConnection dbc = null;// 定义数据库连接
	private IRespondDAO dao = null;// 定义DAO接口

	public RespondDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// 实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new RespondDAOImpl(this.dbc.getConnection());
	}
	
	public int addRespond(Respond respond) throws Exception {
		int PKrespond = 0;
		try {
			PKrespond = this.dao.addRespond(respond);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return PKrespond;
	}

}
