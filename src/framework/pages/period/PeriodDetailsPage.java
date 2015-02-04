package framework.pages.period;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.applicant.NewApplicantPage;
import framework.pages.navigation.INavigation;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class PeriodDetailsPage implements INavigation{	
	@FindBy(id = "j_id_t:nameInput_display") 
	WebElement labelName;
	
	@FindBy(id = "j_id_t:j_id_17") 
	WebElement textBoxName;
	
	@FindBy(xpath = "//button[@type='button']") 
	WebElement buttonSaveName;
	
	@FindBy(xpath = "(//button[@type='button'])[3]") 
	WebElement buttonSaveDate;
	
	@FindBy(id = "j_id_t:inputInitialDate_display") 
	WebElement labelDate;
	
	@FindBy(id = "j_id_t:j_id_1b_input") 
	WebElement textBoxDate;
	
	@FindBy(xpath = "//a[contains(text(),'Postulantes')]") 
	WebElement applicantButton;
	
	@FindBy(id = "j_id_t:applcantStageTabs:j_id_1o")
	WebElement newApplicantButton;
	
	@FindBy(id = "j_id_t:applcantStageTabs:applicantList_data") 
	WebElement applicantTable;
	
	public PeriodDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public PeriodDetailsPage setPeriodName(String name) {
		labelName.click();
		textBoxName.sendKeys(name);
		buttonSaveName.click();
		return this;
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public PeriodDetailsPage setStartPeriodDate(String date) {
		labelDate.click();
		textBoxDate.sendKeys(date);
		buttonSaveDate.click();
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public PeriodDetailsPage clickApplicantButton() { 
		applicantButton.click();
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public NewApplicantPage clickNewApplicantButton() {
		newApplicantButton.click();
		return new NewApplicantPage();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPeriodName() {
		return labelName.getText();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAllAplicants() {
		return applicantTable.getText();
	}
}