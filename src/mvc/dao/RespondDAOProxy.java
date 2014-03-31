package mvc.dao;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Respond;

public class RespondDAOProxy implements IRespondDAO {
	private DatabaseConnection dbc = null;// �������ݿ�����
	private IRespondDAO dao = null;// ����DAO�ӿ�

	public RespondDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// ʵ�������ݿ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new RespondDAOImpl(this.dbc.getConnection());
	}
	
	public int addRespond(Respond respond) throws Exception {
		int PKrespond = 0;
		try {
			PKrespond = this.dao.addRespond(respond);// ������ʵ����
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return PKrespond;
	}

}
