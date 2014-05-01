package junit;

import static org.junit.Assert.*;

import mvc.factory.DAOFactory;
import mvc.vo.Decision;
import mvc.vo.Disposition;

import org.junit.Test;

public class testDispositionDAOImpl {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	public void testgetDispositionById() throws Exception{
		 System.out.println("**testgetDispositionById**");
		 Disposition testDisposition = new Disposition();
		 testDisposition.setPkDisposition(1);
		 int expResult = 44;
		 String resultstr = DAOFactory.getIDispositionDAOInstance().getDispositionById(testDisposition).getReportid();
		 int result = Integer.parseInt(resultstr);
		 assertEquals(expResult, result);
	}
}
