package uitests.answers.basepages;

import uitests.answers.helpers.AnswersSeleniumHelpers;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage extends BasePage {

    private WebDriver driver;
    private AnswersSeleniumHelpers selenium;

    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        selenium = new AnswersSeleniumHelpers(driver);
    }
}
