package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import mvc.vo.Decision;;

public class DecisionDAOImpl implements IDecisionDAO {
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement pstmt = null;// 定义数据库连接对象
	
	public DecisionDAOImpl(Connection conn) {// 设置数据库连接
		this.conn = conn;
	}

	public int addDecision(Decision decision) throws Exception {
		int PKdecision = 0;
		try {
			String sql = "INSERT INTO decision (reportid, investigationid, description, attacholdname, " +
					"attachnewname, attachpath) VALUES (?, ?, ?, ?, ?, ?)";
			/*
			 * System.out.println("report.getdiscript():"+report.getdiscript());
			 * System.out.println("report.getName():"+report.getName());
			 * System.out.println("report.getuserid():"+report.getuserid());
			 */
			this.pstmt = this.conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			this.pstmt.setString(1, decision.getReportid());
			this.pstmt.setString(2, decision.getInvestigationid());
			this.pstmt.setString(3, decision.getDescription());
			this.pstmt.setString(4, decision.getAttacholdname());
			this.pstmt.setString(5, decision.getAttachnewname());
			this.pstmt.setString(6, decision.getAttachpath());
			this.pstmt.executeUpdate();
			ResultSet rs = this.pstmt.getGeneratedKeys(); 
			if(rs.next()){
				PKdecision = rs.getInt(1);
	        }else {
	        	PKdecision = 0;
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
		return PKdecision;
	}

	public Decision getDecisionById(Decision decision) throws Exception {
		String sql = "select reportid,investigationid,description,attacholdname,attachnewname,attachpath" +
				" from decision where PK_decision=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, decision.getPkDecision());
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			decision.setReportid(rs.getString("reportid"));
			decision.setInvestigationid(rs.getString("investigationid"));
			decision.setDescription(rs.getString("description"));
			decision.setAttacholdname(rs.getString("attacholdname"));
			decision.setAttachnewname(rs.getString("attachnewname"));
			decision.setAttachpath(rs.getString("attachpath"));		
		}
		return decision;
	}
}
