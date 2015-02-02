package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.pages.navigation.Navigation;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class NewProgramPage extends Navigation {
	
	@FindBy(id = "form:inputName") 
	WebElement textBoxName;
	
	@FindBy(id = "form:inputTitle") 
	WebElement textBoxTitle;
	
	@FindBy(id = "form:inputDescription")
	WebElement textBoxDescription;
	
	@FindBy(id = "form:j_id_18") 
	WebElement buttonSave;
	
	public NewProgramPage setName(String name){
		textBoxName.sendKeys(name);
		return this;
	}
	
	public NewProgramPage setTitle(String title){
		textBoxTitle.click();
		textBoxTitle.clear();
		textBoxTitle.sendKeys(title);
		return this;
	}
	
	public NewProgramPage setDescription(String description){
		textBoxDescription.sendKeys(description);
		return this;
	}
	
	public ProgramDetailPage clickSaveButton(){
		buttonSave.click();
		return new ProgramDetailPage();
	}
	
	public ProgramDetailPage createNewProgram(String name, String title, String description){
		setName(name);
		setTitle(title);
		setDescription(description);
		return clickSaveButton();
	}
}
