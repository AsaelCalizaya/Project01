package framework.pages.applicant;

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
	
	public NewApplicantPage setCI(String ci) {
		textBoxCI.sendKeys(ci);
		return this;
	}
	
	public NewApplicantPage setName(String name) {
		textBoxName.sendKeys(name);
		return this;
	}
	
	public NewApplicantPage setLastName(String lastName) {
		textBoxLastName.sendKeys(lastName);
		return this;
	}
	
	public NewApplicantPage setEMail(String eMail) {
		textBoxEMail.sendKeys(eMail);
		return this;
	}
	
	public NewApplicantPage setCellphone(String cellphone) {
		textBoxCellphone.sendKeys(cellphone);
		return this;
	}
	
	public PeriodDetailsPage clickSaveButton() {
		buttonSave.click();
		return new PeriodDetailsPage();
	}
	
	/**
	 * 
	 * @param ci
	 * @param name
	 * @param lastName
	 * @param eMail
	 * @param cellphone
	 * @return
	 */
	public PeriodDetailsPage createApplicant(String ci, String name, String lastName, String eMail,
											 String cellphone) {
		setCI(ci);
		setName(name);
		setLastName(lastName);
		setEMail(eMail);
		setCellphone(cellphone);
		return clickSaveButton();
	}
}
