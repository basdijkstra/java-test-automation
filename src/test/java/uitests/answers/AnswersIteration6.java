package uitests.answers;

import uitests.answers.helpers.AnswersSeleniumHelpers;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnswersIteration6 {

    private WebDriver driver;
    private AnswersSeleniumHelpers selenium;

    @Before
    public void createBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        selenium = new AnswersSeleniumHelpers(driver);
    }

    @Test
    public void parabankTest() {

        driver.get("http://parabank.parasoft.com");

        selenium.sendKeys(By.name("username"), "john");
        selenium.sendKeys(By.name("password"), "demo");
        selenium.click(By.xpath("//input[@value='Log In']"));

        selenium.click(By.linkText("Request Loan"));
        selenium.sendKeys(By.id("amount"), "1000");
        selenium.sendKeys(By.id("downPayment"), "100");
        selenium.select(By.id("fromAccountId"), "54321");
        selenium.click(By.xpath("//input[@value='Apply Now']"));

        Assert.assertEquals("Denied", selenium.getElementText(By.id("loanStatus")));
    }

    @After
    public void closeBrowser() {

        driver.quit();
    }
}
