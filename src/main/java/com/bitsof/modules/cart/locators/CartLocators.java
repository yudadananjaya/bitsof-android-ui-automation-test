package com.bitsof.modules.cart.locators;

import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;

public class CartLocators {

    public static By imageProductView(int index) {
        return By.xpath(String.format("(//android.widget.ImageView[@content-desc='Product Image'])[%d]", index));
    }

    public static By buttonProductColorSelection(String color) {
        return By.xpath(String.format("//android.widget.ImageView[@content-desc='%s']", color));
    }

    public static By buttonIncreaseItemQty = By
            .xpath("//android.widget.ImageView[@content-desc='Increase item quantity']");

    public static By buttonAddToCart = By.xpath("//android.widget.Button[@content-desc='Tap to add product to cart']");

    public static By buttonViewCart = By.xpath("//android.widget.RelativeLayout[@content-desc='View cart']");

    public static By textViewItemQty = By
            .xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/noTV']");

    public static By scrollToBottomInScrollView(String scrollCounter) {
        return MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\"))" +
                        ".scrollToEnd(" + scrollCounter + ")");
    }
}