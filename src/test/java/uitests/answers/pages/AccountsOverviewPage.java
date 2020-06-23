package uitests.answers.pages;

import uitests.answers.helpers.AnswersSeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage {

    private WebDriver driver;
    private AnswersSeleniumHelpers selenium;

    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
        selenium = new AnswersSeleniumHelpers(driver);
    }

    public void selectMenuItem(String menuItem) {
        selenium.click(By.linkText(menuItem));
    }
}
