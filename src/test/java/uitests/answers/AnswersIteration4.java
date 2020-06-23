package uitests.answers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnswersIteration4 {

    private WebDriver driver;

    @Before
    public void createBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void parabankTest() {

        driver.get("http://parabank.parasoft.com");

        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        String currentTitle = driver.getTitle();

        Assert.assertEquals("ParaBank | Accounts Overview", currentTitle);

        WebElement accountsOverviewHeader = driver.findElement(By.xpath("//h1[@class='title']"));

        Assert.assertTrue(accountsOverviewHeader.isDisplayed());
    }

    @After
    public void closeBrowser() {

        driver.quit();
    }
}
