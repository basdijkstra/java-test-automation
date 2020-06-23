package uitests.examples;

import uitests.examples.basepages.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExamplesIteration8 {

    private WebDriver driver;

    @Before
    public void createBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void doSearchFromGoogleHomePageThenFromResultsPage() {

        new GoogleHomePage(driver).
            load().
            doSearchFor("Belastingdienst");

        new GoogleResultsPage(driver).
            doSearchFor("Dutch Tax and Customs Administration");
    }

    @After
    public void closeBrowser() {

        driver.quit();
    }
}
