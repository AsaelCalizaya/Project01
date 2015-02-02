package test;

import org.testng.Assert;
import org.testng.annotations.*;

import framework.pages.navigation.Navigation;
import framework.pages.programs.ProgramDetailPage;
import framework.utils.DataProviderClass;

/**
 * Title: Verify if that a new program can be created
 * @author Asael Calizaya
 *
 */
public class VerifyIfProgramWasCreated {
	
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
    	Navigation navigation = new Navigation();    	
    	ProgramDetailPage detailProgram = navigation
    		.clickProgramLink()
    		.clickButtonNewProgram()
    		.createNewProgram(name, title, description);
    	Assert.assertTrue(detailProgram.getNameProgram().contains(name));
    }
}
