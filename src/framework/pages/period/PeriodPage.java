package framework.pages.period;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.pages.navigation.Navigation;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class PeriodPage extends Navigation{
	
	@FindBy(id = "j_id_t:programs:0:j_id_17") 
	WebElement editButton;
	
	public PeriodDetailsPage clickEditButton(){
		editButton.click();
		return new PeriodDetailsPage();
	}
}