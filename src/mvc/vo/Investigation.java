package mvc.vo;

public class Investigation {

	private Integer pkInvestigation;
	private String publiclognumber;
	private String reportid;
	private String status;
	private String dispositionid;
	private String respondid;
	private String decisionid;

	public Integer getPkInvestigation() {
		return this.pkInvestigation;
	}

	public void setPkInvestigation(Integer pkInvestigation) {
		this.pkInvestigation = pkInvestigation;
	}

	public String getPubliclognumber() {
		return this.publiclognumber;
	}

	public void setPubliclognumber(String publiclognumber) {
		this.publiclognumber = publiclognumber;
	}

	public String getReportid() {
		return this.reportid;
	}

	public void setReportid(String reportid) {
		this.reportid = reportid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDispositionid() {
		return this.dispositionid;
	}

	public void setDispositionid(String dispositionid) {
		this.dispositionid = dispositionid;
	}

	public String getRespondid() {
		return this.respondid;
	}

	public void setRespondid(String respondid) {
		this.respondid = respondid;
	}

	public String getDecisionid() {
		return this.decisionid;
	}

	public void setDecisionid(String decisionid) {
		this.decisionid = decisionid;
	}

}