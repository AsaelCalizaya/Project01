package framework.pages.period;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.navigation.INavigation;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class PeriodPage implements INavigation{
	@FindBy(id = "j_id_t:programs:0:j_id_17") 
	WebElement editButton;
	
	public PeriodPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @return
	 */
	public PeriodDetailsPage clickEditButton() {
		editButton.click();
		return new PeriodDetailsPage();
	}
}