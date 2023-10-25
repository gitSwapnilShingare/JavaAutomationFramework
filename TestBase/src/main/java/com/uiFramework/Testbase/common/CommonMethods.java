package com.uiFramework.Testbase.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonMethods {
    
    /**
     * Method returns an alphanumeric string of the specified length
     * @param n
     * @return
     */
    public String getAlphaNumericString(int n) {
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        return generateRandomString(n, alphaNumericString);
    }

    /**
     * Method returns a numeric string of the specified length
     * @param n
     * @return
     */
    public String getNumericString(int n) {
        String numericString = "0123456789";
        return generateRandomString(n, numericString);
    }

    /**
     * Method returns a string of characters (letters) of the specified length
     * @param n
     * @return
     */
    public String getCharacterString(int n) {
        String characterString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        return generateRandomString(n, characterString);
    }

    /**
     * Helper method to generate a random string of the specified length
     * @param n
     * @param source
     * @return
     */
    public String generateRandomString(int n, String source) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(source.length() * Math.random());
            sb.append(source.charAt(index));
        }
        return sb.toString();
    }

    /**
     * This method logs into the application
     * @param driver
     * @param email
     * @param password
     */
    public void loginToApplication(WebDriver driver, String email, String password) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.id("myInput")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }
}
