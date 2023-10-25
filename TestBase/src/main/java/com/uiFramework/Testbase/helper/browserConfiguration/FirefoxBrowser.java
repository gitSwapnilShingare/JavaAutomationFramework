package com.uiFramework.Testbase.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxBrowser {

    /**
     * Retrieves FirefoxOptions with desired settings.
     * @return FirefoxOptions object with configured settings.
     */
    public FirefoxOptions getFirefoxOptions() {
        DesiredCapabilities firefox = DesiredCapabilities.firefox();

        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);

        firefox.setCapability(FirefoxDriver.PROFILE, profile);
        firefox.setCapability("marionette", true);

        FirefoxOptions firefoxOptions = new FirefoxOptions(firefox);

        // Linux specific settings
        if (System.getProperty("os.name").contains("Linux")) {
            firefoxOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
        }
        return firefoxOptions;
    }

    /**
     * Retrieves a FirefoxDriver instance with the specified FirefoxOptions.
     * @param options FirefoxOptions to configure the FirefoxDriver.
     * @return A FirefoxDriver instance.
     */
    public WebDriver getFirefoxDriver(FirefoxOptions options) {
        String osName = System.getProperty("os.name");
        String driverPath;

        if (osName.contains("Mac")) {
            driverPath = System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver";
        } else if (osName.contains("Windows")) {
            driverPath = System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe";
        } else if (osName.contains("Linux")) {
            driverPath = "/usr/bin/geckodriver";
        } else {
            return null; // Unsupported OS
        }

        System.setProperty("webdriver.gecko.driver", driverPath);
        return new FirefoxDriver(options);
    }

    public static void main(String[] args) {
        FirefoxBrowser browser = new FirefoxBrowser();
        WebDriver driver = browser.getFirefoxDriver(browser.getFirefoxOptions());
        // Perform actions with the WebDriver as needed
    }
}
