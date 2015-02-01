package test;

import org.junit.Assert;
import org.testng.annotations.Test;

import framework.pages.navigation.Navigation;
import framework.pages.stage.StagePage;
import framework.utils.DataProviderClass;

public class VerifyIfStageWasCreated {
	
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
