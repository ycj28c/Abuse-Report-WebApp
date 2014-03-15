package mvc.dao;

import java.util.ArrayList;

import mvc.vo.Authority;
import mvc.vo.User;

public interface IAuthorityMappingDAO {
	public ArrayList<Authority> getAuthorityMenu(User user) throws Exception;
}
