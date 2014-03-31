package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import mvc.vo.Investigation;

public class InvestigationDAOImpl implements IInvestigationDAO{
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement pstmt = null;// 定义数据库连接对象
	
	public InvestigationDAOImpl(Connection conn) {// 设置数据库连接
		this.conn = conn;
	}

	public boolean addInvestigation(Investigation investigation)
			throws Exception {
		boolean flag = false;
		try {
			String sql = "INSERT INTO investigation (publiclognumber, reportid, status," +
					"dispositionid, respondid, decisionid) VALUES (?, ?, ?, ?, ?, ?)";
			/*
			 * System.out.println("report.getdiscript():"+report.getdiscript());
			 * System.out.println("report.getName():"+report.getName());
			 * System.out.println("report.getuserid():"+report.getuserid());
			 */
			this.pstmt = this.conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);// 实例化操作
			this.pstmt.setString(1, investigation.getPubliclognumber());
			this.pstmt.setString(2, investigation.getReportid());
			this.pstmt.setString(3, investigation.getStatus());
			this.pstmt.setString(4, investigation.getDispositionid());
			this.pstmt.setString(5, investigation.getRespondid());
			this.pstmt.setString(6, investigation.getDecisionid());
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
