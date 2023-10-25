package com.uiFramework.Testbase.testbase;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiFramework.Testbase.common.CommonMethods;
import com.uiFramework.Testbase.helper.browserConfiguration.ChromeBrowser;
import com.uiFramework.Testbase.helper.getScreenShot.CaptureScreen;
import com.uiFramework.Testbase.helper.property.PropertyFileHelper;
import com.uiFramework.Testbase.utils.ExtentManager;

public class TestBase {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	public CommonMethods cmObj = new CommonMethods();
	CaptureScreen screenObj = new CaptureScreen();
	public PropertyFileHelper proObj = new PropertyFileHelper("env.properties");
	
	@BeforeSuite
	public void beforeSuite() throws Exception{
		extent = ExtentManager.getInstance();
	}
	
	  @BeforeClass 
	  public void beforeClassOfA() {
	  driver = ChromeBrowser.getBrowserInstance();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().deleteAllCookies();
	  test = extent.createTest(getClass().getSimpleName());
	  driver.get(proObj.getPropertyValueFromFile("baseURL"));
	  cmObj.loginToApplication(driver,proObj.getPropertyValueFromFile("adminNumber"),proObj.getPropertyValueFromFile("adminPass")); 
	  }
	 
	
		
	@BeforeMethod
	public void beforeMethod(Method method){
		test.log(Status.INFO, method.getName()+" **************test started***************");
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(Status.FAIL, result.getThrowable());
			String imagePath = screenObj.getScreenShot(result.getName(),driver);
			test.addScreenCaptureFromPath(imagePath);
			
		}
		else if(result.getStatus() == ITestResult.SUCCESS){
			test.log(Status.PASS, result.getName()+" is pass");
			
			
			
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP, result.getName()+" is skipped");
			
		}
		test.log(Status.INFO,result.getName()+" **************test Finished***************");
		
		
	}
	
	@AfterClass
	public void afterClass(){
		
		driver.quit();
		
	}
	@AfterSuite
	public void afterSuiteMethod()
	{
		extent.flush();
	}
	

}
