package com.uiFramework.Testbase.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeBrowser {

    /**
     * Configures and retrieves ChromeOptions with desired settings.
     * @return ChromeOptions object with configured settings.
     */
    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        // Add more ChromeOptions as needed

        DesiredCapabilities chrome = DesiredCapabilities.chrome();
        chrome.setJavascriptEnabled(true);
        chrome.setCapability("browserName", "chrome");
        chrome.setCapability("timezone", "UTC+05:30");
        chrome.setCapability("geoLocation", "IN");

        options.setCapability(ChromeOptions.CAPABILITY, chrome);

        // Linux specific settings
        if (System.getProperty("os.name").contains("Linux")) {
            options.addArguments("--headless", "window-size=1920,1080", "--no-sandbox");
        }
        return options;
    }

    /**
     * Retrieves a ChromeDriver instance with the specified ChromeOptions.
     * @param options ChromeOptions to configure the ChromeDriver.
     * @return A ChromeDriver instance.
     */
    private WebDriver getChromeDriver(ChromeOptions options) {
        String osName = System.getProperty("os.name");
        String driverPath;

        if (osName.contains("Mac")) {
            driverPath = System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver";
        } else if (osName.contains("Windows")) {
            driverPath = System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe";
        } else if (osName.contains("Linux")) {
            driverPath = "/usr/bin/chrome/chromedriver";
        } else {
            return null; // Unsupported OS
        }

        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver(options);
    }

    /**
     * Gets an instance of the WebDriver using Chrome with configured options.
     * @return WebDriver instance configured for Chrome.
     */
    public static WebDriver getBrowserInstance() {
        ChromeBrowser browser = new ChromeBrowser();
        return browser.getChromeDriver(browser.getChromeOptions());
    }

    public static void main(String[] args) {
        WebDriver driver = ChromeBrowser.getBrowserInstance();
        // Perform actions with the WebDriver as needed
    }
}
