package com.bitsof.tests.login;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.bitsof.model.TestData;
import com.bitsof.tests.login.LoginBaseTest;
import com.bitsof.utils.TestUtils;
import java.nio.file.Paths;

import java.time.Duration;

public class LoginTest extends LoginBaseTest {
    private TestUtils testUtils;

    private void loadTestData(String fileName) {
        String testDataPath = Paths.get("src", "test", "resources", fileName).toString();
        testUtils = new TestUtils(testDataPath);
    }

    @Test(priority = 1)
    public void testSuccessfulLogin() {
        loadTestData("tc-001-login-test-data.properties");

        String username = testUtils.getTestData("valid_username");
        String password = testUtils.getTestData("valid_password");

        loginPageActions.performLogin(username, password);
        loginAssertions.assertButtonLogoutMenuItemDisplayed();
        loginPageActions.performLogout();
    }

    @Test(priority = 2)
    public void testSuccessfulLogout() {
        loadTestData("tc-002-login-test-data.properties");

        String username = testUtils.getTestData("valid_username");
        String password = testUtils.getTestData("valid_password");

        loginPageActions.performLogin(username, password);
        loginPageActions.performLogout();
        loginAssertions.assertButtonLoginDisplayed();

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
