package uitests.examples.basepages;

import uitests.examples.helpers.ExamplesSeleniumHelpers;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public abstract class GoogleBasePage {

    private WebDriver driver;
    private ExamplesSeleniumHelpers selenium;

    private By textfieldSearchQuery = By.name("q");

    public GoogleBasePage(WebDriver driver) {
        this.driver = driver;
        selenium = new ExamplesSeleniumHelpers(driver);
    }

    public void doSearchFor(String searchQuery) {
        selenium.sendKeys(textfieldSearchQuery, searchQuery);

        new Actions(driver).sendKeys(Keys.ENTER).build().perform();
    }
}
