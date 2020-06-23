package uitests.examples.pages;

import uitests.examples.helpers.ExamplesSeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {

    private WebDriver driver;
    private ExamplesSeleniumHelpers selenium;

    private By textfieldSearchQuery = By.name("q");
    private By buttonDoSearch = By.name("btnK");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        selenium = new ExamplesSeleniumHelpers(driver);
    }

    public GoogleHomePage load() {
        driver.get("https://www.google.com");
        return this;
    }

    public GoogleHomePage enterSearchTerm(String searchQuery) {
        selenium.sendKeys(textfieldSearchQuery, searchQuery);
        return this;
    }

    public void clickSearchButton() {
        selenium.click(buttonDoSearch);
    }

    public void loadAndSearchFor(String searchQuery) {
        load().enterSearchTerm(searchQuery).clickSearchButton();
    }
}
