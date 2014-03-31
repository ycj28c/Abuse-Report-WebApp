package mvc.vo;

public class Disposition {

	private Integer pkDisposition;
	private String reportid;
	private String investigationid;
	private String description;
	private String attacholdname;
	private String attachnewname;
	private String attachpath;

	public Integer getPkDisposition() {
		return this.pkDisposition;
	}

	public void setPkDisposition(Integer pkDisposition) {
		this.pkDisposition = pkDisposition;
	}

	public String getReportid() {
		return this.reportid;
	}

	public void setReportid(String reportid) {
		this.reportid = reportid;
	}

	public String getInvestigationid() {
		return this.investigationid;
	}

	public void setInvestigationid(String investigationid) {
		this.investigationid = investigationid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttacholdname() {
		return this.attacholdname;
	}

	public void setAttacholdname(String attacholdname) {
		this.attacholdname = attacholdname;
	}

	public String getAttachnewname() {
		return this.attachnewname;
	}

	public void setAttachnewname(String attachnewname) {
		this.attachnewname = attachnewname;
	}

	public String getAttachpath() {
		return this.attachpath;
	}

	public void setAttachpath(String attachpath) {
		this.attachpath = attachpath;
	}

}