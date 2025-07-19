package com.bitsof.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import java.util.Properties;
import java.io.FileInputStream;

public class TestUtils {
    private Properties testData;

    public TestUtils() {
        testData = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/test/resources/login-test-data.properties");
            testData.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTestData(String key) {
        return testData.getProperty(key);
    }

    public static void waitForElement(AndroidDriver driver, WebElement element, int timeout) {
        // Implementation using WebDriverWait
    }
}