package com.bitsof.modules.cart.actions;

import com.bitsof.modules.cart.locators.CartLocators;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CartActions {
    private final AndroidDriver driver;

    public CartActions(AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickImageProductView(int index) {
        // wait element visible (optional, only when element need time to load or shown)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartLocators.imageProductView(index)));

        // click element
        driver.findElement(CartLocators.imageProductView(index)).click();
    }

    public void clickButtonProductColorSelection(String color) {
        // wait element visible (optional, only when element need time to load or shown)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartLocators.buttonProductColorSelection(color)));

        driver.findElement(CartLocators.buttonProductColorSelection(color)).click();
    }

    public void clickButtonIncreaseItemQty() {
        driver.findElement(CartLocators.buttonIncreaseItemQty).click();
    }

    public void clickButtonAddToCart() {
        driver.findElement(CartLocators.buttonAddToCart).click();
    }

    public void clickButtonViewCart() {
        driver.findElement(CartLocators.buttonViewCart).click();
    }

    public void scrollProductDetailPage(String scrollCounter) {
        driver.findElement(CartLocators.scrollToBottomInScrollView(scrollCounter));

        try {
            Thread.sleep(1000); // Delay 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
