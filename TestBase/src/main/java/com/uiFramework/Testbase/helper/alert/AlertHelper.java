package com.uiFramework.Testbase.helper.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHelper {

    private WebDriver driver;

    /**
     * Constructor to initialize the AlertHelper with a WebDriver instance.
     * @param driver The WebDriver instance to work with.
     */
    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Gets the current alert dialog.
     * @return The Alert object representing the current alert dialog.
     */
    public Alert getAlert() {
        return driver.switchTo().alert();
    }

    /**
     * Accepts the current alert dialog.
     */
    public void acceptAlert() {
        getAlert().accept();
    }

    /**
     * Dismisses the current alert dialog.
     */
    public void dismissAlert() {
        getAlert().dismiss();
    }

    /**
     * Retrieves the text content of the current alert dialog.
     * @return The text content of the alert dialog.
     */
    public String getAlertText() {
        return getAlert().getText();
    }

    /**
     * Checks if an alert is present.
     * @return true if an alert is present, false if no alert is present.
     */
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    /**
     * Accepts the current alert dialog if it is present.
     */
    public void acceptAlertIfPresent() {
        if (isAlertPresent()) {
            acceptAlert();
        }
    }

    /**
     * Dismisses the current alert dialog if it is present.
     */
    public void dismissAlertIfPresent() {
        if (isAlertPresent()) {
            dismissAlert();
        }
    }

    /**
     * Accepts a prompt dialog with the given text if it is present.
     * @param text The text to input in the prompt dialog.
     */
    public void acceptPrompt(String text) {
        if (isAlertPresent()) {
            Alert alert = getAlert();
            alert.sendKeys(text);
            alert.accept();
        }
    }
}
