package junit;

import static org.junit.Assert.*;

import mvc.factory.DAOFactory;
import mvc.vo.Investigation;
import mvc.vo.Report;

import org.junit.Test;

public class testInvestigationDAOImpl {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	public void testisPublicLogNumberExist() throws Exception{
		 System.out.println("**testisPublicLogNumberExist**");
		 Investigation testInvestigation = new Investigation();
		 testInvestigation.setPkInvestigation(1);
		 int expPLN = 44;
		 String resultstr = DAOFactory.getIInvestigationDAOInstance().isPublicLogNumberExist(testInvestigation).getPubliclognumber();
		 int result = Integer.parseInt(resultstr);
		 assertEquals(expPLN, result);
	}
}
