package uitests.exercises.basepages;

import uitests.answers.helpers.AnswersSeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/***
 * Make the AccountsOverviewPage inherit from the BasePage
 */

public class AccountsOverviewPage {

    private WebDriver driver;
    private AnswersSeleniumHelpers selenium;

    public AccountsOverviewPage(WebDriver driver) {
        /***
         * Pass the WebDriver object to the constructor of the BasePage here
         */
        this.driver = driver;
        selenium = new AnswersSeleniumHelpers(driver);
    }

    /***
     * Remove this method entirely, because we won't need it anymore.
     */

    public void selectMenuItem(String menuItem) {
        selenium.click(By.linkText(menuItem));
    }
}
