package com.bitsof.modules.login.assertions;

import com.bitsof.modules.login.locators.LoginLocators;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginAssertions {
    private AppiumDriver driver;

    public LoginAssertions(AppiumDriver driver) {
        this.driver = driver;
    }

    public void assertLoginPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.emailField));
    }

    public void assertProfileSectionVisible(String vesselName, String username) {
        By profileSection = LoginLocators.profileSection(vesselName, username);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileSection));

        String actualContentDesc = driver.findElement(profileSection).getAttribute("content-desc");
        String expectedVessel = vesselName;
        String expectedUsername = username;

        if (!(actualContentDesc.contains(expectedVessel) && actualContentDesc.contains(expectedUsername))) {
            throw new AssertionError("Profile Section content-desc mismatch.\n" +
                    "Expected to contain: '" + expectedVessel + "' and '" + expectedUsername + "'\n" +
                    "Actual content-desc: '" + actualContentDesc + "'");
        }
    }
}
