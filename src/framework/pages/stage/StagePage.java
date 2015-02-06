package framework.pages.stage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.navigation.INavigation;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class StagePage implements INavigation{
	@FindBy(id="j_id_t:j_id_10")
	WebElement newStageButton;
	
	@FindBy(id="j_id_t:stages_data")
	WebElement tableStage;

	public StagePage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Click on add new stage button
	 * @return: a New stage page to create stages
	 */
	public NewStagePage clickAddNewStageButton() {
		newStageButton.click();
		return new NewStagePage();
	}

	/**
	 * Get a array with all stages
	 * @return: Get string with all information about stages
	 */
	public String getAllStages() {
		return tableStage.getText();
	}	
}
