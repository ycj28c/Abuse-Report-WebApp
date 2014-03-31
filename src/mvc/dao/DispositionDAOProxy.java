package mvc.dao;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Disposition;

public class DispositionDAOProxy implements IDispositionDAO {
	private DatabaseConnection dbc = null;// �������ݿ�����
	private IDispositionDAO dao = null;// ����DAO�ӿ�

	public DispositionDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// ʵ�������ݿ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new DispositionDAOImpl(this.dbc.getConnection());
	}
	
	public int addDisposition(Disposition disposition) throws Exception {
		int PKdecision = 0;
		try {
			PKdecision = this.dao.addDisposition(disposition);// ������ʵ����
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return PKdecision;
	}

}
