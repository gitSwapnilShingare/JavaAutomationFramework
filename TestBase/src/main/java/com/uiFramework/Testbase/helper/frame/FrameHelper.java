package com.uiFramework.Testbase.helper.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {
    
    private WebDriver driver;
    
    /**
     * Constructor to initialize the FrameHelper with a WebDriver instance.
     * @param driver The WebDriver instance to work with frames.
     */
    public FrameHelper(WebDriver driver){
        this.driver = driver;
    }
    
    /**
     * Switches to a frame based on the frame index.
     * @param frameIndex The index of the frame to switch to.
     */
    public void switchToFrame(int frameIndex){
        driver.switchTo().frame(frameIndex);
    }
    
    /**
     * Switches to a frame based on the frame name.
     * @param frameName The name of the frame to switch to.
     */
    public void switchToFrame(String frameName){
        driver.switchTo().frame(frameName);
    }
    
    /**
     * Switches to a frame based on a WebElement.
     * @param element The WebElement representing the frame to switch to.
     */
    public void switchToFrame(WebElement element){
        driver.switchTo().frame(element);
    }
    
    /**
     * Switches back to the main web page from the current frame.
     */
    public void switchToDefaultContent()
    {
        driver.switchTo().defaultContent();
    }
}
