package selenium_angular.selenium_angular.dialogs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium_angular.selenium_angular.AbstractPageObject;

public class EditBookDialog extends AbstractPageObject {
	private WebElement saveEditedBook;
	private WebElement btitle;
	
	public EditBookDialog(WebDriver driver) {
		super(driver);
	}
	
	public void editBookTitle(String btitle) {
		this.btitle.clear();
		this.btitle.sendKeys(btitle);
		saveEditedBook.click();
	}
	
}
