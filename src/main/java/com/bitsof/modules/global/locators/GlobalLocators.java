package com.bitsof.modules.global.locators;

public class GlobalLocators {
    // Update these locators to match Android UI if possible (resource-id,
    // content-desc, etc.)
    public static final String online_status_text = "//*[@content-desc='online_status_text']";

    public static String getUsernameLocator(String username) {
        // Example: return String.format("//*[@text='%s']", username);
        return String.format("//*[@text='%s']", username);
    }
}
