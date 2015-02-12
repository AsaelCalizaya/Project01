package test;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.bd.ConnectionBD;
import framework.pages.HomePage;
import framework.pages.programs.ProgramDetailPage;
import framework.utils.DataProviderClass;
import framework.utils.reporter.JyperionListener;

/**
 * Title: Verify if that a new program can be created
 * @author Asael Calizaya
 *
 */
@Listeners(JyperionListener.class)
public class VerifyIfProgramWasCreated {
	private ConnectionBD con = new ConnectionBD();
	
	/**
	 * Description: This test case is to verify that a new program can be created
	 * when a "Aniadir" button in programs page is pressed
	 * @param name
	 * @param title
	 * @param description
	 * @throws InterruptedException
	 */
    @Test(dataProvider = "ProgramsDataXlsx", dataProviderClass = DataProviderClass.class)
    public void createProgram(String name, String title, String description) throws InterruptedException {    	
    	HomePage home = new HomePage();    	
    	ProgramDetailPage detailProgram = home
    			.clickProgramLink()
	    		.clickButtonNewProgram()
	    		.createNewProgram(name, title, description);
    	Assert.assertTrue(detailProgram.getNameProgram().contains(name));
    }
    
    /**
     * Delete all programs of BD
     * @throws SQLException
     */
    @AfterMethod
    public void deleteData() throws SQLException {
    	con.DeleteProgram();
    }
}
