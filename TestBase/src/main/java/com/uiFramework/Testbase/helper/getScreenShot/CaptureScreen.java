package com.uiFramework.Testbase.helper.getScreenShot;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreen {

    public static File reportDirectory = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\screenShots");

    /**
     * Captures a screenshot and saves it to a specified file location.
     * @param fileName The name of the screenshot file (excluding extension).
     * @param driver The WebDriver instance to capture the screenshot from.
     * @return The file path of the saved screenshot.
     */
    public String getScreenShot(String fileName, WebDriver driver) {
        if (fileName == "") {
            fileName = "blank";
        }

        File destFile = null;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        File screenFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        try {
            destFile = new File(reportDirectory + "\\" + fileName + "_" + formatter.format(calendar.getTime()) + ".png");
            Files.copy(screenFile.toPath(), destFile.toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destFile.toString();
    }
}
