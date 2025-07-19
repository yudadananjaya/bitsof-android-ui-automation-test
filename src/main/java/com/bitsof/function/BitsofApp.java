package com.bitsof.function;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class BitsofApp {
    private final AndroidDriver driver;

    public BitsofApp(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public String getElementText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }
}