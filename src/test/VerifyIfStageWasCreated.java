package test;

import org.junit.Assert;
import org.testng.annotations.Test;

import framework.pages.HomePage;
import framework.pages.stage.StagePage;
import framework.utils.DataProviderClass;

/**
 * Title: Verify that a new Stage can be created
 * @author Asael Calizaya
 *
 */
public class VerifyIfStageWasCreated {
	
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
}
