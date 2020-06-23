package uitests.exercises;

import uitests.exercises.helpers.ExercisesSeleniumHelpers;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExercisesIteration6 {

    private WebDriver driver;
    private ExercisesSeleniumHelpers selenium;

    @Before
    public void createBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        selenium = new ExercisesSeleniumHelpers(driver);
    }

    @Test
    public void parabankTest() {

        driver.get("http://parabank.parasoft.com");

        selenium.sendKeys(By.name("username"), "john");
        selenium.sendKeys(By.name("password"), "demo");
        selenium.click(By.xpath("//input[@value='Log In']"));


        /***
         * Rewrite the actions below so they use the helper methods in the ExercisesSeleniumHelpers class
         * You'll need to define one helper method yourself, to perform the dropdown select action
         * All other helpers you'll need are there already
         */

        driver.findElement(By.linkText("Request Loan")).click();
        driver.findElement(By.id("amount")).sendKeys("1000");
        driver.findElement(By.id("downPayment")).sendKeys("100");
        Select dropdownFromAccountId = new Select(driver.findElement(By.id("fromAccountId")));
        dropdownFromAccountId.selectByVisibleText("54321");
        driver.findElement(By.xpath("//input[@value='Apply Now']")).click();

        String result = driver.findElement(By.id("loanStatus")).getText();
        Assert.assertEquals("Denied", result);
    }

    @After
    public void closeBrowser() {

        driver.quit();
    }
}
