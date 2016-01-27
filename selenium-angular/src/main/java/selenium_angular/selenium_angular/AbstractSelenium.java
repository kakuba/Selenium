package selenium_angular.selenium_angular;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;

import selenium_angular.selenium_angular.pages.HomePage;

@RunWith(SeleniumScreenshotJUnit4Runner.class)
public class AbstractSelenium {
	protected WebDriver driver;

	@Before
	public void setUp() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("init.accept_languages", "en");
		driver = new FirefoxDriver(profile);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	public HomePage openAngular() {
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public void takeScreenshot() throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\tmp\\"+screenshot.getName());
		FileUtils.copyFile(screenshot, destFile);
		System.out.println(String.format("[[ATTACHMENT|%s]]", destFile.getAbsolutePath()));
	}
	
	@After
	public void thearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
