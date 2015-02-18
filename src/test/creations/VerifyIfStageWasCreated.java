package test.creations;

import java.sql.SQLException;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import framework.bd.ConnectionBD;
import framework.pages.HomePage;
import framework.pages.stage.StagePage;
import framework.utils.DataProviderClass;

/**
 * Title: Verify that a new Stage can be created
 * @author Asael Calizaya
 *
 */
public class VerifyIfStageWasCreated {
	private ConnectionBD con = new ConnectionBD();
	
	/**
	 * Description: This test case is to verify that a new stage can be create when 
	 * "Aniadir" button in stage page is pressed
	 * @param name
	 * @param title
	 * @param description
	 * @throws InterruptedException 
	 * @throws SQLException 
	 */
    @Test(dataProvider = "StagesDataXls", dataProviderClass = DataProviderClass.class, groups = {"BVT", "Acceptance"})
    public void createNewStage(String name, String title, String description) throws SQLException {
    	HomePage home = new HomePage();  
	    StagePage stage = home
	    	.clickStageLink()
	    	.clickAddNewStageButton()
	    	.createNewStage(name, title, description);
	    Assert.assertTrue(stage.getAllStages().contains(name));
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
