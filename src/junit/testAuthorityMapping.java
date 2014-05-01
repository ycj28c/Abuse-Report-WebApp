package junit;

import static org.junit.Assert.*;

import mvc.factory.DAOFactory;
import mvc.vo.AuthorityMapping;
import mvc.vo.Disposition;

import org.junit.Test;

public class testAuthorityMapping {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	public void testverifyUser() throws Exception{
		 System.out.println("**testverifyUser**");
		 AuthorityMapping testAuthorityMapping = new AuthorityMapping();
		 testAuthorityMapping.setRoleId("8");
		 testAuthorityMapping.setUserId("11111");
		 boolean expResult = true;
		 boolean result = DAOFactory.getIAuthorityMappingDAOInstance().verifyUser(testAuthorityMapping);
		 assertEquals(expResult, result);
	}
}
