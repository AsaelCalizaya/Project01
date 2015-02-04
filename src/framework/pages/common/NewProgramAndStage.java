package framework.pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Asael Calizaya
 *
 */
public abstract class NewProgramAndStage {
	@FindBy(id = "form:inputName") 
	WebElement textBoxName;
	
	@FindBy(id = "form:inputTitle") 
	WebElement textBoxTitle;
	
	@FindBy(id = "form:inputDescription")
	WebElement textBoxDescription;
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		textBoxName.sendKeys(name);
	}
	
	/**
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		textBoxTitle.click();
		textBoxTitle.clear();
		textBoxTitle.sendKeys(title);
	}
	
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		textBoxDescription.sendKeys(description);
	}
}
