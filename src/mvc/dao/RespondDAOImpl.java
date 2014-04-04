package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import mvc.vo.Respond;

public class RespondDAOImpl implements IRespondDAO {
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement pstmt = null;// 定义数据库连接对象
	
	public RespondDAOImpl(Connection conn) {// 设置数据库连接
		this.conn = conn;
	}

	public int addRespond(Respond respond) throws Exception {
		int PKrespond = 0;
		try {
			String sql = "INSERT INTO respond (reportid, investigationid, content) VALUES (?, ?, ?)";
			/*
			 * System.out.println("report.getdiscript():"+report.getdiscript());
			 * System.out.println("report.getName():"+report.getName());
			 * System.out.println("report.getuserid():"+report.getuserid());
			 */
			this.pstmt = this.conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			this.pstmt.setString(1, respond.getReportid());
			this.pstmt.setString(2, respond.getInvestigationid());
			this.pstmt.setString(3, respond.getContent());
			this.pstmt.executeUpdate();
			ResultSet rs = this.pstmt.getGeneratedKeys(); 
			if(rs.next()){
				PKrespond = rs.getInt(1);
	        }else {
	        	PKrespond = 0;
	        }
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getErrorCode());
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return PKrespond;
	}

	public Respond getRespondById(Respond respond) throws Exception {
		String sql = "select reportid,investigationid,content from respond where PK_respond=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, respond.getPkRespond());
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			respond.setReportid(rs.getString("reportid"));
			respond.setInvestigationid(rs.getString("investigationid"));
			respond.setContent(rs.getString("content"));		
		}
		return respond;
	}

	public boolean updateRespond(Respond respond) throws Exception {
		boolean flag = false;
		try {
			String sql = "UPDATE respond set reportid=?,investigationid=?,content=? where PK_respond=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, respond.getReportid());
			this.pstmt.setString(2, respond.getInvestigationid());
			this.pstmt.setString(3, respond.getContent());
			this.pstmt.setInt(4, respond.getPkRespond());
			int rs = this.pstmt.executeUpdate();
			if (rs > 0) { // return number
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}
}
