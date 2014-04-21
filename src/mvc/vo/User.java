//vo中的属性与数据库表中的属性对应 
package mvc.vo;

public class User {
	private String userid;
	private String name;
	private String password;
	private String address;
	private String telephone;
	private String mandated;
	private String SSN;
	private String DOB;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getMandated() {
		return mandated;
	}

	public void setMandated(String mandated) {
		this.mandated = mandated;
	}
	
	public String getSSN() {
		return SSN;
	}

	public void setSSN(String SSN) {
		this.SSN = SSN;
	}
	
	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}
}