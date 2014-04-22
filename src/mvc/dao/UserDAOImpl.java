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
			String sql = "select name, groupid from user where userid=? and password=?";
			this.pstmt = this.conn.prepareStatement(sql);// ʵ��������
			this.pstmt.setString(1, user.getUserid());// ����id
			this.pstmt.setString(2, user.getPassword());// ��������
			ResultSet rs = this.pstmt.executeQuery();// ȡ�ò�ѯ���
			if (rs.next()) {
				user.setName(rs.getString(1));// ȡ������
				user.setGroupid(rs.getString(2));// ȡ��groupid
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

	public User getInfo(User reporter) throws Exception {
		try {
			String sql = "select userid,name,password,address,telephone,mandated," +
					"SSN, DOB from user where userid=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, reporter.getUserid());
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				reporter.setName(rs.getString("name"));
				reporter.setPassword(rs.getString("password"));
				reporter.setAddress(rs.getString("address"));
				reporter.setTelephone(rs.getString("telephone"));
				reporter.setMandated(rs.getString("mandated"));
				reporter.setSSN(rs.getString("SSN"));
				reporter.setDOB(rs.getString("DOB"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return reporter;
	}

	public User getInfoByName(User abuser) throws Exception {
		try {
			String sql = "select userid,name,password,address,telephone,mandated," +
					"SSN, DOB from user where name=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, abuser.getName());
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				abuser.setUserid(rs.getString("userid"));
				abuser.setPassword(rs.getString("password"));
				abuser.setAddress(rs.getString("address"));
				abuser.setTelephone(rs.getString("telephone"));
				abuser.setMandated(rs.getString("mandated"));
				abuser.setSSN(rs.getString("SSN"));
				abuser.setDOB(rs.getString("DOB"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return abuser;
	}
}