package selenium_angular.selenium_angular.pages;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import selenium_angular.selenium_angular.AbstractPageObject;
import selenium_angular.selenium_angular.dialogs.EditBookDialog;
import selenium_angular.selenium_angular.dialogs.NewBookDialog;

public class BooksListPage extends AbstractPageObject {
	private final Logger log = Logger.getLogger("MyLogger");
	
	private WebElement searchBook;
	private WebElement addBook;
	private WebElement bookTable;
	private WebElement searchText;
	private List<WebElement> rowList;
	private List<WebElement> deleteButtons = new ArrayList<>();
	private List<WebElement> editButtons = new ArrayList<>();
	private List<String> booksTitle = new ArrayList<>();
	private List<String> booksAuthor = new ArrayList<>();
	private int numberOfFoundedBooks;
	private String title;
	private String author;
	
	public BooksListPage(WebDriver driver) {
		super(driver);
	}
	
	public BooksListPage clickSearch() {
		searchBook.click();
		return this;
	}
	
	public NewBookDialog clickAddBook() {
		addBook.click();
		return PageFactory.initElements(driver, NewBookDialog.class);
	}
	
	public BooksListPage clickDeleteButton(int buttonIndex){
		deleteButtons.get(buttonIndex).click();
		return this;
	}
	
	public EditBookDialog clickEditButton(int bookIndex){
		editButtons.get(bookIndex).click();
		return PageFactory.initElements(driver, EditBookDialog.class);
	}
	
	public WebElement getBookTable() {
		return bookTable;
	}
	
	public String getBookTitle(int bookIndex) {
		return booksTitle.get(bookIndex);
	}
	
	public String getBookAuthor(int bookIndex) {
		return booksAuthor.get(bookIndex);
	}
	
	public int getNumberOfFoundedBooks() {
		return numberOfFoundedBooks;
	}
	
	public BooksListPage setSearchText(String searchText) {
		this.searchText.sendKeys(searchText);
		return this;
	}
	
	public BooksListPage updateData() {
		updateRowList();
		setNumberOfFoundedBooks();
		updateBooksTitle();
		updateBooksAuthor();
		updateDeleteButtons();
		updateEditButton();
		return this;
	}
	
	public BooksListPage saveBook(int bookIndex) {
		this.title = booksTitle.get(bookIndex);
		this.author = booksAuthor.get(bookIndex);
		return this;
	}
	
	public BooksListPage createSavedBook() {
		if(title != null && author != null) {
			this.createBook(title, author);
		} else {
			log.warning("No data was saved");
		}
		return this;
	}
	
	public BooksListPage restoreEditedTitle(int bookIndex) {
		if(title != null) {
			this.clickEditButton(bookIndex).editBookTitle(title);
		} else {
			log.warning("No data was saved");
		}
		return this;
	}
	
	private void setNumberOfFoundedBooks() {
		this.numberOfFoundedBooks = rowList.size();
	}
	
	private void updateRowList() {
		this.rowList = bookTable.findElements(By.id("bookRow"));
	}
	
	private void updateBooksTitle() {
		for (int i = 0; i < rowList.size(); i++) {
			this.booksTitle.add(i, rowList.get(i).findElement(By.id("title" + i)).getText());
		}
	}
	
	private void updateBooksAuthor() {
		for (int i = 0; i < rowList.size(); i++) {
			this.booksAuthor.add(i, rowList.get(i).findElement(By.id("author" + i)).getText());
		}
	}
	
	private void updateDeleteButtons() {
		this.deleteButtons.clear();
		for (int i  = 0; i < rowList.size(); i++) {
			this.deleteButtons.add(rowList.get(i).findElement(By.id("delete" + i)));
		}
	}
	
	private void updateEditButton() {
		this.editButtons.clear();
		for (int i  = 0; i < rowList.size(); i++) {
			this.editButtons.add(bookTable.findElement(By.id("edit" + i)));
		}
	}
	
	private BooksListPage createBook(String title, String author) {
		String[] splittedAuthor = author.split("\\s+");
		String fname = splittedAuthor[0];
		String lname = splittedAuthor[1];
		NewBookDialog newBookDialog = clickAddBook();
		newBookDialog.createAuthor(fname, lname);
		newBookDialog.setBookTitle(title);
		newBookDialog.clickSaveBook();
		return this;
	}
	
}
