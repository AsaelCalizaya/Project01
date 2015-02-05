package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.navigation.INavigation;
import framework.pages.period.PeriodDetailPage;

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
	 * Click on period button
	 * @return: return this page
	 */
	public ProgramDetailPage clickPeriodButton() {
		buttonPeriod.click();
		return this;
	}
	
	/**
	 * Click on Add new period button
	 * @return: return this page
	 */
	public PeriodDetailPage clickAddNewPeriodButton() {
		buttonAddPeriod.click();
		return new PeriodDetailPage();
	}
	
	/**
	 * Get the table of all programs
	 * @return: table of all programs
	 */
	public String getNameProgram() {
		return programName.getText();
	}
}
