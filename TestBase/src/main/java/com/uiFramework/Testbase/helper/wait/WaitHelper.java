package com.uiFramework.Testbase.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    private WebDriver driver;

    /**
     * Constructor to initialize the WaitHelper with a WebDriver instance.
     * @param driver The WebDriver instance used for waiting operations.
     */
    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Set the implicit wait for the WebDriver.
     * @param timeout The timeout value.
     * @param unit The time unit for the timeout.
     */
    public void setImplicitWait(long timeout, TimeUnit unit) {
        driver.manage().timeouts().implicitlyWait(timeout, unit);
    }

    /**
     * Get a WebDriverWait object with custom timeout and polling interval.
     * @param timeOutInSeconds The custom timeout in seconds.
     * @param pollingEveryInMiliSec The custom polling interval in milliseconds.
     * @return A WebDriverWait object.
     */
    private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }

    /**
     * Wait for an element to be visible with a custom polling time.
     * @param element The WebElement to wait for.
     * @param timeOutInSeconds The timeout in seconds.
     * @param pollingEveryInMiliSec The polling interval in milliseconds.
     */
    public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for an element to be clickable.
     * @param element The WebElement to wait for.
     * @param timeOutInSeconds The timeout in seconds.
     */
    public void WaitForElementClickable(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wait for an element to become invisible.
     * @param element The WebElement to wait for.
     * @param timeOutInSeconds The timeout in seconds.
     * @return True if the element becomes invisible within the timeout, otherwise false.
     */
    public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
        return status;
    }

    /**
     * Wait for a frame to be available and switch to it.
     * @param element The WebElement representing the frame to wait for.
     * @param timeOutInSeconds The timeout in seconds.
     */
    public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    /**
     * Set the page load timeout for the WebDriver.
     * @param timeout The timeout value.
     * @param unit The time unit for the timeout.
     */
    public void pageLoadTime(long timeout, TimeUnit unit) {
        driver.manage().timeouts().pageLoadTimeout(timeout, unit);
    }

    /**
     * Wait for an element to be visible.
     * @param element The WebElement to wait for.
     * @param timeOutInSeconds The timeout in seconds.
     */
    public void waitForElement(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
