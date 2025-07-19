package com.bitsof.tests.login;

import com.bitsof.base.BaseTest;
import com.bitsof.model.TestData;
import com.bitsof.modules.login.actions.*;
import com.bitsof.modules.login.assertions.*;
import com.bitsof.modules.login.pageActions.*;
import com.bitsof.utils.TestUtils;
import com.bitsof.service.TestDataService;
import org.testng.annotations.BeforeMethod;

public class LoginBaseTest extends BaseTest {
    protected LoginActions loginActions;
    protected LoginAssertions loginAssertions;
    protected TestUtils testUtils;
    protected TestDataService testDataService;
    protected LoginPageActions loginPageActions;

    @BeforeMethod
    public void initPageObjects() {
        loginActions = new LoginActions(driver);
        loginPageActions = new LoginPageActions(driver);
        loginAssertions = new LoginAssertions(driver);
        testUtils = new TestUtils();
        testDataService = new TestDataService();
    }

    protected TestData getTestData(String testCaseId) {
        return testDataService.getTestDataById(testCaseId);
    }
}
