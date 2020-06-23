package uitests.examples;

import uitests.examples.helpers.ExamplesSeleniumHelpers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExamplesIteration6 {

    private WebDriver driver;
    private ExamplesSeleniumHelpers selenium;

    @Before
    public void createBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        selenium = new ExamplesSeleniumHelpers(driver);
    }

    @Test
    public void googleTest() {

        driver.get("https://www.google.com");

        selenium.sendKeys(By.name("q"), "Belastingdienst");
        selenium.click(By.name("btnK"));

        Assert.assertTrue(selenium.isDisplayed(By.id("resultStats")));
    }

    @Test
    public void dropdownTest() {

        driver.get("https://html.com/tags/select/");

        selenium.select(By.xpath("(//select)[1]"), "Chilean Flamingo");
    }

    @After
    public void closeBrowser() {

        driver.quit();
    }
}
