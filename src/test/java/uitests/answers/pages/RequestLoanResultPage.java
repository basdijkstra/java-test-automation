package uitests.answers.pages;

import uitests.answers.helpers.AnswersSeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestLoanResultPage {

    private WebDriver driver;
    private AnswersSeleniumHelpers selenium;

    private By textfieldApplicationResult = By.id("loanStatus");

    public RequestLoanResultPage(WebDriver driver) {
        this.driver = driver;
        selenium = new AnswersSeleniumHelpers(driver);
    }

    public String getLoanApplicationResult() {
        return selenium.getElementText(textfieldApplicationResult);
    }
}
