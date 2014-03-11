package mvc.dao;

import java.sql.Connection;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Attach;
import mvc.vo.Report;

public class AttachDAOProxy implements IAttachDAO{
	private DatabaseConnection dbc = null;// �������ݿ�����
	private IAttachDAO dao = null;// ����DAO�ӿ�

	public AttachDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// ʵ�������ݿ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new AttachDAOImpl(this.dbc.getConnection());
	}
	
	public boolean saveFile(Attach attach) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.saveFile(attach);// ������ʵ����
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean deleteFileByPath(Attach attach) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.deleteFileByPath(attach);// ������ʵ����
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

}
