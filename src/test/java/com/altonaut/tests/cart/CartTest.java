package com.bitsof.tests.cart;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.bitsof.model.TestData;
import com.bitsof.tests.cart.CartBaseTest;
import com.bitsof.utils.TestUtils;
import java.nio.file.Paths;

import java.time.Duration;

public class CartTest extends CartBaseTest {
    private TestUtils testUtils;

    private void loadTestData(String fileName) {
        String testDataPath = Paths.get("src", "test", "resources", fileName).toString();
        testUtils = new TestUtils(testDataPath);
    }

    @Test(priority = 1)
    public void testAddProductToCart() {
        loadTestData("tc-001-cart-test-data.properties");

        String testDataProductIndex = testUtils.getTestData("product_index");
        int productIndex = Integer.parseInt(testDataProductIndex);

        String productColor = testUtils.getTestData("product_color");

        String scrollCounter = testUtils.getTestData("scroll_counter");

        cartPageActions.performAddToCart(productIndex, productColor, scrollCounter);

        try {
            Thread.sleep(3000); // Delay 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
