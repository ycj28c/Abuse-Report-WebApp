package mvc.dao;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Disposition;

public class DispositionDAOProxy implements IDispositionDAO {
	private DatabaseConnection dbc = null;// 定义数据库连接
	private IDispositionDAO dao = null;// 定义DAO接口

	public DispositionDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// 实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new DispositionDAOImpl(this.dbc.getConnection());
	}
	
	public int addDisposition(Disposition disposition) throws Exception {
		int PKdecision = 0;
		try {
			PKdecision = this.dao.addDisposition(disposition);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return PKdecision;
	}

}
