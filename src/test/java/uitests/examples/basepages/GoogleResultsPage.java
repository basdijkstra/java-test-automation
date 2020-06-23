package uitests.examples.basepages;

import uitests.examples.helpers.ExamplesSeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleResultsPage extends GoogleBasePage {

    private WebDriver driver;
    private ExamplesSeleniumHelpers selenium;

    private By textfieldResultStats = By.id("resultStats");

    public GoogleResultsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        selenium = new ExamplesSeleniumHelpers(driver);
    }

    public boolean resultStatisticsAreDisplayed(){
        return selenium.isDisplayed(textfieldResultStats);
    }
}
