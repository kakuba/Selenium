package selenium_angular.selenium_angular;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import selenium_angular.selenium_angular.dialogs.NewBookDialog;


public class NewBookFormValidationSeleniumTest extends AbstractSelenium {
	private NewBookDialog newBookDialog;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		newBookDialog = openAngular().clickBookList().clickAddBook();
	}
	
	@Test
	public void testShouldCheckTitleAndAuthorIsRequired() {
		assertFalse(newBookDialog.getSaveBook().isEnabled());
	}
	
	@Test
	public void testShouldCheckIfAuthorIsRequired() {
		newBookDialog.setBookTitle("Test Title");
		assertFalse(newBookDialog.getSaveBook().isEnabled());
	}
	
	@Test
	public void testShouldCheckIfTitleIsRequired() {
		newBookDialog.clickAddAuthor().setFisrtName("Jan").setLastName("Kowalski").clickSaveAuthor();
		assertFalse(newBookDialog.getSaveBook().isEnabled());
	}
	
	@Test
	public void testShouldAddBook() {
		newBookDialog.setBookTitle("Test title").clickAddAuthor().setFisrtName("Jan").setLastName("Kowalski").clickSaveAuthor();
		assertTrue(newBookDialog.getSaveBook().isEnabled());
	}
	
}
