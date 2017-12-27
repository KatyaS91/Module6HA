package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static data.TestData.URL;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public class BaseTestPage {

	WebDriver driver;

	@BeforeClass(alwaysRun = true, description = "Start browser")
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get(URL.getValue());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void cleanUp() {
		driver.quit();
	}
}