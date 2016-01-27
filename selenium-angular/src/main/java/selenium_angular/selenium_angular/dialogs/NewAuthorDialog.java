package selenium_angular.selenium_angular.dialogs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium_angular.selenium_angular.AbstractPageObject;

public class NewAuthorDialog extends AbstractPageObject {
	private WebElement saveAuthor;
	private WebElement fname;
	private WebElement lname;
	
	public NewAuthorDialog(WebDriver driver) {
		super(driver);
	}
	
	public NewAuthorDialog setFisrtName(String fname) {
		this.fname.sendKeys(fname);
		return this;
	}
	
	public NewAuthorDialog setLastName(String lname) {
		this.lname.sendKeys(lname);
		return this;
	}
	
	public WebElement getSaveAuthor() {
		return saveAuthor;
	}
	
	public void clickSaveAuthor() {
		saveAuthor.click();
	}
}
