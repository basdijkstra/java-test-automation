package uitests.answers.basepages;

import uitests.answers.helpers.AnswersSeleniumHelpers;
import org.openqa.selenium.*;

public abstract class BasePage {

    private WebDriver driver;
    private AnswersSeleniumHelpers selenium;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        selenium = new AnswersSeleniumHelpers(driver);
    }

    public void selectMenuItem(String linkText) {
        selenium.click(By.linkText(linkText));
    }
}
