package mvc.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import structure.Page;

import mvc.vo.Report;

public class ReportDAOImpl implements IReportDAO {
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement pstmt = null;// 定义数据库连接对象

	public ReportDAOImpl(Connection conn) {// 设置数据库连接
		this.conn = conn;
	}

	public ArrayList<Report> listAllReport(Report report) throws Exception {
		ArrayList<Report> reportlist = new ArrayList<Report>();
		try {
			String sql = "select reportid,username,time from report where userid=?";
			this.pstmt = this.conn.prepareStatement(sql);// 实例化操作
			this.pstmt.setString(1, report.getUserid());// 设置id
			ResultSet rs = this.pstmt.executeQuery();// 取得查询结果
			while (rs.next()) {
				Report rep = new Report();
				rep.setReportid(rs.getInt("reportid"));
				rep.setUsername(rs.getString("name"));
				rep.setTime(rs.getDate("time"));
				reportlist.add(rep);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();// 关闭操作
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
			String sql = "select reportid,userid,username,time,abuserid,abusername,victimid," +
					"victimname,frequency,abusetype,awareof,investigatorrisk,dppchotline," +
					"narrativeform,risklevel,witness,caregiverrelationship,groupid " +
					"from report where userid =?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, report.getUserid());
			this.pstmt.setMaxRows(page.currentPage*page.getPageSize());//查询的最大行数 
			ResultSet rs = this.pstmt.executeQuery();// 取得查询结果
			rs.absolute((page.currentPage-1)*page.getPageSize());//利用绝对定位定位到结果集的每页第二条数
			//rs.relative(-1);//利用结果集的相对定位定位到每页的第一条数据 
			while (rs.next()) {
				Report rep = new Report();
				rep.setReportid(rs.getInt("reportid"));
				rep.setUsername(rs.getString("username"));
				rep.setTime(rs.getDate("time"));
				rep.setUsername(rs.getString("abusername"));
				rep.setVictimname(rs.getString("victimname"));
				rep.setFrequency(rs.getString("frequency"));
				rep.setAbusetype(rs.getString("abusetype"));
				rep.setAwareof(rs.getString("awareof"));
				rep.setInvestigatorrisk(rs.getString("investigatorrisk"));
				rep.setDppchotline(rs.getString("dppchotline"));
				rep.setNarrativeform(rs.getString("narrativeform"));
				rep.setRisklevel(rs.getString("risklevel"));
				rep.setWitness(rs.getString("witness"));
				rep.setCaregiverrelationship(rs.getString("caregiverrelationship"));

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
					this.pstmt.close();// 关闭操作
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return reportlist;
	}

	public int addreport(Report report) throws Exception {
		int reportid = 0;
		try {
			//java.sql.Date trans_time = new java.sql.Date(report.gettime().getTime()); // 將java.util.Date 轉換为 java.sql.Date
			String sql = "INSERT INTO report (userid, time, abusername, victimname, " +
					"frequency, abusetype, awareof, investigatorrisk, dppchotline, " +
					"narrativeform, risklevel, resultinginjure, witness, caregiverrelationship) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			/*
			 * System.out.println("report.getdiscript():"+report.getdiscript());
			 * System.out.println("report.getName():"+report.getName());
			 * System.out.println("report.getuserid():"+report.getuserid());
			 */
			this.pstmt = this.conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);// 实例化操作
			this.pstmt.setString(1, report.getUserid());
			this.pstmt.setDate(2, report.getTime());
			this.pstmt.setString(3, report.getAbusername());
			this.pstmt.setString(4, report.getVictimname());
			this.pstmt.setString(5, report.getFrequency());
			this.pstmt.setString(6, report.getAbusetype());
			this.pstmt.setString(7, report.getAwareof());
			this.pstmt.setString(8, report.getInvestigatorrisk());
			this.pstmt.setString(9, report.getDppchotline());
			this.pstmt.setString(10, report.getNarrativeform());
			this.pstmt.setString(11, report.getRisklevel());
			this.pstmt.setString(12, report.getResultinginjure());
			this.pstmt.setString(13, report.getWitness());
			this.pstmt.setString(14, report.getCaregiverrelationship());
			// ResultSet rs = this.pstmt.executeQuery();// 取得查询结果
			this.pstmt.executeUpdate();
			ResultSet rs = this.pstmt.getGeneratedKeys(); 
			if(rs.next()){
	            reportid = rs.getInt(1);
	        }else {
	        	reportid = 0;
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
		return reportid;
	}

	public boolean delReportById(Report report) throws Exception {
		boolean flag = false;
		try {
			String sql = "DELETE FROM report where reportid = ? and userid=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, report.getReportid());
			this.pstmt.setString(2, report.getUserid());
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
					this.pstmt.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}

	public boolean mutiDelReport(String[] reportid,Report report) throws Exception {
		boolean flag = false;
		try {
			String userid = report.getUserid();
			String sql = "DELETE FROM report where reportid =? and userid =?";
			this.pstmt = this.conn.prepareStatement(sql);
			for (int i = 0; i < reportid.length; i++) {
				int id = Integer.parseInt(reportid[i]);
				this.pstmt.setInt(1, id);
				this.pstmt.setString(2, userid);
				this.pstmt.executeUpdate();
			}
			flag = true;
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

	public Report readReportById(Report report) throws Exception {
		try {
			
			String sql = "select reportid,userid,username,time,abuserid,abusername,victimid," +
					"victimname,frequency,abusetype,awareof,investigatorrisk,dppchotline," +
					"narrativeform,risklevel,resultinginjure,witness,caregiverrelationship,groupid " +
					"from report where reportid=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, report.getReportid());
			//this.pstmt.setString(2, report.getUserid());
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				report.setUsername(rs.getString("username"));
				report.setUserid(rs.getString("userid"));
				report.setTime(rs.getDate("time"));
				report.setAbusername(rs.getString("abusername"));
				report.setAbuserid(rs.getInt("abuserid"));
				report.setVictimname(rs.getString("victimname"));
				report.setVictimid(rs.getInt("victimid"));
				report.setFrequency(rs.getString("frequency"));
				report.setAbusetype(rs.getString("abusetype"));
				report.setAwareof(rs.getString("awareof"));
				report.setInvestigatorrisk(rs.getString("investigatorrisk"));
				report.setDppchotline(rs.getString("dppchotline"));
				report.setNarrativeform(rs.getString("narrativeform"));
				report.setRisklevel(rs.getString("risklevel"));
				report.setResultinginjure(rs.getString("resultinginjure"));
				report.setWitness(rs.getString("witness"));
				report.setCaregiverrelationship(rs.getString("caregiverrelationship"));
			}
			//debug
			//System.out.println("report.getAbusername():"+report.getAbusername());
			//System.out.println("report.getVictimname():"+report.getVictimname());
			//System.out.println("report.getAbusetype():"+report.getAbusetype());
			
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
		return report;
	}

	public boolean updatereport(Report report) throws Exception {
		boolean flag = false;
		try {
			String sql = "UPDATE report set time=?,abusername=?,victimname=?,frequency=?,abusetype=?," +
					"awareof=?,investigatorrisk=?,dppchotline=?,narrativeform=?,risklevel=?,resultinginjure=?," +
					"witness=?,caregiverrelationship=? where reportid=? and userid =?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setDate(1, report.getTime());
			this.pstmt.setString(2, report.getAbusername());
			this.pstmt.setString(3, report.getVictimname());
			this.pstmt.setString(4, report.getFrequency());
			this.pstmt.setString(5, report.getAbusetype());
			this.pstmt.setString(6, report.getAwareof());
			this.pstmt.setString(7, report.getInvestigatorrisk());
			this.pstmt.setString(8, report.getDppchotline());
			this.pstmt.setString(9, report.getNarrativeform());
			this.pstmt.setString(10, report.getRisklevel());
			this.pstmt.setString(11, report.getResultinginjure());
			this.pstmt.setString(12, report.getWitness());
			this.pstmt.setString(13, report.getCaregiverrelationship());
			this.pstmt.setInt(14, report.getReportid());
			this.pstmt.setString(15, report.getUserid());
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

	public int getAmount(Report report) throws Exception {
		int amout = 0;
		try {
			String sql = "select count(*) as total from report where userid=?";
			this.pstmt = this.conn.prepareStatement(sql);// 实例化操作
			this.pstmt.setString(1, report.getUserid());// 设置id
			ResultSet rs = this.pstmt.executeQuery();// 取得查询结果
			if (rs.next()) {
				amout = rs.getInt("total");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();// 关闭操作
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return amout;
	}

	public ArrayList<Report> supervisorListReport(Page page, String roleid) throws Exception {
		ArrayList reportlist = new ArrayList<Report>();
		try {
			String sql = "select reportid,userid,username,time,abuserid,abusername,victimid," +
						"victimname,frequency,abusetype,awareof,investigatorrisk,dppchotline," +
						"narrativeform,risklevel,witness,caregiverrelationship,groupid,status from report " +
						"where groupid in (select groupid from role where PK_role =?)";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, roleid);
			this.pstmt.setMaxRows(page.currentPage*page.getPageSize());//max row of display
			ResultSet rs = this.pstmt.executeQuery();
			rs.absolute((page.currentPage-1)*page.getPageSize());//set location to second record of each page
			//rs.relative(-1);//back 1 position
			while (rs.next()) {
				Report rep = new Report();
				rep.setReportid(rs.getInt("reportid"));
				rep.setUsername(rs.getString("username"));
				rep.setTime(rs.getDate("time"));
				rep.setUsername(rs.getString("abusername"));
				rep.setVictimname(rs.getString("victimname"));
				rep.setFrequency(rs.getString("frequency"));
				rep.setAbusetype(rs.getString("abusetype"));
				rep.setAwareof(rs.getString("awareof"));
				rep.setInvestigatorrisk(rs.getString("investigatorrisk"));
				rep.setDppchotline(rs.getString("dppchotline"));
				rep.setNarrativeform(rs.getString("narrativeform"));
				rep.setRisklevel(rs.getString("risklevel"));
				rep.setWitness(rs.getString("witness"));
				rep.setCaregiverrelationship(rs.getString("caregiverrelationship"));
				rep.setStatus(rs.getString("status"));
				
				reportlist.add(rep);
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
		return reportlist;
	}

	public int getAmountSupervisor(String roleid) throws Exception {
		int amout = 0;
		try {
			String sql = "select count(*) as total from report where groupid in (select groupid from role where PK_role =?)";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, roleid);
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				amout = rs.getInt("total");
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
		return amout;
	}

	public ArrayList<Report> superAdminListReport(Page page) throws Exception {
		ArrayList<Report> reportlist = new ArrayList<Report>();
		try {
			String sql = "select reportid,username,time from report";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setMaxRows(page.currentPage*page.getPageSize());//max row of display
			ResultSet rs = this.pstmt.executeQuery();
			rs.absolute((page.currentPage-1)*page.getPageSize());//set location to second record of each page
			//rs.relative(-1);//back 1 position
			while (rs.next()) {
				Report rep = new Report();
				rep.setReportid(rs.getInt("reportid"));
				//rep.setdiscript(rs.getString("discript"));
				rep.setUsername(rs.getString("username"));
				rep.setTime(rs.getDate("time"));
				reportlist.add(rep);
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
		return reportlist;
	}

	public int getAmountSuperAdmin() throws Exception {
		int amout = 0;
		try {
			String sql = "select count(*) as total from report";
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				amout = rs.getInt("total");
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
		return amout;
	}

	public int getAmountSupervisorWaitingList(String roleid) throws Exception{
		int amout = 0;
		try {
			String sql = "select count(*) as total from report where status ='initiated' and groupid in (select groupid from role where PK_role =?)";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, roleid);
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				amout = rs.getInt("total");
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
		return amout;
	}

	public ArrayList<Report> supervisorWaitingListReport(Page page, String roleid) throws Exception {
		ArrayList reportlist = new ArrayList<Report>();
		try {
			String sql = "select reportid,userid,username,time,abuserid,abusername,victimid," +
						"victimname,frequency,abusetype,awareof,investigatorrisk,dppchotline," +
						"narrativeform,risklevel,witness,caregiverrelationship,groupid,status from report " +
						"where status ='initiated' and groupid in (select groupid from role where PK_role =?)";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, roleid);
			this.pstmt.setMaxRows(page.currentPage*page.getPageSize());//max row of display
			ResultSet rs = this.pstmt.executeQuery();
			rs.absolute((page.currentPage-1)*page.getPageSize());//set location to second record of each page
			//rs.relative(-1);//back 1 position
			while (rs.next()) {
				Report rep = new Report();
				rep.setReportid(rs.getInt("reportid"));
				rep.setUsername(rs.getString("username"));
				rep.setTime(rs.getDate("time"));
				rep.setUsername(rs.getString("abusername"));
				rep.setVictimname(rs.getString("victimname"));
				rep.setFrequency(rs.getString("frequency"));
				rep.setAbusetype(rs.getString("abusetype"));
				rep.setAwareof(rs.getString("awareof"));
				rep.setInvestigatorrisk(rs.getString("investigatorrisk"));
				rep.setDppchotline(rs.getString("dppchotline"));
				rep.setNarrativeform(rs.getString("narrativeform"));
				rep.setRisklevel(rs.getString("risklevel"));
				rep.setWitness(rs.getString("witness"));
				rep.setCaregiverrelationship(rs.getString("caregiverrelationship"));
				rep.setStatus(rs.getString("status"));
				
				reportlist.add(rep);
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
		return reportlist;
	}

	public ArrayList<Report> supervisorFinishListReport(Page page, String roleid) throws Exception {
		ArrayList reportlist = new ArrayList<Report>();
		try {
			String sql = "select reportid,userid,username,time,abuserid,abusername,victimid," +
						"victimname,frequency,abusetype,awareof,investigatorrisk,dppchotline," +
						"narrativeform,risklevel,witness,caregiverrelationship,groupid,status from report " +
						"where status!='initiated' and status is not null and" +
						" groupid in (select groupid from role where PK_role =?)";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, roleid);
			this.pstmt.setMaxRows(page.currentPage*page.getPageSize());//max row of display
			ResultSet rs = this.pstmt.executeQuery();
			rs.absolute((page.currentPage-1)*page.getPageSize());//set location to second record of each page
			//rs.relative(-1);//back 1 position
			while (rs.next()) {
				Report rep = new Report();
				rep.setReportid(rs.getInt("reportid"));
				rep.setUsername(rs.getString("username"));
				rep.setTime(rs.getDate("time"));
				rep.setUsername(rs.getString("abusername"));
				rep.setVictimname(rs.getString("victimname"));
				rep.setFrequency(rs.getString("frequency"));
				rep.setAbusetype(rs.getString("abusetype"));
				rep.setAwareof(rs.getString("awareof"));
				rep.setInvestigatorrisk(rs.getString("investigatorrisk"));
				rep.setDppchotline(rs.getString("dppchotline"));
				rep.setNarrativeform(rs.getString("narrativeform"));
				rep.setRisklevel(rs.getString("risklevel"));
				rep.setWitness(rs.getString("witness"));
				rep.setCaregiverrelationship(rs.getString("caregiverrelationship"));
				rep.setStatus(rs.getString("status"));
				
				reportlist.add(rep);
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
		return reportlist;
	}

	public int getAmountSupervisorFinishList(String roleid) throws Exception {
		int amout = 0;
		try {
			String sql = "select count(*) as total from report where status!='initiated' and status is not null" +
					" and groupid in (select groupid from role where PK_role =?)";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, roleid);
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				amout = rs.getInt("total");
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
		return amout;
	}

}
