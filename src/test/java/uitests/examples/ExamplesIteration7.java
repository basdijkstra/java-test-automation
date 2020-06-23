package uitests.examples;

import uitests.examples.pages.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExamplesIteration7 {

    private WebDriver driver;

    @Before
    public void createBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void googleTest() {

        new GoogleHomePage(driver).
            load().
            enterSearchTerm("Belastingdienst").
            clickSearchButton();

        Assert.assertTrue(
            new GoogleResultsPage(driver).resultStatisticsAreDisplayed()
        );
    }

    @Test
    public void aLessVerboseGoogleTest() {

        new GoogleHomePage(driver).
            loadAndSearchFor("Belastingdienst");

        Assert.assertTrue(
            new GoogleResultsPage(driver).resultStatisticsAreDisplayed()
        );
    }

    @After
    public void closeBrowser() {

        driver.quit();
    }
}
