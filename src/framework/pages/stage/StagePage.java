package framework.pages.stage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.pages.navigation.Navigation;

public class StagePage extends Navigation{
	
	@FindBy(id="j_id_t:j_id_10")
	WebElement newStageButton;
	
	@FindBy(id="j_id_t:stages_data")
	WebElement tableStage;

	public NewStagePage clickAddNewStageButton(){
		newStageButton.click();
		return new NewStagePage();
	}

	public String getAllStages(){
		return tableStage.getText();
	}
	
}
