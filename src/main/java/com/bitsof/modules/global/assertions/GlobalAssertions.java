package com.bitsof.modules.global.assertions;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By; // Add this import
import org.testng.Assert;

public class GlobalAssertions {
    private final AndroidDriver driver;

    public GlobalAssertions(AndroidDriver driver) {
        this.driver = driver;
    }

    public void assertElementDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isDisplayed());
    }

    public void assertTextEquals(By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        Assert.assertEquals(element.getText(), expectedText);
    }
}