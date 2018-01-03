package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public class DraftPage extends BaseMailPage {

	private String subjectLabelXpath = "//span[contains(text(), '%s')]";
	private static final String SUCCESS_MSG_XPATH = "//div[contains(text(), 'Письмо отправлено')]";

	@FindBy(xpath = "//div[@role = 'main']//table//tr")
	private List<WebElement> drafts;

	DraftPage(WebDriver driver) {
		super(driver);
	}

	public boolean isExpectedDraftSubjectPresent(String expectedSubject) {
		try {
			return driver.findElement(By.xpath(String.format(subjectLabelXpath, expectedSubject))).isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public boolean isExpectedDraftBodyDisplayed(String expectedBody) {
		try {
			return  driver.findElement(By.xpath(String.format(subjectLabelXpath, expectedBody))).isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public boolean sendDraft (int draftOrder) {
		drafts.get(0).click();
		new MailCreationPage(driver).send();
		return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUCCESS_MSG_XPATH))).isDisplayed();
	}
}