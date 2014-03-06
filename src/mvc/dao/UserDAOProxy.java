package mvc.dao;

import mvc.dao.*;
import mvc.dbc.*;
import mvc.vo.*;

public class UserDAOProxy implements IUserDAO {
	private DatabaseConnection dbc = null;// �������ݿ�����
	private IUserDAO dao = null;// ����DAO�ӿ�

	public UserDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// ʵ�������ݿ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new UserDAOImpl(this.dbc.getConnection());
	}

	public boolean findLogin(User user) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.findLogin(user);// ������ʵ����
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}
}