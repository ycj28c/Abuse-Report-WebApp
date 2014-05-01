package junit;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import mvc.factory.DAOFactory;
import mvc.vo.Report;
import mvc.vo.User;

import org.junit.Test;

public class testUserDaoImpl extends TestCase{

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	public void testfindLogin() throws Exception{
		 System.out.println("**testfindLogin**");
		 User testUser = new User();
		 testUser.setUserid("11111");
		 testUser.setPassword("11111");
		 boolean result= DAOFactory.getIUserDAOInstance().findLogin(testUser);
		 boolean expResult = true;
		 assertEquals(expResult, result);
	}
}
