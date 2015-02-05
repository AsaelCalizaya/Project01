package framework.pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Asael Calizaya
 *
 */
public abstract class AbstractNewProgramAndStage {
	@FindBy(id = "form:inputName") 
	WebElement textBoxName;
	
	@FindBy(id = "form:inputTitle") 
	WebElement textBoxTitle;
	
	@FindBy(id = "form:inputDescription")
	WebElement textBoxDescription;
	
	/**
	 * Set program or stage name
	 * @param name: Program or stage name
	 */
	public void setName(String name) {
		textBoxName.sendKeys(name);
	}
	
	/**
	 * Set program or stage title
	 * @param title: program or stage title
	 */
	public void setTitle(String title) {
		textBoxTitle.click();
		textBoxTitle.clear();
		textBoxTitle.sendKeys(title);
	}
	
	/**
	 * Set program or stage description
	 * @param description: program or stage description
	 */
	public void setDescription(String description) {
		textBoxDescription.sendKeys(description);
	}
}
