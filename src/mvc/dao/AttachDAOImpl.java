package mvc.dao;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mvc.factory.DAOFactory;
import mvc.vo.Attach;
import mvc.vo.Report;

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
	public boolean deleteEmptyReportId(Attach attach, String prjPath) throws Exception {
		boolean flag = false;
		//delete data in disk
		try {
			String sql = "select path from attachment where reportid is null and userid=? and id !=''";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, attach.getUserId());
			ResultSet rs = this.pstmt.executeQuery();
			while (rs.next()) {
				String filePath = rs.getString("path");
				File file = new File(prjPath+filePath);
				if(file.exists()){
					if(file.delete())				
						System.out.println("Delete Useless File: "+prjPath+filePath);
				}
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
		//delete data in database
		try {
			String sql = "DELETE FROM attachment where reportid is null and userid=? and id !=''";
			this.pstmt = this.conn.prepareStatement(sql);// ʵ��������
			this.pstmt.setString(1, attach.getUserId());
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
	
	public boolean setReportId(Report report) throws Exception {
		boolean flag = false;
		try {
			String sql = "UPDATE attachment set reportid =? where userid=? and id!='' and reportid is null";
			this.pstmt = this.conn.prepareStatement(sql);// ʵ��������
			this.pstmt.setInt(1, report.getreportid());
			this.pstmt.setString(2, report.getuserid());
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
	
	public ArrayList<Attach> readAttachByReportId(Attach attach) throws Exception {
		ArrayList<Attach> arraylist = new ArrayList<Attach>();
		try {
			String sql = "select id,newname,oldname,path from attachment where reportid =? and userid =? and id!=''";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, attach.getReportid());
			this.pstmt.setString(2, attach.getUserId());
			ResultSet rs = this.pstmt.executeQuery();
			while (rs.next()) {
				Attach att = new Attach();
				att.setId(rs.getInt("id"));
				att.setNewName(rs.getString("newname"));
				att.setOldName(rs.getString("oldname"));
				att.setPath(rs.getString("path"));
				att.setReportid(attach.getReportid());
				att.setUserId(attach.getUserId());
				arraylist.add(att);
			}
			//System.out.println("arraylist-reportid 0:"+arraylist.get(0).getReportid());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();// �رղ���
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return arraylist;
	}

}
