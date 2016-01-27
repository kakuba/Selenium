package selenium_angular.selenium_angular.dialogs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import selenium_angular.selenium_angular.AbstractPageObject;

public class NewBookDialog extends AbstractPageObject {
	private WebElement addAuthor;
	private WebElement saveBook;
	private WebElement btitle;
	
	public NewBookDialog(WebDriver driver) {
		super(driver);
	}

	public NewAuthorDialog clickAddAuthor() {
		addAuthor.click();
		return PageFactory.initElements(driver, NewAuthorDialog.class);
	}
	
	public WebElement getSaveBook() {
		return saveBook;
	}
	
	public NewBookDialog setBookTitle(String btitle) {
		this.btitle.sendKeys(btitle);
		return this;
	}
	
	public void clickSaveBook() {
		saveBook.click();
	}
	
	public void createAuthor(String fname, String lname) {
		clickAddAuthor().setFisrtName(fname).setLastName(lname).clickSaveAuthor();
	}
}
