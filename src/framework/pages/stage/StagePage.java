package framework.pages.stage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.utils.SeleniumDriverManager;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class StagePage {
	WebDriver driver;
	
	@FindBy(id="j_id_t:j_id_10")
	WebElement newStageButton;
	
	@FindBy(id="j_id_t:stages_data")
	WebElement tableStage;

	public StagePage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public NewStagePage clickAddNewStageButton() {
		newStageButton.click();
		return new NewStagePage();
	}

	public String getAllStages() {
		return tableStage.getText();
	}
	
}
