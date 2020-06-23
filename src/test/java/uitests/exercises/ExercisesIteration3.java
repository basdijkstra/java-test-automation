package uitests.exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExercisesIteration3 {

    @Test
    public void parabankTest() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://parabank.parasoft.com");

        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        /***
         * 1. Retrieve the current page title as displayed in the active tab and store it in a String variable
         * 2. Assert that the current title equals 'ParaBank | Accounts Overview'
         * 3. Retrieve the web element that shows the text 'Accounts Overview' above the list of john's accounts
         * 4. Assert that this element is visible on the page
         */

        driver.quit();
    }
}
