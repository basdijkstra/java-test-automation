package uitests.exercises.helpers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExercisesSeleniumHelpers {

    private WebDriver driver;

    public ExercisesSeleniumHelpers(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By by) {

        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).click();
        }
        catch (TimeoutException te) {
            Assert.fail(String.format("Exception in click(): %s", te.getMessage()));
        }
    }

    public void sendKeys(By by, String textToType) {

        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).sendKeys(textToType);
        }
        catch (TimeoutException te) {
            Assert.fail(String.format("Exception in sendKeys(): %s", te.getMessage()));
        }
    }

    public void select(By by, String valueToSelect) {

        /***
         * Implement this helper method so that it first waits for the select element to be clickable
         * Then perform the select by visible text action like before
         * Use proper exception handling as well in case there's a timeout
         */
    }

    public boolean isDisplayed(By by) {

        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }
        catch (TimeoutException te) {
            return false;
        }
    }

    public String getElementText(By by) {

        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
            return driver.findElement(by).getText();
        }
        catch (TimeoutException te) {
            return "Element not found";
        }
    }
}
