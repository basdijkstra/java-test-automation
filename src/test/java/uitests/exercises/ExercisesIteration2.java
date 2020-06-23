package uitests.exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExercisesIteration2 {

    @Test
    public void parabankTest() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://parabank.parasoft.com");

        /***
         * 1. Locate the username textfield element and type the value 'john' in it
         * 2. Locate the password textfield element and type the value 'demo' in it
         * 3. Locate the LOG IN button element and click it
         */

        driver.quit();
    }
}
