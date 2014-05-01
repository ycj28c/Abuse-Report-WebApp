package junit;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import mvc.dao.ReportDAOImpl;
import mvc.factory.DAOFactory;
import mvc.vo.Report;

import org.junit.Test;

public class testReportDaoImpl extends TestCase{

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	public void testreadReportById() throws Exception{
		 System.out.println("**testreadReportById**");
		 Report testReport = new Report();
		 testReport.setAbuserid(2);
		 int expUserid = 11111;
		 String resultstr = DAOFactory.getIReportDAOInstance().readReportById(testReport).getUserid();
		 int result = Integer.parseInt(resultstr);
		 assertEquals(expUserid, result);
	}
}
