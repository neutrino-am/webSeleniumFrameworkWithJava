package com.am.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.am.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.util.Objects;

public final class ExtentReport {
    private ExtentReport() {
    }

    private static ExtentReports reports;

    public static void initReports () throws Exception {
        if (Objects.isNull(reports)) {
            reports = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            reports.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Test Report");
            spark.config().setReportName("EonBT ClientSite Test report");
        }
    }
    public static void flushReports () throws Exception {
        if (Objects.nonNull(reports)) {
            reports.flush();
            ExtentManager.unload();
        }
        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
    }
    public static void createTest( String testcasename) {
        ExtentManager.setExtentTest(reports.createTest(testcasename));
    }
}
