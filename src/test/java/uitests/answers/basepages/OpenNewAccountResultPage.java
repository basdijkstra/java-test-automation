package uitests.answers.basepages;

import uitests.answers.helpers.AnswersSeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenNewAccountResultPage {

    private WebDriver driver;
    private AnswersSeleniumHelpers selenium;

    private By linkNewAccountId = By.id("newAccountId");

    public OpenNewAccountResultPage(WebDriver driver) {
        this.driver = driver;
        selenium = new AnswersSeleniumHelpers(driver);
    }

    public boolean newAccountIdIsVisible() {
        return selenium.isDisplayed(linkNewAccountId);
    }
}
