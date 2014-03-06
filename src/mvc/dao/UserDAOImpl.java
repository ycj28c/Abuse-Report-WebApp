//����ʵ����,�ڴ����н�ͨ�������û�ID�����������֤�� 
//�����֤�ɹ�����ͨ��VO���û�����ʵ����ȡ�������� 
package mvc.dao;

import java.sql.*;
import mvc.dao.IUserDAO;
import mvc.vo.User;

public class UserDAOImpl implements IUserDAO {
	private Connection conn = null;// �������ݿ����Ӷ���
	private PreparedStatement pstmt = null;// �������ݿ����Ӷ���

	public UserDAOImpl(Connection conn) {// �������ݿ�����
		this.conn = conn;
	}

	public boolean findLogin(User user) throws Exception {
		boolean flag = false;
		try {
			String sql = "select name from user where userid=? and password=?";
			this.pstmt = this.conn.prepareStatement(sql);// ʵ��������
			this.pstmt.setString(1, user.getUserid());// ����id
			this.pstmt.setString(2, user.getPassword());// ��������
			ResultSet rs = this.pstmt.executeQuery();// ȡ�ò�ѯ���
			if (rs.next()) {
				user.setName(rs.getString(1));// ȡ������
				flag = true;// ��¼�ɹ�
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();// �رղ���
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}
}