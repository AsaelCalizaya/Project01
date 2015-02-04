package framework.pages.programs;

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
public class ProgramsPage {
	WebDriver driver;

	@FindBy(id="j_id_y:j_id_1a") 
	WebElement buttonAdd;
	
	@FindBy(id="j_id_y:programs:0:j_id_18") 
	WebElement buttonEdit;
	
	public ProgramsPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public NewProgramPage clickButtonNewProgram() {
		buttonAdd.click();
		return new NewProgramPage();
	}
	
	public ProgramDetailPage clickDetailProgram() {
		buttonEdit.click();
		return new ProgramDetailPage();
	}
}
