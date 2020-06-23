package uitests.exercises;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExercisesIteration4 {

    /***
     * 1. Create a private instance of the WebDriver class as a class variable
     *    (it has to be accessed by several methods in this class)
     * 2. Create a @Before method where you configure and start a Chrome instance and maximize it
     * 3. Create an @After method where you close the browser using the quit() method
     */

    @Test
    public void parabankTest() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://parabank.parasoft.com");

        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        String currentTitle = driver.getTitle();

        Assert.assertEquals("ParaBank | Accounts Overview", currentTitle);

        WebElement accountsOverviewHeader = driver.findElement(By.xpath("//h1[@class='title']"));

        Assert.assertTrue(accountsOverviewHeader.isDisplayed());

        driver.quit();
    }
}
