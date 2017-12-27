package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static data.TestData.LOGIN;
import static data.TestData.PASSWORD;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public class LoginPage extends BaseMailPage {
	private static final String LOGIN_CSS = "#identifierId";
	private static final String NEXT_BTN_CSS = "div [id*= 'Next']";
	private static final String PASSWORD_INPUT_CSS = "input[type = 'password']";

	@FindBy(css = NEXT_BTN_CSS)
	public WebElement nextBtn;
	@FindBy(css = PASSWORD_INPUT_CSS)
	public WebElement passwordInput;
	@FindBy(id = "identifierId")
	public WebElement loginInput;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public BaseMailPage login() {
		driver.findElement(By.cssSelector(LOGIN_CSS)).sendKeys(LOGIN.getValue());
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.cssSelector(NEXT_BTN_CSS)));
		driver.findElement(By.cssSelector(NEXT_BTN_CSS)).click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PASSWORD_INPUT_CSS)));
		driver.findElement(By.cssSelector(PASSWORD_INPUT_CSS)).sendKeys(PASSWORD.getValue());
		driver.findElement(By.cssSelector(NEXT_BTN_CSS)).click();
		return new BaseMailPage(driver);
	}

	public boolean isNextBntDisplayed() {
		return driver.findElement(By.cssSelector(NEXT_BTN_CSS)).isDisplayed();
	}

	public boolean isPasswordInputDisplayed() {
		return driver.findElement(By.cssSelector(PASSWORD_INPUT_CSS)).isDisplayed();
	}
}