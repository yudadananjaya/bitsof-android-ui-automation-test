package com.bitsof.modules.global.locators;

public class GlobalLocators {
    public static String getUsernameLocator(String username) {
        // Example: return String.format("//*[@text='%s']", username);
        return String.format("//*[@text='%s']", username);
    }
}
