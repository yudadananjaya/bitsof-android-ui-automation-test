package com.bitsof.modules.login.assertions;

import com.bitsof.modules.login.actions.LoginActions;
import com.bitsof.modules.login.locators.LoginLocators;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginAssertions {
    private final AndroidDriver driver;
    private final LoginActions loginActions;

    public LoginAssertions(AndroidDriver driver) {
        this.driver = driver;
        this.loginActions = new LoginActions(driver);
    }

    public void assertButtonLoginDisplayed() {
        loginActions.waitButtonLoginDisplayed();
    }

    public void assertButtonLogoutMenuItemDisplayed() {
       loginActions.clickbuttonViewMenu();
       loginActions.waitButtonLogoutMenuItemDisplayed();
    }
}
