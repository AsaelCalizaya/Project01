package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.pages.navigation.Navigation;
import framework.pages.period.PeriodDetailsPage;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class ProgramDetailPage extends Navigation{
	
	@FindBy(id = "j_id_t:nameInput_display") 
	WebElement programName;
	
	@FindBy(xpath = "//a[contains(text(),'Periodos')]") 
	WebElement buttonPeriod;
	
	@FindBy(id = "j_id_t:programTabDetails:j_id_1l") 
	WebElement buttonAddPeriod;
	
	public ProgramDetailPage clickPeriodButton(){
		buttonPeriod.click();
		return this;
	}
	
	public PeriodDetailsPage clickAddNewPeriodButton(){
		buttonAddPeriod.click();
		return new PeriodDetailsPage();
	}
	
	public String getNameProgram(){
		return programName.getText();
	}
}
