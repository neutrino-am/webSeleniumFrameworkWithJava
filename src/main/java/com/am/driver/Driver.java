package com.am.driver;

import com.am.constants.FrameworkConstants;
import com.am.enums.ConfigProperties;
import com.am.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

public final class Driver {

    private Driver () {}

    public static void initDriver() throws Exception{
        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriverManager.chromedriver().setup(); // to work with webdriver manager instead of local driver
            //System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());

            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless"); // to run chrome headless
            DriverManager.setDriver(new ChromeDriver(options));

            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
            DriverManager.getDriver().manage().window().maximize();
        }
    }
    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
    }