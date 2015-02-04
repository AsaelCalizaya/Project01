package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.navigation.INavigation;
import framework.pages.period.PeriodDetailsPage;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class ProgramDetailPage implements INavigation{
	@FindBy(id = "j_id_t:nameInput_display") 
	WebElement programName;
	
	@FindBy(xpath = "//a[contains(text(),'Periodos')]") 
	WebElement buttonPeriod;
	
	@FindBy(id = "j_id_t:programTabDetails:j_id_1l") 
	WebElement buttonAddPeriod;
	
	public ProgramDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @return
	 */
	public ProgramDetailPage clickPeriodButton() {
		buttonPeriod.click();
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public PeriodDetailsPage clickAddNewPeriodButton() {
		buttonAddPeriod.click();
		return new PeriodDetailsPage();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNameProgram() {
		return programName.getText();
	}
}
