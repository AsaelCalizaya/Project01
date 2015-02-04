package framework.pages.stage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.common.NewProgramAndStage;
import framework.pages.navigation.INavigation;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class NewStagePage extends NewProgramAndStage implements INavigation {
	@FindBy(id = "form:j_id_1k")
	WebElement buttonSave;
	
	public NewStagePage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @return
	 */
	public StagePage saveButton() {
		buttonSave.click();
		return new StagePage();
	}
	
	/**
	 * 
	 * @param name
	 * @param title
	 * @param description
	 * @return
	 */
	public StagePage createNewStage(String name, String title,String description) {
		setDescription(description);
		setTitle(title);
		setName(name);
		saveButton();
		return new StagePage();
	}	
}
