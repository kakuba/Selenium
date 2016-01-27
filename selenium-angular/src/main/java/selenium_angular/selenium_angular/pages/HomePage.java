package selenium_angular.selenium_angular.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium_angular.selenium_angular.AbstractPageObject;

public class HomePage extends AbstractPageObject{
	@FindBy(linkText="Book List")
	private WebElement bookList;
	@FindBy(linkText="Author List")
	private WebElement authorList;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver.navigate().to("http://localhost:9000/?btitle=adas#/main/welcome");
//		this.driver.get("http://demo-spring-petclinic.cfapps.io/");
	}
	
	public BooksListPage clickBookList() {
		bookList.click();
		return PageFactory.initElements(driver, BooksListPage.class);
	}
	
	public AuthorsListPage clickAuthorList() {
		authorList.click();
		return PageFactory.initElements(driver, AuthorsListPage.class);
	}
	
}
