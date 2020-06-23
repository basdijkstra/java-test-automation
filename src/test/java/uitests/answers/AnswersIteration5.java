package uitests.answers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AnswersIteration5 {

    private WebDriver driver;

    @Before
    public void createBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void parabankTest() {

        driver.get("http://parabank.parasoft.com");

        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        // WAIT

        driver.findElement(By.linkText("Request Loan")).click();

        // WAIT

        driver.findElement(By.id("amount")).sendKeys("1000");
        driver.findElement(By.id("downPayment")).sendKeys("100");
        Select dropdownFromAccountId = new Select(driver.findElement(By.id("fromAccountId")));
        dropdownFromAccountId.selectByVisibleText("54321");

        // WAIT

        driver.findElement(By.xpath("//input[@value='Apply Now']")).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.
                textToBePresentInElement(
                        driver.findElement(By.id("loanStatus")), "Denied"));

        String result = driver.findElement(By.id("loanStatus")).getText();
        Assert.assertEquals("Denied", result);
    }

    @After
    public void closeBrowser() {

        driver.quit();
    }
}
