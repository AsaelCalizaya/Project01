package test;

import java.sql.SQLException;

import org.junit.Assert;
import org.testng.annotations.*;

import framework.bd.ConnectionBD;
import framework.pages.HomePage;
import framework.pages.period.PeriodDetailPage;
import framework.utils.DataProviderClass;

/**
 * Title: Verify that a new period can be created in a program
 * @author Asael Calizaya
 *
 */
public class VerifyIfPeriodWasCreated {
	private ConnectionBD con = new ConnectionBD();
	
	/**
	 * Create precondition to create periods
	 * @throws SQLException
	 */
	@BeforeClass
	public void createProgram() throws SQLException {
		con.CreateProgram("1", "program1", "program1", "description1");
	}
	
	/**
	 * Description:This test case is to verify that a period can be created to a program
	 * @param name
	 * @param startDate
	 */
	@Test(dataProvider = "PeriodDataXlsx",dataProviderClass = DataProviderClass.class)
	public void createPeriod(String name, String startDate) {
		HomePage home = new HomePage();
		PeriodDetailPage detailPage = home
				.clickProgramLink()
				.clickDetailProgram()
				.clickPeriodButton()
				.clickAddNewPeriodButton()
				.setPeriodName(name)
				.setStartPeriodDate(startDate);
		Assert.assertTrue(detailPage.getPeriodName().contains(name));
	}
	
	/**
	 * Delete all Periods on BD
	 * @throws SQLException
	 */
	@AfterClass
	public void deleteData() throws SQLException {
		con.DeletePeriod();
		con.DeleteProgram();
	}
}