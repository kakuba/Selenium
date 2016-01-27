package selenium_angular.selenium_angular;

import org.openqa.selenium.WebDriver;

public class AbstractPageObject {
	protected WebDriver driver;
	
	public AbstractPageObject(WebDriver driver) {
		this.driver = driver;
	}
}

