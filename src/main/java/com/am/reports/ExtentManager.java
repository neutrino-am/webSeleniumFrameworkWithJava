package com.am.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    private ExtentManager() {
    }

    private static ThreadLocal<ExtentTest> ext = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return ext.get();
    }
    static void setExtentTest (ExtentTest test) {
        ext.set(test);
    }
    static void unload () {
        ext.remove();
    }
}
