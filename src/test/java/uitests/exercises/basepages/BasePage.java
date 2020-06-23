package uitests.exercises.basepages;

import uitests.answers.helpers.AnswersSeleniumHelpers;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    private WebDriver driver;
    private AnswersSeleniumHelpers selenium;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        selenium = new AnswersSeleniumHelpers(driver);
    }

    /***
     * Implement a selectMenuItem() method that takes a String argument
     * and performs a click on the element with a linkText equal to the String argument
     */
}
