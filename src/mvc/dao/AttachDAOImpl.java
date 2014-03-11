package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mvc.vo.Attach;

public class AttachDAOImpl implements IAttachDAO {
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement pstmt = null;// 定义数据库连接对象

	public AttachDAOImpl(Connection conn) {// 设置数据库连接
		this.conn = conn;
	}
	public boolean saveFile(Attach attach) throws Exception {
		boolean flag = false;
		try {
			String sql = "INSERT INTO attachment (newname,oldname,path,userid) VALUES (?,?,?,?)";
			this.pstmt = this.conn.prepareStatement(sql);// 实例化操作
			System.out.println("attach.getNewName:"+attach.getNewName());
			this.pstmt.setString(1, attach.getNewName());
			this.pstmt.setString(2, attach.getOldName());
			this.pstmt.setString(3, attach.getPath());
			this.pstmt.setString(4, attach.getUserId());
			//this.pstmt.setInt(5, attach.getReportid());
			int rs = this.pstmt.executeUpdate();
			if (rs > 0) { // 返回条数
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getErrorCode());
			// throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();// 关闭操作
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
			this.pstmt = this.conn.prepareStatement(sql);// 实例化操作
			this.pstmt.setString(1, attach.getPath());
			int rs = this.pstmt.executeUpdate();
			if (rs > 0) { // 返回条数
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getErrorCode());
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();// 关闭操作
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}

}
