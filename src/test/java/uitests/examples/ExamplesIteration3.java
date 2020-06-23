package uitests.examples;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExamplesIteration3 {

    @Test
    public void googleTest() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Belastingdienst");

        driver.findElement(By.name("btnK")).click();

        String currentTitle = driver.getTitle();

        Assert.assertEquals("Belastingdienst - Google zoeken", currentTitle);

        WebElement resultsElement = driver.findElement(By.id("resultStats"));

        Assert.assertTrue(resultsElement.isDisplayed());

        driver.quit();
    }
}
