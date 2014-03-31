package mvc.vo;

public class Respond {

	private Integer pkRespond;
	private String reportid;
	private String investigationid;
	private String content;

	public Integer getPkRespond() {
		return this.pkRespond;
	}

	public void setPkRespond(Integer pkRespond) {
		this.pkRespond = pkRespond;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}