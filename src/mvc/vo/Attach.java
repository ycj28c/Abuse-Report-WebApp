package mvc.vo;

public class Attach {
	private int id;
	private String newname;
	private String oldname;
	private String path;
	private String userid;
	private int reportid;

	public int getReportid() {
		return this.reportid;
	}

	public void setReportid(int reportid) {
		this.reportid = reportid;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOldName() {
		return this.oldname;
	}

	public void setOldName(String name) {
		this.oldname = name;
	}

	public String getNewName() {
		return this.newname;
	}

	public void setNewName(String name) {
		this.newname = name;
	}

	public String getUserId() {
		return this.userid;
	}
	public void setUserId(String userid) {
		this.userid = userid;
		
	}
	
	public String getPath() {
		return this.path;
	}
	public void setPath(String path) {
		this.path = path;
		
	}
}
