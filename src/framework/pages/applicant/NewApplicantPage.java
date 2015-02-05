package framework.pages.applicant;

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
public class NewApplicantPage implements INavigation {	
	@FindBy(id = "j_id_t:ci") 
	WebElement textBoxCI;
	
	@FindBy(id = "j_id_t:name") 
	WebElement textBoxName;
	
	@FindBy(id = "j_id_t:lastName") 
	WebElement textBoxLastName;
	
	@FindBy(id = "j_id_t:email") 
	WebElement textBoxEMail;
	
	@FindBy(id = "j_id_t:cellphone") 
	WebElement textBoxCellphone;
	
	@FindBy(id = "j_id_t:j_id_1d") 
	WebElement buttonSave;
	
	public NewApplicantPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Set the CI of applicant
	 * @param ci: applicant CI
	 * @return: return this page
	 */
	public NewApplicantPage setCI(String ci) {
		textBoxCI.sendKeys(ci);
		return this;
	}
	
	public NewApplicantPage setName(String name) {
		textBoxName.sendKeys(name);
		return this;
	}
	
	/**
	 * Set LastName of applicant
	 * @param lastName: applicant lastName
	 * @return: return this page
	 */
	public NewApplicantPage setLastName(String lastName) {
		textBoxLastName.sendKeys(lastName);
		return this;
	}
	
	/**
	 * Set Email of applicant
	 * @param eMail: applicant Email
	 * @return: return this page
	 */
	public NewApplicantPage setEMail(String eMail) {
		textBoxEMail.sendKeys(eMail);
		return this;
	}
	
	/**
	 * Set the cellPhone of applicant
	 * @param cellphone: applicant cellPhone
	 * @return: return this page
	 */
	public NewApplicantPage setCellphone(String cellphone) {
		textBoxCellphone.sendKeys(cellphone);
		return this;
	}
	
	/**
	 * Click on save button
	 * @return: return period details page
	 */
	public PeriodDetailPage clickSaveButton() {
		buttonSave.click();
		return new PeriodDetailPage();
	}
	
	/**
	 * Create new applicant setting the following parameters 
	 * @param ci: applicant CI
	 * @param name: applicant Name
	 * @param lastName: applicant LastName
	 * @param eMail: applicant Email
	 * @param cellphone: applicant CellPhone
	 * @return: return period detail page
	 */
	public PeriodDetailPage createApplicant(String ci, String name, String lastName, String eMail,
											 String cellphone) {
		setCI(ci);
		setName(name);
		setLastName(lastName);
		setEMail(eMail);
		setCellphone(cellphone);
		return clickSaveButton();
	}
}
