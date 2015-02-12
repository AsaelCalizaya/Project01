package test;

import java.io.IOException;
import java.sql.SQLException;

import jxl.read.biff.BiffException;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.bd.ConnectionBD;
import framework.bd.ManageProgramsSuitSetup;
import framework.pages.HomePage;
import framework.pages.period.PeriodDetailPage;
import framework.utils.DataProviderClass;
import framework.utils.reporter.JyperionListener;

/**
 * Title: Verify that a new period can be created in a program
 * @author Asael Calizaya
 *
 */
@Listeners(JyperionListener.class)
public class VerifyIfPeriodWasCreated {
	private ConnectionBD con = new ConnectionBD();
	
	/**
	 * Create precondition to create periods
	 * @throws BiffException 
	 * @throws IOException 
	 * @throws SQLException
	 */
	@BeforeMethod
	public void createProgram() throws BiffException, SQLException, IOException {
		ManageProgramsSuitSetup programCreation = new ManageProgramsSuitSetup();
		programCreation.CreateProgramsBD();
	}
	
	/**
	 * Description:This test case is to verify that a period can be created to a program
	 * @param name
	 * @param startDate
	 */
	@Test(dataProvider = "PeriodDataXls", dataProviderClass = DataProviderClass.class)
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
	@AfterMethod
	public void deleteData() throws SQLException {
		con.DeletePeriod();
		con.DeleteProgram();
	}
}