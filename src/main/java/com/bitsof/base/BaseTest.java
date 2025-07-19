package com.bitsof.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.URL;
import java.time.Duration;
import java.nio.file.Paths;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {

        String apkPath = Paths.get("apk", "mda-2.2.0-25.apk").toAbsolutePath().toString();

        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(apkPath)
                .setAutomationName("UiAutomator2")
                .setPlatformName("Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
