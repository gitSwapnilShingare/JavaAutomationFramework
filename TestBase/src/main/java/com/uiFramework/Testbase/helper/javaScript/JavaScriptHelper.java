package com.uiFramework.Testbase.helper.javaScript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {

    private WebDriver driver;

    /**
     * Constructor to initialize the JavaScriptHelper with a WebDriver instance.
     * @param driver The WebDriver instance for executing JavaScript.
     */
    public JavaScriptHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Execute JavaScript code in the current WebDriver context.
     * @param script The JavaScript code to execute.
     * @return The result of executing the script.
     */
    public Object executeScript(String script) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return executor.executeScript(script);
    }

    /**
     * Execute JavaScript code with multiple arguments in the current WebDriver context.
     * @param script The JavaScript code to execute.
     * @param args Additional arguments to pass to the script.
     * @return The result of executing the script.
     */
    public Object executeScript(String script, Object... args) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return executor.executeScript(script, args);
    }

    /**
     * Scroll to a specific WebElement on the page.
     * @param element The WebElement to scroll to.
     */
    public void scrollToElement(WebElement element) {
        executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
    }

    /**
     * Scroll to a specific WebElement on the page and click it.
     * @param element The WebElement to scroll to and click.
     */
    public void scrollToElementAndClick(WebElement element) {
        scrollToElement(element);
        element.click();
    }

    /**
     * Scroll an element into the viewable area of the browser window.
     * @param element The WebElement to scroll into view.
     */
    public void scrollIntoView(WebElement element) {
        executeScript("arguments[0].scrollIntoView()", element);
    }

    /**
     * Scroll an element into view and click it.
     * @param element The WebElement to scroll into view and click.
     */
    public void scrollIntoViewAndClick(WebElement element) {
        scrollIntoView(element);
        element.click();
    }

    /**
     * Scroll down vertically to the bottom of the page.
     */
    public void scrollDownVertically() {
        executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Scroll up vertically to the top of the page.
     */
    public void scrollUpVertically() {
        executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    /**
     * Scroll down by a specified number of pixels.
     * @param pixel The number of pixels to scroll down by.
     */
    public void scrollDownByPixel(int pixel) {
        executeScript("window.scrollBy(0, " + pixel + ")");
    }

    /**
     * Scroll up by a specified number of pixels.
     * @param pixel The number of pixels to scroll up by.
     */
    public void scrollUpByPixel(int pixel) {
        executeScript("window.scrollBy(0, -" + pixel + ")");
    }

    /**
     * Zoom the screen to 100%.
     */
    public void zoomInBy100Percentage() {
        executeScript("document.body.style.zoom='100%'");
    }

    /**
     * Zoom the screen to 60%.
     */
    public void zoomInBy60Percentage() {
        executeScript("document.body.style.zoom='40%'");
    }

    /**
     * Click on a WebElement using JavaScript.
     * @param element The WebElement to click.
     */
    public void clickElement(WebElement element) {
        executeScript("arguments[0].click();", element);
    }
}
