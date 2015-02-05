package framework.pages.stage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.common.AbstractNewProgramAndStage;
import framework.pages.navigation.INavigation;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class NewStagePage extends AbstractNewProgramAndStage implements INavigation {
	@FindBy(id = "form:j_id_1k")
	WebElement buttonSave;
	
	public NewStagePage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Click on save button
	 * @return: a new Stage Page
	 */
	public StagePage saveButton() {
		buttonSave.click();
		return new StagePage();
	}
	
	/**
	 * Create a new stage with the following parameters
	 * @param name: stage name
	 * @param title: stage title
	 * @param description: stage description
	 * @return: the new stage page
	 */
	public StagePage createNewStage(String name, String title,String description) {
		setName(name);
		setDescription(description);
		setTitle(title);
		saveButton();
		return new StagePage();
	}	
}
