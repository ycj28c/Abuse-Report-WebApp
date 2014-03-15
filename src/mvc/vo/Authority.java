package mvc.vo;

public class Authority {
	private Integer pkAuthority;
	private String name;
	private String groupId;
	private String url;
	private String groupName;
	
	public Integer getPkAuthority() {
		return this.pkAuthority;
	}

	public void setPkAuthority(Integer pkAuthority) {
		this.pkAuthority = pkAuthority;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}