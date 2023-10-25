package com.uiFramework.Testbase.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    
    private static ExtentReports extent;

    /**
     * Get the singleton instance of the ExtentReports.
     * If the instance is not created, it will create one and return it.
     * @return The ExtentReports instance.
     */
    public static ExtentReports getInstance(){
        if(extent == null){
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            String location = System.getProperty("user.dir") + "\\src\\main\\resources\\reports\\extent.html";
            return createInstance(location);
        }
        else{
            return extent;
        }
    }

    /**
     * Create and configure a new ExtentReports instance.
     * @param fileName The file name and location where the Extent report will be saved.
     * @return The newly created ExtentReports instance.
     */
    public static ExtentReports createInstance(String fileName){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Automation Report");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }
}
