package uitests.exercises.pages;

import uitests.answers.helpers.AnswersSeleniumHelpers;
import org.openqa.selenium.WebDriver;

public class RequestLoanPage {

    private WebDriver driver;
    private AnswersSeleniumHelpers selenium;

    /***
     * Create new By objects for the following four page elements:
     * - textfield for the loan amount
     * - textfield for the down payment
     * - dropdown for the from account id
     * - button Apply Now
     */


    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
        selenium = new AnswersSeleniumHelpers(driver);
    }

    public RequestLoanPage enterLoanAmount(String loanAmount) {
        /***
         * Implement this method so that it calls the sendKeys() from the helper class and enters
         * the specified amount in the loan amount text field
         */
        return this;
    }

    /***
     * Write a method
     * public RequestLoanPage enterDownPayment(String downPayment)
     * that types the down payment amount in the correct text field
     * and then returns the current object (return this;
     */

    /***
     * Do the same for selecting a specified from account id
     * using the select() method in the helper class
     */

    /***
     * Write a method that clicks the Apply Now button. What is its return type?
     */

    public void submitLoanRequest(String loanAmount, String downPayment, String fromAccountId) {
        /***
         * Implement this method so that it calls the above methods
         * that are needed to perform a loan request
         */
    }
}
