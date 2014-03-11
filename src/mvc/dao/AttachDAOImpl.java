package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mvc.vo.Attach;

public class AttachDAOImpl implements IAttachDAO {
	private Connection conn = null;// �������ݿ����Ӷ���
	private PreparedStatement pstmt = null;// �������ݿ����Ӷ���

	public AttachDAOImpl(Connection conn) {// �������ݿ�����
		this.conn = conn;
	}
	public boolean saveFile(Attach attach) throws Exception {
		boolean flag = false;
		try {
			String sql = "INSERT INTO attachment (newname,oldname,path,userid) VALUES (?,?,?,?)";
			this.pstmt = this.conn.prepareStatement(sql);// ʵ��������
			System.out.println("attach.getNewName:"+attach.getNewName());
			this.pstmt.setString(1, attach.getNewName());
			this.pstmt.setString(2, attach.getOldName());
			this.pstmt.setString(3, attach.getPath());
			this.pstmt.setString(4, attach.getUserId());
			//this.pstmt.setInt(5, attach.getReportid());
			int rs = this.pstmt.executeUpdate();
			if (rs > 0) { // ��������
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getErrorCode());
			// throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();// �رղ���
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;// TODO Auto-generated method stub
	}

	public boolean deleteFileByPath(Attach attach) throws Exception {
		boolean flag = false;
		try {
			String sql = "DELETE FROM attachment where path = ?";
			this.pstmt = this.conn.prepareStatement(sql);// ʵ��������
			this.pstmt.setString(1, attach.getPath());
			int rs = this.pstmt.executeUpdate();
			if (rs > 0) { // ��������
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getErrorCode());
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
