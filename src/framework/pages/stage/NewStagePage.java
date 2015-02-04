package framework.pages.stage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.common.NewProgramAndStage;
import framework.utils.SeleniumDriverManager;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class NewStagePage extends NewProgramAndStage {
	@FindBy(id = "form:j_id_1k")
	WebElement buttonSave;
	
	WebDriver driver;
	
	public NewStagePage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public StagePage saveButton() {
		buttonSave.click();
		return new StagePage();
	}
	
	public StagePage createNewStage(String name, String title,String description) {
		setDescription(description);
		setTitle(title);
		setName(name);
		saveButton();
		return new StagePage();
	}
	
}
