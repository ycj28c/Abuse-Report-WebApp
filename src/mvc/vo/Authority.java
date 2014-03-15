package mvc.vo;

public class Authority {
	private Integer pkAuthority;
	private String name;
	private String roleId;
	private String url;
	private String roleName;
	
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

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}