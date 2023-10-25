package com.uiFramework.Testbase.helper.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileHelper {

    private Properties propObj = null;

    /**
     * Constructor to initialize a PropertyFileHelper with the name of the property file.
     * @param propName The name of the property file to load.
     */
    public PropertyFileHelper(String propName) {
        FileInputStream fis = null;
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\configfile\\" + propName);

        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        propObj = new Properties();

        try {
            propObj.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the value associated with a specified key from the property file.
     * @param key The key for which to retrieve the value.
     * @return The value associated with the key from the property file.
     */
    public String getPropertyValueFromFile(String key) {
        String value = propObj.getProperty(key);
        return value;
    }
}
