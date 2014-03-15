package mvc.vo;

public class AuthorityMapping {
	private Integer pkAuthorityMapping;
	private String groupId;
	private String authorityId;
	private String userId;

	public Integer getPkAuthorityMapping() {
		return this.pkAuthorityMapping;
	}

	public void setPkAuthorityMapping(Integer pkAuthorityMapping) {
		this.pkAuthorityMapping = pkAuthorityMapping;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}