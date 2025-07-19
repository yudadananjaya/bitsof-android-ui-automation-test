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

    public void clickbuttonViewMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.buttonViewMenu));
        driver.findElement(LoginLocators.buttonViewMenu).click();
    }

    public void clickLoginMenuItem() {
        driver.findElement(LoginLocators.buttonLoginMenuItem).click();
    }

    public void inputLoginUsername(String email) {
        driver.findElement(LoginLocators.inputUsernameField).sendKeys(email);
    }

    public void inputLoginPassword(String password) {
        driver.findElement(LoginLocators.inputPasswordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LoginLocators.buttonLogin).click();
    }

    public void waitButtonLoginDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.buttonLogin));
    }

    public void waitButtonLogoutMenuItemDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.buttonLogoutMenuItem));
    }
}
