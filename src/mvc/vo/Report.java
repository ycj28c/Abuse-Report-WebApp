package mvc.vo;

import java.util.Date;

public class Report {
	private int reportid;
	private String discript;
	private String name;
	private Date time;
	private String userid;
	private String groupid;

	public int getreportid() {
		return reportid;
	}

	public void setreportid(int reportid) {
		this.reportid = reportid;
	}

	public String getdiscript() {
		return discript;
	}

	public void setdiscript(String discript) {
		this.discript = discript;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date gettime() {
		return time;
	}

	public void settime(Date time) {
		this.time = time;
	}

	public String getuserid() {
		return userid;
	}
	public void setuserid(String userid) {
		this.userid = userid;
		
	}
	
	public String getGroupId() {
		return groupid;
	}
	public void setGroupId(String groupid) {
		this.groupid = groupid;
		
	}
}
