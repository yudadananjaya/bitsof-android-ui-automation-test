package com.bitsof.modules.login.locators;

import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;

public class LoginLocators {

    public static By emailField = By.xpath("(//android.widget.EditText[@resource-id='RNE__Input__text-input'])[1]");

    public static By passwordField = By.xpath("(//android.widget.EditText[@resource-id='RNE__Input__text-input'])[2]");

    public static By loginButton = By.xpath("//android.widget.Button[@content-desc='Login']");

    public static By logoutButton = By
            .xpath("//android.view.ViewGroup[contains(@content-desc, \"Log Out\")]//android.view.ViewGroup");

    public static By logoutConfirmationButton = By
            .xpath("//android.widget.Button[@content-desc=\"Log Out\"]");

    public static By profileSection(String vesselName, String username) {
        String xpath = String.format(
                "//android.view.ViewGroup[contains(@content-desc, \"%s\") and contains(@content-desc, \"%s\") and contains(@content-desc, \"You're Online\")]",
                vesselName, username);
        return By.xpath(xpath);
    }

}
