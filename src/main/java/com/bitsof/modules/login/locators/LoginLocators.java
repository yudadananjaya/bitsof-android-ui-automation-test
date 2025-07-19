package com.bitsof.modules.login.locators;

import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;

public class LoginLocators {

        public static By buttonViewMenu = By.xpath("//android.widget.ImageView[@content-desc='View menu']");

        public static By buttonLoginMenuItem = By.xpath("//android.widget.TextView[@content-desc='Login Menu Item']");

        public static By buttonLogoutMenuItem = By.xpath("//android.widget.TextView[@content-desc='Logout Menu Item']");

        public static By inputUsernameField = By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/nameET']");

        public static By inputPasswordField = By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/passwordET']");

        public static By buttonLogin = By.xpath("//android.widget.Button[@content-desc='Tap to login with given credentials']");
}
