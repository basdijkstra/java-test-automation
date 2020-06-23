package uitests.answers.basepages;

import uitests.answers.helpers.AnswersSeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestLoanResultPage extends BasePage {

    private WebDriver driver;
    private AnswersSeleniumHelpers selenium;

    private By textfieldApplicationResult = By.id("loanStatus");

    public RequestLoanResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        selenium = new AnswersSeleniumHelpers(driver);
    }

    public String getLoanApplicationResult() {
        return selenium.getElementText(textfieldApplicationResult);
    }
}
