package mvc.dao;

import mvc.dao.*;
import mvc.dbc.*;
import mvc.vo.*;

public class UserDAOProxy implements IUserDAO {
	private DatabaseConnection dbc = null;// 定义数据库连接
	private IUserDAO dao = null;// 定义DAO接口

	public UserDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// 实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new UserDAOImpl(this.dbc.getConnection());
	}

	public boolean findLogin(User user) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.findLogin(user);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public User getInfo(User reporter) throws Exception {
		try {
			reporter = this.dao.getInfo(reporter);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return reporter;
	}

	public User getInfoByName(User abuser) throws Exception {
		try {
			abuser = this.dao.getInfoByName(abuser);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return abuser;
	}
}