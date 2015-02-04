package framework.pages.period;

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
public class PeriodPage {
	WebDriver driver;
	
	@FindBy(id = "j_id_t:programs:0:j_id_17") 
	WebElement editButton;
	
	public PeriodPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public PeriodDetailsPage clickEditButton() {
		editButton.click();
		return new PeriodDetailsPage();
	}
}