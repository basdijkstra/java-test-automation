package uitests.examples.basepages;

import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends GoogleBasePage {

    private WebDriver driver;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public GoogleHomePage load() {
        driver.get("https://www.google.com");
        return this;
    }
}
