package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.navigation.INavigation;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class ProgramsPage implements INavigation{
	@FindBy(id="j_id_y:j_id_1a") 
	WebElement buttonAdd;
	
	@FindBy(id="j_id_y:programs:0:j_id_18") 
	WebElement buttonEdit;
	
	public ProgramsPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Click on New program button
	 * @return: The new programs page
	 */
	public NewProgramPage clickButtonNewProgram() {
		buttonAdd.click();
		return new NewProgramPage();
	}
	
	/**
	 * Click on Detail program button
	 * @return: a new Program detail page
	 */
	public ProgramDetailPage clickDetailProgram() {
		buttonEdit.click();
		return new ProgramDetailPage();
	}
}
