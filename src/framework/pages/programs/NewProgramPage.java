package framework.pages.programs;

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
public class NewProgramPage extends NewProgramAndStage implements INavigation {
	@FindBy(id = "form:j_id_18") 
	WebElement buttonSave;
	
	public NewProgramPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @return
	 */
	public ProgramDetailPage clickSaveButton() {
		buttonSave.click();
		return new ProgramDetailPage();
	}
	
	/**
	 * 
	 * @param name
	 * @param title
	 * @param description
	 * @return
	 */
	public ProgramDetailPage createNewProgram(String name, String title, String description) {
		setDescription(description);
		setTitle(title);
		setName(name);
		return clickSaveButton();
	}
}
