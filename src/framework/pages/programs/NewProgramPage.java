package framework.pages.programs;

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
public class NewProgramPage extends AbstractNewProgramAndStage implements INavigation {
	@FindBy(id = "form:j_id_18") 
	WebElement buttonSave;

	public NewProgramPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Click on save button
	 * @return: Program detail page
	 */
	public ProgramDetailPage clickSaveButton() {
		buttonSave.click();
		return new ProgramDetailPage();
	}

	/**
	 * Create new program setting the followings parameters
	 * @param name: Name program
	 * @param title: Title program
	 * @param description: Program description 
	 * @return: Return the program details
	 */
	public ProgramDetailPage createNewProgram(String name, String title, String description) {
		setName(name);
		setDescription(description);
		setTitle(title);
		return clickSaveButton();
	}
}
