package com.bitsof.modules.login.actions;

import com.bitsof.modules.login.locators.LoginLocators;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginActions {
    private final AndroidDriver driver;

    public LoginActions(AndroidDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(LoginLocators.emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(LoginLocators.passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(LoginLocators.loginButton).click();
    }

    public void clickLogout() {
        driver.findElement(LoginLocators.logoutButton).click();
    }

    public void clickLogoutConfirmationButton() {
        driver.findElement(LoginLocators.logoutConfirmationButton).click();
    }

    public void clickProfileSection(String vesselName, String username) {
        By profileSection = LoginLocators.profileSection(vesselName, username);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(profileSection)).click();
    }

}
