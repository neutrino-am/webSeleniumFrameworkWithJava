package com.am.tests;

import com.am.driver.Driver;
import com.am.enums.ConfigProperties;
import com.am.utils.PropertyUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected BaseTest() { }

    @BeforeMethod
    protected void setup() throws Exception {
        Driver.initDriver(PropertyUtils.get(ConfigProperties.BROWSER)); }

    @AfterMethod
    protected void teardown() {
        Driver.quitDriver();
    }
}