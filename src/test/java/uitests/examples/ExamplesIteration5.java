package uitests.examples;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExamplesIteration5 {

    private WebDriver driver;

    @Before
    public void createBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void googleTest() {

        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Belastingdienst");

        driver.findElement(By.name("btnK")).click();

        String currentTitle = driver.getTitle();

        Assert.assertEquals("Belastingdienst - Google zoeken", currentTitle);

        WebElement resultsElement = driver.findElement(By.id("resultStats"));

        Assert.assertTrue(resultsElement.isDisplayed());
    }

    @Test
    public void dropdownTest() {

        driver.get("https://html.com/tags/select/");

        Select dropdown = new Select(driver.findElement(By.xpath("(//select)[1]")));
        dropdown.selectByVisibleText("Chilean flamingo");
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
