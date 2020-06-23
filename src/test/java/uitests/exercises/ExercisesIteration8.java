package uitests.exercises;

import uitests.exercises.basepages.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExercisesIteration8 {

    private WebDriver driver;

    @Before
    public void createBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        new LoginPage(driver).
                loadAndLoginAs("john","demo");
    }

    @Test
    public void parabankTest() {

        /***
         * Make sure that you can still select a menu item
         * from the AccountsOverviewPage after you removed
         * the selectMenuItem() method from the class
         */

        new AccountsOverviewPage(driver).
            selectMenuItem("Request Loan");

        new RequestLoanPage(driver).
            submitLoanRequest("1000","100","54321");

        Assert.assertEquals(
            "Denied",
            new RequestLoanResultPage(driver).getLoanApplicationResult()
        );

        /***
         * Add a method call here that selects the 'Log Out'
         * menu item from the RequestLoanResultPage.
         */
    }

    @After
    public void closeBrowser() {

        driver.quit();
    }
}
