package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static data.TestData.LOGIN;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public class BaseMailPage extends AbstractMailPage {
	private String accountLogoXpath = "//*[contains(@title, '%s')]";

	@FindBy(xpath = "//a[contains(text(), 'Выйти')]")
	private WebElement exitBtn;
	@FindBy(xpath = "//div[contains(@role, 'button') and contains(text(), 'НАПИСАТЬ')]")
	private WebElement writeBtn;
	@FindBy(xpath = "//*[contains(@aria-label, 'Черновики')]")
	private WebElement draftsBtn;
	@FindBy(xpath = "//*[contains(@title, 'Отправленные')]")
	private WebElement sentBtn;

	BaseMailPage(WebDriver driver) {
		super(driver);
	}

	public MailCreationPage openCreateMailPage() {
		writeBtn.click();
		return new MailCreationPage(driver);
	}

	public boolean isPageOpened() {
		try {
			return driver.findElement(By.xpath(String.format(accountLogoXpath, LOGIN.getValue()))).isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public void clickWriteBtn() {
		writeBtn.click();
	}

	public DraftPage openDrafts() {
		draftsBtn.click();
		return new DraftPage(driver);
	}

	public SentPage openSentMails() throws InterruptedException {
		sentBtn.click();
		return new SentPage(driver);
	}

	public LoginPage logOff() {
		driver.findElement(By.xpath(String.format(accountLogoXpath, LOGIN.getValue()))).click();
		exitBtn.click();
		return new LoginPage(driver);
	}
}