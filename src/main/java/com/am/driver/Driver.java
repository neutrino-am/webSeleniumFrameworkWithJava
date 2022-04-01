package com.am.driver;

import com.am.constants.FrameworkConstants;
import com.am.enums.ConfigProperties;
import com.am.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public final class Driver {

    private Driver () {}

    public static void initDriver(String browser) throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {
            // chrome
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());
                DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
                DriverManager.getDriver().manage().window().setSize(new Dimension(1440, 900));
                DriverManager.getDriver().manage().window().maximize();
            }
            //firefox
            else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
                DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
                DriverManager.getDriver().manage().window().setSize(new Dimension(1440, 900));
                DriverManager.getDriver().manage().window().maximize();
            }
            //edge
            else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                DriverManager.setDriver(new EdgeDriver());
                DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
                DriverManager.getDriver().manage().window().setSize(new Dimension(1440, 900));
                DriverManager.getDriver().manage().window().maximize();
            }
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
    }