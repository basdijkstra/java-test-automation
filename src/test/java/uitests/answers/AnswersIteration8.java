package uitests.answers;

import uitests.answers.basepages.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnswersIteration8 {

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

        new AccountsOverviewPage(driver).
            selectMenuItem("Request Loan");

        new RequestLoanPage(driver).
            submitLoanRequest("1000","100","54321");

        Assert.assertEquals(
            "Approved",
            new RequestLoanResultPage(driver).getLoanApplicationResult()
        );

        new RequestLoanResultPage(driver).
                selectMenuItem("Log Out");
    }

    @After
    public void closeBrowser() {

        driver.quit();
    }
}