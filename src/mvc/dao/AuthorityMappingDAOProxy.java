package mvc.dao;

import java.util.ArrayList;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Authority;
import mvc.vo.User;

public class AuthorityMappingDAOProxy implements IAuthorityMappingDAO{
	private DatabaseConnection dbc = null;
	private AuthorityMappingDAOImpl dao = null;
	
	public AuthorityMappingDAOProxy(){
		try{
			this.dbc = new DatabaseConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.dao = new AuthorityMappingDAOImpl(this.dbc.getConnection());
	}
	public ArrayList<Authority> getAuthorityMenu(User user) throws Exception {
		ArrayList<Authority> authorityList = new ArrayList<Authority>();
		try{
			authorityList = this.dao.getAuthorityMenu(user);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return authorityList;
	}
}
