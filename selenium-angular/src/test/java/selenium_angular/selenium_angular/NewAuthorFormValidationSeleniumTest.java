package selenium_angular.selenium_angular;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import selenium_angular.selenium_angular.dialogs.NewAuthorDialog;


public class NewAuthorFormValidationSeleniumTest extends AbstractSelenium {
	private NewAuthorDialog newAuthorDialog;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		newAuthorDialog = openAngular().clickBookList().clickAddBook().clickAddAuthor();
	}
	
	@Test
	public void testShouldCheckIfLastNameAndFirstNameIsRequired() {
		assertFalse(newAuthorDialog.getSaveAuthor().isEnabled());
	}
	
	@Test
	public void testShouldCheckIfLastNameIsRequired() {
		newAuthorDialog.setFisrtName("Jan");
		assertFalse(newAuthorDialog.getSaveAuthor().isEnabled());
	}
	
	@Test
	public void testShouldCheckIfFirstNameIsRequired() {
		newAuthorDialog.setLastName("Kowalski");
		assertFalse(newAuthorDialog.getSaveAuthor().isEnabled());
	}
	
	@Test
	public void testShouldAddAuthor() {
		newAuthorDialog.setFisrtName("Jan").setLastName("Kowalski");
		assertTrue(newAuthorDialog.getSaveAuthor().isEnabled());
	}

}
