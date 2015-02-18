package test.creations;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import framework.bd.ConnectionBD;
import framework.pages.HomePage;
import framework.utils.DataProviderClass;

/**
 * Title: Verify if that a new program can be created
 * @author Asael Calizaya
 *
 */
public class VerifyIfProgramWasCreated {
	private ConnectionBD con = new ConnectionBD();

	/**
	 * Description: This test case is to verify that a new program can be created
	 * when a "Aniadir" button in programs page is pressed
	 * @param name
	 * @param title
	 * @param description
	 * @throws InterruptedException
	 * @throws SQLException 
	 */
	@Test(dataProvider = "ProgramsDataXls", dataProviderClass = DataProviderClass.class, groups = {"BVT", "Acceptance"})
	public void createProgram(String name, String title, String description) throws SQLException {    	
		HomePage home = new HomePage();    	
		home
			.clickProgramLink()
			.clickButtonNewProgram()
			.createNewProgram(name, title, description);
		Assert.assertEquals(con.getProgramName(name),name);
	}

	/**
	 * Delete all programs of BD
	 * @throws SQLException
	 */
	@AfterClass
	public void deleteData() throws SQLException {
		con.DeleteProgram();
	}
}
