package selenium_angular.selenium_angular;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import selenium_angular.selenium_angular.pages.AuthorsListPage;


public class SearchAuthorFormValidationSeleniumTest extends AbstractSelenium {
	private AuthorsListPage authorsListPage;
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
		authorsListPage = openAngular().clickAuthorList();
	}
	
	@Test
	public void testShouldFindAtLeastThreeAuthors() {
		int numberOfBook = authorsListPage.clickSearch().uploadData().getNumberOfFoundedAuthors();
		
		assertTrue(numberOfBook >= 3);
		assertFalse(authorsListPage.getRowList().isEmpty());
		assertNotNull(authorsListPage.getRowList());
	}
	
	@Test
	public void testShouldFindAtLeastOneAuthor() {
		int numberOfBook = authorsListPage.clickSearch().setAuthorSearchText("Zbigniew").uploadData().getNumberOfFoundedAuthors();
		String firstName = authorsListPage.getAuthorFirstName(0);
		
		assertTrue(numberOfBook >= 1);
		assertFalse(authorsListPage.getRowList().isEmpty());
		assertNotNull(authorsListPage.getRowList());
		assertEquals("Zbigniew", firstName);
	}
	
	@Test
	public void testShouldFindNoAuthor() {
		int numberOfBook = authorsListPage.clickSearch().setAuthorSearchText("No authors").uploadData().getNumberOfFoundedAuthors();
		
		assertTrue(numberOfBook == 0);
		assertTrue(authorsListPage.getRowList().isEmpty());
		assertNotNull(authorsListPage.getRowList());
	}
	
	
	
	
}
