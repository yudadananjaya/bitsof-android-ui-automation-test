package com.bitsof.modules.login.pageActions;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.bitsof.modules.login.actions.LoginActions;
import com.bitsof.modules.login.assertions.LoginAssertions;
import com.bitsof.modules.global.assertions.GlobalAssertions;
import com.bitsof.function.BitsofApp;

public class LoginPageActions {
    private final AndroidDriver driver;
    private final LoginActions loginActions;
    private final LoginAssertions loginAssertions;
    private final GlobalAssertions globalAssertions;

    public LoginPageActions(AndroidDriver driver) {
        this.driver = driver;
        this.loginActions = new LoginActions(driver);
        this.loginAssertions = new LoginAssertions(driver);
        this.globalAssertions = new GlobalAssertions(driver);
    }

    public void performLogin(String username, String password) {
        loginAssertions.assertLoginPageDisplayed();
        loginActions.enterEmail(username);
        loginActions.enterPassword(password);
        loginActions.clickLogin();
    }

    public void performLogout(String vesselName, String username) {
        loginActions.clickProfileSection(vesselName, username);
        loginActions.clickLogout();
        loginActions.clickLogoutConfirmationButton();
    }

}