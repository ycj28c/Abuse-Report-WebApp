package junit;

import static org.junit.Assert.*;

import mvc.factory.DAOFactory;
import mvc.vo.Investigation;
import mvc.vo.Respond;

import org.junit.Test;

public class testRespondDAOImpl {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	public void testgetRespondById() throws Exception{
		 System.out.println("**testgetRespondById**");
		 Respond testRespond = new Respond();
		 testRespond.setPkRespond(1);
		 int expResult = 11;
		 String resultstr = DAOFactory.getIRespondDAOInstance().getRespondById(testRespond).getReportid();
		 int result = Integer.parseInt(resultstr);
		 assertEquals(expResult, result);
	}
}
