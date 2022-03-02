package com.am.driver;

import com.am.constants.FrameworkConstants;
import com.am.enums.ConfigProperties;
import com.am.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver {

    private Driver () {}

    public static void initDriver() throws Exception{
        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriverManager.chromedriver().setup();
            //System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
            DriverManager.setDriver(new ChromeDriver());
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