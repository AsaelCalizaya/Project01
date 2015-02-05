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
	
	/**
	 * Click on programs link
	 * @return: programs page
	 */
	default ProgramsPage clickProgramLink() {
		driver.findElement(programLink).click();
		return new ProgramsPage();
	}
	
	/**
	 * Click on period link
	 * @return: period page
	 */
	default PeriodPage clickPeriodLink() {
		driver.findElement(periodLink).click();
		return new PeriodPage();
	}
	
	/**
	 * Click on applicant link
	 * @return: applicant page
	 */
	default ApplicantPage clickApplicantLink(){
		driver.findElement(applicantLink).click();
		return new ApplicantPage();
	}
	
	/**
	 * Click on stage link
	 * @return: stage page
	 */
	default StagePage clickStageLink() {
		driver.findElement(stageLink).click();
		return new StagePage();
	}
	
	/**
	 * Click on registered users link
	 * @return: registered users page
	 */
	default UsersPage clickUsersLink() {
		driver.findElement(usersLink).click();
		return new UsersPage();
	}
}