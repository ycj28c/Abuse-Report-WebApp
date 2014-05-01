package junit;

import static org.junit.Assert.*;

import mvc.factory.DAOFactory;
import mvc.vo.Decision;
import mvc.vo.Respond;

import org.junit.Test;

public class testDecisionDAOImpl {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	public void testgetDecisionById() throws Exception{
		 System.out.println("**testgetDecisionById**");
		 Decision testDecision = new Decision();
		 testDecision.setPkDecision(4);
		 int expResult = 55;
		 String resultstr = DAOFactory.getIDecisionDAOInstance().getDecisionById(testDecision).getReportid();
		 int result = Integer.parseInt(resultstr);
		 assertEquals(expResult, result);
	}
}
