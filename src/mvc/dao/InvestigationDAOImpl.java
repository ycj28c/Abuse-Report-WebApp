package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import mvc.vo.Investigation;

public class InvestigationDAOImpl implements IInvestigationDAO{
	private Connection conn = null;// �������ݿ����Ӷ���
	private PreparedStatement pstmt = null;// �������ݿ����Ӷ���
	
	public InvestigationDAOImpl(Connection conn) {// �������ݿ�����
		this.conn = conn;
	}

	public boolean addInvestigation(Investigation investigation) throws Exception {
		boolean flag = false;
		try {
			String sql = "INSERT INTO investigation (publiclognumber, reportid, status," +
					"dispositionid, respondid, decisionid) VALUES (?, ?, ?, ?, ?, ?)";
			/*
			 * System.out.println("report.getdiscript():"+report.getdiscript());
			 * System.out.println("report.getName():"+report.getName());
			 * System.out.println("report.getuserid():"+report.getuserid());
			 */
			this.pstmt = this.conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);// ʵ��������
			this.pstmt.setString(1, investigation.getPubliclognumber());
			this.pstmt.setString(2, investigation.getReportid());
			this.pstmt.setString(3, investigation.getStatus());
			this.pstmt.setString(4, investigation.getDispositionid());
			this.pstmt.setString(5, investigation.getRespondid());
			this.pstmt.setString(6, investigation.getDecisionid());
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

	public Investigation isPublicLogNumberExist(Investigation investigation) throws Exception {
		String sql = "select PK_investigation,reportid,status,dispositionid,respondid,decisionid" +
				" from investigation where publiclognumber=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, investigation.getPubliclognumber());
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			investigation.setPkInvestigation(rs.getInt("PK_investigation"));
			investigation.setReportid(rs.getString("reportid"));
			investigation.setStatus(rs.getString("status"));
			investigation.setRespondid(rs.getString("respondid"));
			investigation.setDispositionid(rs.getString("dispositionid"));
			investigation.setDecisionid(rs.getString("decisionid"));		
		}
		return investigation;
	}

	public boolean updateInvestigationID(Investigation investigation) throws Exception {
		boolean flag = false;
		try {
			String sql = "UPDATE investigation set reportid=? where publiclognumber=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, investigation.getReportid());
			this.pstmt.setString(2, investigation.getPubliclognumber());
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
