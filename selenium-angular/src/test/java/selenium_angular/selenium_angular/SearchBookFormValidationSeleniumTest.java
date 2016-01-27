package selenium_angular.selenium_angular;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_angular.selenium_angular.pages.BooksListPage;


public class SearchBookFormValidationSeleniumTest extends AbstractSelenium {
	private BooksListPage booksListPage;
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
		booksListPage = openAngular().clickBookList();
	}
	
	@Test
	public void testShouldFindThreeBooks() {
		int numberOfBook = booksListPage.clickSearch().updateData().getNumberOfFoundedBooks();
		
		assertEquals(3, numberOfBook);
		assertEquals("Pierwsza książka", booksListPage.getBookTitle(0));
		assertEquals("Jan Kowalski", booksListPage.getBookAuthor(0));
		assertEquals("Druga książka", booksListPage.getBookTitle(1));
		assertEquals("Zbigniew Nowak", booksListPage.getBookAuthor(1));
		assertEquals("Trzecia książka", booksListPage.getBookTitle(2));
		assertEquals("Janusz Jankowski", booksListPage.getBookAuthor(2));
	}
	
	@Test
	public void testShouldFindZeroBooks() {
		int numberOfBook = booksListPage.setSearchText("Test text").clickSearch().updateData().getNumberOfFoundedBooks();
		
		assertEquals(0, numberOfBook);
	}
	
	@Test
	public void testShouldFindOneBooks() {
		int numberOfBook = booksListPage.setSearchText("Pierwsza książka").clickSearch().updateData().getNumberOfFoundedBooks();
		
		assertEquals(1, numberOfBook);
		assertEquals("Pierwsza książka", booksListPage.getBookTitle(0));
		assertEquals("Jan Kowalski", booksListPage.getBookAuthor(0));
	}
	
	@Test
	public void testShouldDeleteOneBook() {
		int deletingBookIndex = 2;
		
		int numberOfBookBeforeDelete = booksListPage.clickSearch().updateData().saveBook(deletingBookIndex).getNumberOfFoundedBooks();
		int numberOfBookAfterDelte = booksListPage.clickDeleteButton(deletingBookIndex).updateData().getNumberOfFoundedBooks();
		booksListPage.createSavedBook();
		
		assertEquals(3, numberOfBookBeforeDelete);
		assertEquals(2, numberOfBookAfterDelte);
		
	}
	
	@Test
	public void testShouldEditBookTitle() throws InterruptedException {
		int editingBookIndex = 1;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		booksListPage.clickSearch().updateData().saveBook(editingBookIndex).clickEditButton(editingBookIndex).editBookTitle("New title");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("saveBook")));
		String newTitle = booksListPage.clickSearch().updateData().getBookTitle(editingBookIndex);
		booksListPage.restoreEditedTitle(editingBookIndex);
		
		assertEquals("New title", newTitle);
	}

	
}
