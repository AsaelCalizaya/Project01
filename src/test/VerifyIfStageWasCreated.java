package test;

import org.junit.Assert;
import org.testng.annotations.Test;

import framework.pages.navigation.Navigation;
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
	 */
    @Test(dataProvider = "StagesDataXlsx", dataProviderClass = DataProviderClass.class)
    public void createNewStage(String name, String title, String description) {
	    Navigation navigation = new Navigation();  
	    StagePage period = navigation
	    	.clickStageLink()
	    	.clickAddNewStageButton()
	    	.createNewStage(name, title, description);
	    Assert.assertTrue(period.getAllStages().contains(name));
    }
}
