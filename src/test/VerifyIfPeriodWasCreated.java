package test;

import java.io.IOException;
import java.sql.SQLException;

import jxl.read.biff.BiffException;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.bd.ConnectionBD;
import framework.bd.ManageProgramsSuitSetup;
import framework.pages.HomePage;
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
	@BeforeClass
	public void createProgram() throws BiffException, SQLException, IOException {
		ManageProgramsSuitSetup programCreation = new ManageProgramsSuitSetup();
		programCreation.CreateProgramsBD();
	}
	
	/**
	 * Description:This test case is to verify that a period can be created to a program
	 * @param name
	 * @param startDate
	 * @throws SQLException 
	 */
	@Test(dataProvider = "PeriodDataXls", dataProviderClass = DataProviderClass.class)
	public void createPeriod(String name, String startDate) throws SQLException {
		HomePage home = new HomePage();
		home
			.clickProgramLink()
			.clickDetailProgram()
			.clickPeriodButton()
			.clickAddNewPeriodButton()
			.setPeriodName(name)
			.setStartPeriodDate(startDate);
		Assert.assertEquals(con.getPeriodName(name), name);
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