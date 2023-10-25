package com.uiFramework.Testbase.helper.select;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper {

    private WebDriver driver;

    /**
     * Constructor to initialize the DropDownHelper with a WebDriver instance.
     * @param driver The WebDriver instance used for interacting with dropdowns.
     */
    public DropDownHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Select an option in a dropdown by its value attribute.
     * @param element The dropdown WebElement to select an option from.
     * @param value The value attribute of the option to select.
     */
    public void selectUsingValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    /**
     * Select an option in a dropdown by its index (position in the list).
     * @param element The dropdown WebElement to select an option from.
     * @param index The index of the option to select.
     */
    public void selectUsingIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    /**
     * Select an option in a dropdown by its visible text.
     * @param element The dropdown WebElement to select an option from.
     * @param visibleText The visible text of the option to select.
     */
    public void selectUsingVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    /**
     * Deselect an option in a multi-select dropdown by its value attribute.
     * @param element The dropdown WebElement to deselect an option from.
     * @param value The value attribute of the option to deselect.
     */
    public void deSelectUsingValue(WebElement element, String value) {
        Select select = new Select(element);
        select.deselectByValue(value);
    }

    /**
     * Deselect an option in a multi-select dropdown by its index (position in the list).
     * @param element The dropdown WebElement to deselect an option from.
     * @param index The index of the option to deselect.
     */
    public void deSelectUsingIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.deselectByIndex(index);
    }

    /**
     * Deselect an option in a multi-select dropdown by its visible text.
     * @param element The dropdown WebElement to deselect an option from.
     * @param visibleText The visible text of the option to deselect.
     */
    public void deSelectUsingVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.deselectByVisibleText(visibleText);
    }

    /**
     * Get a list of all the options in a dropdown.
     * @param element The dropdown WebElement to retrieve options from.
     * @return A list of strings representing the visible text of all the options in the dropdown.
     */
    public List<String> getAllDropDownData(WebElement element) {
        Select select = new Select(element);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();
        for (WebElement ele : elementList) {
            valueList.add(ele.getText());
        }
        return valueList;
    }
}
