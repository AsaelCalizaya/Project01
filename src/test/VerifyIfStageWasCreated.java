package test;

import java.sql.SQLException;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.bd.ConnectionBD;
import framework.pages.HomePage;
import framework.pages.stage.StagePage;
import framework.utils.DataProviderClass;
import framework.utils.reporter.JyperionListener;

/**
 * Title: Verify that a new Stage can be created
 * @author Asael Calizaya
 *
 */
@Listeners(JyperionListener.class)
public class VerifyIfStageWasCreated {
	private ConnectionBD con = new ConnectionBD();
	
	/**
	 * Description: This test case is to verify that a new stage can be create when 
	 * "Aniadir" button in stage page is pressed
	 * @param name
	 * @param title
	 * @param description
	 * @throws InterruptedException 
	 */
    @Test(dataProvider = "StagesDataXlsx", dataProviderClass = DataProviderClass.class)
    public void createNewStage(String name, String title, String description) throws InterruptedException {
    	HomePage home = new HomePage();  
	    StagePage period = home
	    	.clickStageLink()
	    	.clickAddNewStageButton()
	    	.createNewStage(name, title, description);
	    Assert.assertTrue(period.getAllStages().contains(name));
    }
    
    /**
     * Delete all Stages of BD
     * @throws SQLException
     */
    @AfterClass
    public void deleteData() throws SQLException {
    	con.DeleteStage();
    }
}
