package framework.pages.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.applicant.ApplicantPage;
import framework.pages.period.PeriodPage;
import framework.pages.programs.ProgramsPage;
import framework.pages.stage.StagePage;
import framework.pages.users.UsersPage;
import framework.utils.SeleniumDriverManager;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class Navigation {	
	WebDriver driver;
	
	@FindBy(linkText = "Programas") 
	WebElement programLink;
	
	@FindBy(linkText = "Periodos") 
	WebElement periodLink;
	
	@FindBy(linkText = "Postulantes") 
	WebElement applicantLink;
	
	@FindBy(linkText = "Etapas") 
	WebElement stageLink;
	
	@FindBy(linkText = "Usuarios de Sistema Registrados") 
	WebElement clickUsers;
	
	public Navigation() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public ProgramsPage clickProgramLink() {
		programLink.click();
		return new ProgramsPage();
	}
	
	public PeriodPage clickPeriodLink() {
		periodLink.click();
		return new PeriodPage();
	}
	
	public ApplicantPage clickApplicantLink(){
		applicantLink.click();
		return new ApplicantPage();
	}
	
	public StagePage clickStageLink() {
		stageLink.click();
		return new StagePage();
	}
	
	public UsersPage clickUsersLink() {
		clickUsers.click();
		return new UsersPage();
	}
}
