package framework.pages.programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.period.PeriodDetailsPage;
import framework.utils.SeleniumDriverManager;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class ProgramDetailPage {
	WebDriver driver;
	
	@FindBy(id = "j_id_t:nameInput_display") 
	WebElement programName;
	
	@FindBy(xpath = "//a[contains(text(),'Periodos')]") 
	WebElement buttonPeriod;
	
	@FindBy(id = "j_id_t:programTabDetails:j_id_1l") 
	WebElement buttonAddPeriod;
	
	public ProgramDetailPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public ProgramDetailPage clickPeriodButton() {
		buttonPeriod.click();
		return this;
	}
	
	public PeriodDetailsPage clickAddNewPeriodButton() {
		buttonAddPeriod.click();
		return new PeriodDetailsPage();
	}
	
	public String getNameProgram() {
		return programName.getText();
	}
}
