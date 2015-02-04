package framework.pages.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
public interface INavigation {	
	WebDriver driver = SeleniumDriverManager.getManager().getDriver();	
	
	By programLink = By.linkText("Programas");
	By periodLink = By.linkText("Periodos");
	By applicantLink = By.linkText("Postulantes");
	By stageLink = By.linkText("Etapas");
	By usersLink = By.linkText("Usuarios de Sistema Registrados");
	
	default ProgramsPage clickProgramLink() {
		driver.findElement(programLink).click();
		return new ProgramsPage();
	}
	
	default PeriodPage clickPeriodLink() {
		driver.findElement(periodLink).click();
		return new PeriodPage();
	}
	
	default ApplicantPage clickApplicantLink(){
		driver.findElement(applicantLink).click();
		return new ApplicantPage();
	}
	
	default StagePage clickStageLink() {
		driver.findElement(stageLink).click();
		return new StagePage();
	}
	
	default UsersPage clickUsersLink() {
		driver.findElement(usersLink).click();
		return new UsersPage();
	}
}