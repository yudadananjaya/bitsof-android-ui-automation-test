package com.bitsof.modules.cart.pageActions;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.bitsof.modules.cart.actions.CartActions;
//import com.bitsof.modules.login.assertions.LoginAssertions;
import com.bitsof.modules.global.assertions.GlobalAssertions;
import com.bitsof.function.BitsofApp;

public class CartPageActions {
    private final AndroidDriver driver;
    private final CartActions cartActions;
    // private final LoginAssertions loginAssertions;
    private final GlobalAssertions globalAssertions;

    public CartPageActions(AndroidDriver driver) {
        this.driver = driver;
        this.cartActions = new CartActions(driver);
        // this.loginAssertions = new LoginAssertions(driver);
        this.globalAssertions = new GlobalAssertions(driver);
    }

    public void performAddToCart(int productIndex, String productColor, String scrollCounter) {
        cartActions.clickImageProductView(productIndex);
        cartActions.scrollProductDetailPage(scrollCounter);
        cartActions.clickButtonProductColorSelection(productColor);
        cartActions.clickButtonIncreaseItemQty();
        cartActions.clickButtonAddToCart();
        cartActions.clickButtonViewCart();
    }

}