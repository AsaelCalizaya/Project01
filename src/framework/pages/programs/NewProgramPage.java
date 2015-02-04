package framework.pages.programs;

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
public class NewProgramPage extends NewProgramAndStage {
	WebDriver driver;
	
	@FindBy(id = "form:j_id_18") 
	WebElement buttonSave;
	
	public NewProgramPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public ProgramDetailPage clickSaveButton() {
		buttonSave.click();
		return new ProgramDetailPage();
	}
	
	public ProgramDetailPage createNewProgram(String name, String title, String description) {
		setDescription(description);
		setTitle(title);
		setName(name);
		return clickSaveButton();
	}
}
