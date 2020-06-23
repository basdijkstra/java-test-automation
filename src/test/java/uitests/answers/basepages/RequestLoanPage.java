package uitests.answers.basepages;

import uitests.answers.helpers.AnswersSeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestLoanPage {

    private WebDriver driver;
    private AnswersSeleniumHelpers selenium;

    private By textfieldLoanAmount = By.id("amount");
    private By textfieldDownPayment = By.id("downPayment");
    private By dropdownFromAccountId = By.id("fromAccountId");
    private By buttonApplyForLoan = By.xpath("//input[@value='Apply Now']");

    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
        selenium = new AnswersSeleniumHelpers(driver);
    }

    public RequestLoanPage enterLoanAmount(String loanAmount) {
        selenium.sendKeys(textfieldLoanAmount, loanAmount);
        return this;
    }

    public RequestLoanPage enterDownPayment(String downPayment) {
        selenium.sendKeys(textfieldDownPayment, downPayment);
        return this;
    }

    public RequestLoanPage selectFromAccountId(String fromAccountId) {
        selenium.select(dropdownFromAccountId, fromAccountId);
        return this;
    }

    public void doApplyNow() {
        selenium.click(buttonApplyForLoan);
    }

    public void submitLoanRequest(String loanAmount, String downPayment, String fromAccountId) {
        enterLoanAmount(loanAmount).
            enterDownPayment(downPayment).
            selectFromAccountId(fromAccountId).
            doApplyNow();
    }
}
