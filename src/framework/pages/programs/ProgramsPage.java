package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.pages.navigation.Navigation;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class ProgramsPage extends Navigation {

	@FindBy(id="j_id_y:j_id_1a") 
	WebElement buttonAdd;
	
	@FindBy(id="j_id_y:programs:0:j_id_18") 
	WebElement buttonEdit;
	
	public NewProgramPage clickButtonNewProgram(){
		buttonAdd.click();
		return new NewProgramPage();
	}
	
	public ProgramDetailPage clickDetailProgram(){
		buttonEdit.click();
		return new ProgramDetailPage();
	}
}
