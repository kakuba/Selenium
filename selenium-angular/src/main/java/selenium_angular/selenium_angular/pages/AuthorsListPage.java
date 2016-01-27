package selenium_angular.selenium_angular.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium_angular.selenium_angular.AbstractPageObject;

public class AuthorsListPage extends AbstractPageObject {
	private WebElement authorSearchButton;
	private WebElement authorSearchText;
	private WebElement authorTable;
	private List<WebElement> rowList;
	private List<String> authorFname = new ArrayList<>();
	private List<String> authorLname = new ArrayList<>();
	private int numberOfFoundedAuthors;
	
	
	public AuthorsListPage(WebDriver driver) {
		super(driver);
	}
	
	public List<WebElement> getRowList() {
		return rowList;
	}


	public AuthorsListPage clickSearch() {
		authorSearchButton.click();
		return this;
	}
	
	public AuthorsListPage setAuthorSearchText(String authorSearchText) {
		this.authorSearchText.sendKeys(authorSearchText);
		return this;
	}
	
	public WebElement getAuthorTable() {
		return authorTable;
	}
	
	public String getAuthorFirstName(int bookIndex) {
		return authorFname.get(bookIndex);
	}
	
	public String getAuthorLastName(int bookIndex) {
		return authorLname.get(bookIndex);
	}
	
	public int getNumberOfFoundedAuthors() {
		return numberOfFoundedAuthors;
	}
	
	public AuthorsListPage uploadData() {
		uploadRowList();
		setNumberOfFoundedBooks();
		uploadAuthorsFirstName();
		uploadAuthorsLastName();
		return this;
	}
	
	private void uploadRowList() {
		this.rowList = authorTable.findElements(By.id("authorRow"));
		
	}
	
	private void setNumberOfFoundedBooks() {
		this.numberOfFoundedAuthors = rowList.size();
	}
	
	private void uploadAuthorsFirstName() {
		for (int i = 0; i < rowList.size(); i++) {
			this.authorFname.add(i, rowList.get(i).findElement(By.id("fname" + i)).getText());
		}
	}
	
	private void uploadAuthorsLastName() {
		for (int i = 0; i < rowList.size(); i++) {
			this.authorLname.add(i, rowList.get(i).findElement(By.id("lname" + i)).getText());
		}
	}
}
