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
public class PeriodDetailPage implements INavigation{	
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
	
	public PeriodDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Set the period name
	 * @param name: Period name
	 * @return: return this page
	 */
	public PeriodDetailPage setPeriodName(String name) {
		labelName.click();
		textBoxName.sendKeys(name);
		buttonSaveName.click();
		return this;
	}

	/**
	 * Set start date to period
	 * @param date: initial date to a period
	 * @return: returns this page
	 */
	public PeriodDetailPage setStartPeriodDate(String date) {
		labelDate.click();
		textBoxDate.sendKeys(date);
		buttonSaveDate.click();
		return this;
	}
	
	/**
	 * Click on applicant button
	 * @return: returns this page
	 */
	public PeriodDetailPage clickApplicantButton() { 
		applicantButton.click();
		return this;
	}
	
	/**
	 * Click on New applicant button
	 * @return: the new applicant page
	 */
	public NewApplicantPage clickNewApplicantButton() {
		newApplicantButton.click();
		return new NewApplicantPage();
	}
	
	/**
	 * Get the period name
	 * @return: the name of period
	 */
	public String getPeriodName() {
		return labelName.getText();
	}
	
	/**
	 * Get the table of applicants
	 * @return: An array of all applicants 
	 */
	public String getAllAplicants() {
		return applicantTable.getText();
	}
}