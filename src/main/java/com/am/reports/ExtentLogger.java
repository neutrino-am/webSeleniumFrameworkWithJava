package com.am.reports;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.am.enums.ConfigProperties;
import com.am.utils.PropertyUtils;
import static com.am.utils.ScreenshotUtils.getBase64Image;

public final class ExtentLogger {

    private ExtentLogger() {
    }

    public static void pass (String message){
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail (String message){
        ExtentManager.getExtentTest().fail(message);
    }

    public static void skip (String message){
        ExtentManager.getExtentTest().skip(message);
    }

    public static void pass (String message, boolean isScreenshotNeeded) throws Exception {
        if (PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded) {
            ExtentManager
                    .getExtentTest()
                    .pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image())
                            .build());
        }
        else
        {
            ExtentManager.getExtentTest().pass(message);
        }
    }

    public static void fail (String message, boolean isScreenshotNeeded) throws Exception {
        if (PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded) {
            ExtentManager
                    .getExtentTest()
                    .fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image())
                            .build());
        }
        else
        {
            ExtentManager
                    .getExtentTest()
                    .fail(message);
        }
    }

    public static void skip (String message, boolean isScreenshotNeeded) throws Exception {
        if (PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded) {
            ExtentManager
                    .getExtentTest()
                    .skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image())
                            .build());
        }
        else
        {
            ExtentManager
                    .getExtentTest()
                    .skip(message);
        }
    }
}
