package uitests.exercises;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExercisesIteration5 {

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

        /***
         * 1. Continue the test by clicking the link with text 'Request Loan'
         * 2. Locate the Loan Amount textfield and send the text '1000' to it
         * 3. Locate the Down Payment textfield and send the text '100' to it
         * 4. Create a new Select element from the dropdown From Account Id
         * 5. Select the option '54321' from the dropdown using its visible text
         * 6. Locate the Apply Now button and click it
         * 7. Retrieve the text of the element displaying the loan application result
         * 8. Assert that this text is equal to 'Denied'
         */
    }

    @After
    public void closeBrowser() {

        driver.quit();
    }
}
