package uitests.answers.basepages;

import uitests.answers.helpers.AnswersSeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenNewAccountPage {

    private WebDriver driver;
    private AnswersSeleniumHelpers selenium;

    private By dropdownAccountType = By.id("type");
    private By dropdownFromAccountId = By.id("fromAccountId");
    private By buttonOpenNewAccount = By.xpath("//input[@value='Open New Account']");

    public OpenNewAccountPage(WebDriver driver) {
        this.driver = driver;
        selenium = new AnswersSeleniumHelpers(driver);
    }

    public void openNewAccount(String accountType, String fromAccountId) {

        selenium.select(dropdownAccountType, accountType);
        selenium.selectWithWait(dropdownFromAccountId, fromAccountId);
        selenium.click(buttonOpenNewAccount);
    }
}
