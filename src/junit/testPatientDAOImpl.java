package junit;

import static org.junit.Assert.*;

import mvc.factory.DAOFactory;
import mvc.vo.Investigation;
import mvc.vo.Patient;

import org.junit.Test;

public class testPatientDAOImpl {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	public void testgetinfo() throws Exception{
		 System.out.println("**testgetinfo**");
		 Patient testPatient = new Patient();
		 testPatient.setPkPatient(1);
		 String expResult = "111";
		 String resultstr = DAOFactory.getIPatientDAOInstance().getinfo(testPatient).getName();
		 int result = Integer.parseInt(resultstr);
		 assertEquals(expResult, result);
	}
}
