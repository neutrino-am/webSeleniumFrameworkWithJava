package com.am.tests;

import com.am.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected BaseTest() { }

    @BeforeMethod
    protected void setup() throws Exception {
        Driver.initDriver(); }

    @AfterMethod
    protected void teardown() {
        Driver.quitDriver();
    }
}