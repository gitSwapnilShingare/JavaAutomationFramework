package com.uiFramework.Testbase.helper.window;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHelper {

    private WebDriver driver;

    /**
     * Constructor to initialize the WindowHelper with a WebDriver instance.
     * @param driver The WebDriver instance used for window handling operations.
     */
    public WindowHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Switch to the parent window.
     * This method switches focus back to the main or parent window.
     */
    public void switchToParentWindow() {
        driver.switchTo().defaultContent();
    }

    /**
     * Switch to a child window based on its index.
     * @param index The index of the child window to switch to.
     */
    public void switchToWindow(int index) {
        Set<String> windows = driver.getWindowHandles();
        int i = 1;
        for (String window : windows) {
            if (i == index) {
                driver.switchTo().window(window);
            } else {
                i++;
            }
        }
    }

    /**
     * Close all tabbed windows and switch back to the main window.
     * This method closes all child windows (tabs) and returns focus to the main window.
     */
    public void closeAllTabsAndSwitchToMainWindow() {
        Set<String> windows = driver.getWindowHandles();
        String mainwindow = driver.getWindowHandle();

        for (String window : windows) {
            if (!window.equalsIgnoreCase(mainwindow)) {
                driver.close();
            }
        }
        driver.switchTo().window(mainwindow);
    }

    /**
     * Perform a browser back navigation.
     * This method navigates the browser back to the previous page.
     */
    public void navigateBack() {
        driver.navigate().back();
    }

    /**
     * Perform a browser forward navigation.
     * This method navigates the browser forward to the next page (if available).
     */
    public void navigateForward() {
        driver.navigate().forward();
    }
}
