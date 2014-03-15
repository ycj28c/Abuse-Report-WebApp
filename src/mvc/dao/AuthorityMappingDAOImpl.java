package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import mvc.vo.Authority;
import mvc.vo.Patient;
import mvc.vo.Report;
import mvc.vo.User;

public class AuthorityMappingDAOImpl implements IAuthorityMappingDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public AuthorityMappingDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<Authority> getAuthorityMenu(User user) throws Exception {
		ArrayList<Authority> authorityList = new ArrayList<Authority>();
		try {
			String sql = "select PK_authority,name,role_id,role_name,url from authority where PK_authority in" +
					"(select authority_id from authority_mapping where user_id=?) order by role_id,PK_authority;";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, user.getUserid()); 
			ResultSet rs = this.pstmt.executeQuery();
			while (rs.next()) {
				Authority authority = new Authority();
				authority.setPkAuthority(rs.getInt("PK_authority"));
				authority.setRoleId(rs.getString("role_id"));
				authority.setRoleId(rs.getString("role_name"));
				authority.setName(rs.getString("name"));
				authority.setUrl(rs.getString("url"));
				authorityList.add(authority);

				//debug
				/*System.out.println("rs.getInt(PK_authority)"+rs.getInt("PK_authority"));
				System.out.println("rs.getString(group_id)"+rs.getString("group_id"));
				System.out.println("rs.getString(group_name)"+rs.getString("group_name"));
				System.out.println("rs.getString(name)"+rs.getString("name"));
				System.out.println("rsgetString(url):"+rs.getString("url"));*/
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();// ¹Ø±Õ²Ù×÷
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return authorityList;
	}

}
