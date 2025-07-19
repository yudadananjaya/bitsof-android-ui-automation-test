package com.bitsof.tests.login;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.bitsof.model.TestData;
import com.bitsof.tests.login.LoginBaseTest;

import java.time.Duration;

public class LoginTest extends LoginBaseTest {
    @Test(priority = 1)
    public void testSuccessfulLoginPropFile() {
        String username = testUtils.getTestData("valid_username");
        String password = testUtils.getTestData("valid_password");
        String vesselName = testUtils.getTestData("valid_vessel_name");

        loginPageActions.performLogin(username, password);

        loginAssertions.assertProfileSectionVisible(vesselName, username);

        loginPageActions.performLogout(vesselName, username);
    }

    // @Test(priority = 2)
    // public void testSuccessfulLoginDataBase() {
    //     String testCaseId = "MTCM-00001";
    //     TestData testData = getTestData(testCaseId);

    //     String username = testData.getAccount().getUsername();
    //     String password = testData.getAccount().getPassword();
    //     String vesselName = testData.getAccount().getVesselName();

    //     loginPageActions.performLogin(username, password);

    //     loginAssertions.assertProfileSectionVisible(vesselName, username);

    //     loginPageActions.performLogout(vesselName, username);
    // }
}
