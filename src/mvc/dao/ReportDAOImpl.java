package mvc.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import structure.Page;

import mvc.vo.Report;

public class ReportDAOImpl implements IReportDAO {
	private Connection conn = null;// �������ݿ����Ӷ���
	private PreparedStatement pstmt = null;// �������ݿ����Ӷ���

	public ReportDAOImpl(Connection conn) {// �������ݿ�����
		this.conn = conn;
	}

	public ArrayList<Report> listAllReport(Report report) throws Exception {
		ArrayList<Report> reportlist = new ArrayList<Report>();
		try {
			String sql = "select reportid,discript,name,time from report where userid=?";
			this.pstmt = this.conn.prepareStatement(sql);// ʵ��������
			this.pstmt.setString(1, report.getuserid());// ����id
			ResultSet rs = this.pstmt.executeQuery();// ȡ�ò�ѯ���
			while (rs.next()) {
				Report rep = new Report();
				rep.setreportid(rs.getInt("reportid"));
				rep.setdiscript(rs.getString("discript"));
				rep.setName(rs.getString("name"));
				rep.settime(rs.getDate("time"));
				reportlist.add(rep);
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
		return reportlist;
	}
	
	public ArrayList<Report> listReport(Report report, Page page) throws Exception {
		ArrayList<Report> reportlist = new ArrayList<Report>();
		try {
			String sql = "select reportid,discript,name,time from report where userid=?";
			this.pstmt = this.conn.prepareStatement(sql);// ʵ��������
			this.pstmt.setString(1, report.getuserid());// ����id
			this.pstmt.setMaxRows(page.getPageIndex()*page.getpageSize());//��ѯ��������� 
			ResultSet rs = this.pstmt.executeQuery();// ȡ�ò�ѯ���
			rs.absolute((page.getPageIndex()-1)*page.getpageSize());//���þ��Զ�λ��λ���������ÿҳ�ڶ�����
			//rs.relative(-1);//���ý��������Զ�λ��λ��ÿҳ�ĵ�һ������ 
			while (rs.next()) {
				Report rep = new Report();
				rep.setreportid(rs.getInt("reportid"));
				rep.setdiscript(rs.getString("discript"));
				rep.setName(rs.getString("name"));
				rep.settime(rs.getDate("time"));

				reportlist.add(rep);

				/*
				 * test
				 * System.out.println("rsgetreportid:"+rs.getInt("reportid"));
				 * System
				 * .out.println("rsgetdiscript:"+rs.getString("discript"));
				 * System.out.println("rsgetname:"+rs.getString(2));
				 * System.out.println("rsgetdate:"+rs.getDate("time"));
				 * 
				 * System.out.println("getreportid:"+rep.getreportid());
				 * System.out.println("getdiscript:"+rep.getdiscript());
				 * System.out.println("getname:"+rep.getName());
				 * System.out.println("getdate:"+rep.gettime());
				 */
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
		return reportlist;
	}

	public boolean addreport(Report report) throws Exception {
		boolean flag = false;
		try {
			java.sql.Date trans_time = new java.sql.Date(report.gettime()
					.getTime()); // ��java.util.Date �D�QΪ java.sql.Date

			String sql = "INSERT INTO report (discript, name, time, userid) VALUES (?, ?, ?, ?)";
			/*
			 * System.out.println("report.getdiscript():"+report.getdiscript());
			 * System.out.println("report.getName():"+report.getName());
			 * System.out.println("report.getuserid():"+report.getuserid());
			 */
			// java.sql.Date date = new java.sql.Date(new
			// java.util.Date().getTime());
			this.pstmt = this.conn.prepareStatement(sql);// ʵ��������
			this.pstmt.setString(1, report.getdiscript());
			this.pstmt.setString(2, report.getName());
			this.pstmt.setDate(3, trans_time);
			this.pstmt.setString(4, report.getuserid());
			// ResultSet rs = this.pstmt.executeQuery();// ȡ�ò�ѯ���
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
		return flag;
	}

	public boolean delReportById(Report report) throws Exception {
		boolean flag = false;
		try {
			String sql = "DELETE FROM report where reportid = ?";
			this.pstmt = this.conn.prepareStatement(sql);// ʵ��������
			this.pstmt.setInt(1, report.getreportid());
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

	public boolean mutiDelReport(String[] reportid) throws Exception {
		boolean flag = false;
		try {
			String sql = "DELETE FROM report where reportid = ?";
			this.pstmt = this.conn.prepareStatement(sql);// ʵ��������
			for (int i = 0; i < reportid.length; i++) {
				int id = Integer.parseInt(reportid[i]);
				this.pstmt.setInt(1, id);
				int rs = this.pstmt.executeUpdate();
			}
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println(e.getErrorCode());
			// flag = false;
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

	public Report readReportById(Report report) throws Exception {
		try {
			
			String sql = "select name,time,discript from report where reportid = ?";
			this.pstmt = this.conn.prepareStatement(sql);// ʵ��������
			this.pstmt.setInt(1, report.getreportid());
			ResultSet rs = this.pstmt.executeQuery();// ȡ�ò�ѯ���
			while (rs.next()) {
				report.setdiscript(rs.getString("discript"));
				report.setName(rs.getString("name"));
				report.settime(rs.getDate("time"));
				}
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
		return report;
	}

	public boolean updatereport(Report report) throws Exception {
		boolean flag = false;
		java.sql.Date trans_time = new java.sql.Date(report.gettime()
				.getTime()); // ��java.util.Date �D�QΪ java.sql.Date
		try {
			String sql = "UPDATE report set name = ?,discript=?,time=? where reportid = ?";
			this.pstmt = this.conn.prepareStatement(sql);// ʵ��������
			this.pstmt.setString(1, report.getName());
			this.pstmt.setString(2, report.getdiscript());
			this.pstmt.setDate(3, trans_time);
			this.pstmt.setInt(4, report.getreportid());
			int rs = this.pstmt.executeUpdate();
			if (rs > 0) { // ��������
				flag = true;
			}
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
		return flag;
	}

	public int getAmount(Report report) throws Exception {
		int amout = 0;
		try {
			String sql = "select count(*) as total from report where userid=?";
			this.pstmt = this.conn.prepareStatement(sql);// ʵ��������
			this.pstmt.setString(1, report.getuserid());// ����id
			ResultSet rs = this.pstmt.executeQuery();// ȡ�ò�ѯ���
			if (rs.next()) {
				amout = rs.getInt("total");
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
		return amout;
	}

}
