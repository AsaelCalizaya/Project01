package framework.pages.stage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.pages.navigation.Navigation;

public class NewStagePage extends Navigation {

	@FindBy(id = "form:inputName")
	WebElement textBoxName;
		
	@FindBy(id = "form:inputTitle")
	WebElement textBoxTittle;
		
	@FindBy(id = "form:inputDescription")
	WebElement textBoxDescription;
		
	@FindBy(id = "form:j_id_1k")
	WebElement buttonSave;

	
	public StagePage saveButton(){
		buttonSave.click();
		return new StagePage();
	}
	
	public NewStagePage setname(String name){		
		textBoxName.sendKeys(name);
		return this;
	}
	
	public NewStagePage settittle(String title){
		textBoxTittle.sendKeys(title);
		return this;
	}
	
	public NewStagePage setDescription(String description){
		textBoxDescription.sendKeys(description);
		return this;
	}
	
	public StagePage createNewStage(String name, String title,String description){
		setname(name);
		settittle(title);
		setDescription(description);
		saveButton();
		return new StagePage();
	}
	
}
