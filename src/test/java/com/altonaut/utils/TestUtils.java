package com.bitsof.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {
    private Properties testData;

    public TestUtils(String testDataPath) {
        testData = new Properties();
        try (FileInputStream input = new FileInputStream(testDataPath)) {
            testData.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load test data from path: " + testDataPath);
        }
    }

    public String getTestData(String key) {
        return testData.getProperty(key);
    }

    public static void waitForElement(AndroidDriver driver, WebElement element, int timeoutInSeconds) {
        // Implementasi opsional: explicit wait
    }
}
