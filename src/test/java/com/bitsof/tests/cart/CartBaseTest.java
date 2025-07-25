package com.bitsof.tests.cart;

import com.bitsof.base.BaseTest;
import com.bitsof.model.TestData;
import com.bitsof.modules.cart.actions.*;
//import com.bitsof.modules.cart.assertions.*;
import com.bitsof.modules.cart.pageActions.*;
import com.bitsof.utils.TestUtils;
import com.bitsof.service.TestDataService;
import org.testng.annotations.BeforeMethod;

public class CartBaseTest extends BaseTest {
    protected CartActions cartActions;
    //protected LoginAssertions loginAssertions;
    protected TestUtils testUtils;
    protected TestDataService testDataService;
    protected CartPageActions cartPageActions;

    @BeforeMethod
    public void initPageObjects() {
        cartActions = new CartActions(driver);
        cartPageActions = new CartPageActions(driver);
        //loginAssertions = new LoginAssertions(driver);
        testDataService = new TestDataService();
    }

    protected TestData getTestData(String testCaseId) {
        return testDataService.getTestDataById(testCaseId);
    }
}
