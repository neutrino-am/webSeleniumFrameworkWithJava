package com.am.constants;

import com.am.enums.ConfigProperties;
import com.am.utils.PropertyUtils;

public class FrameworkConstants {

    private FrameworkConstants(){
    }

    private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test";
    private static final String CHROMEDRIVERPATH = RESOURCESPATH+"/executables/chromedriver";
    private static final String GECKODRIVERPATH = RESOURCESPATH+"/executables/geckodriver";
    private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/properties";
    private static final String EXTENTREPORTFOLDERPATH= System.getProperty("user.dir")+"/ExtentReports";
    private static  String EXTENTREPORTFILEPATH= "";
    private static final int EXPLICITWAIT =20;
    private static final String ITERATIONDATASHEET = "DATA";
    private static final String EXCELPATH = RESOURCESPATH+"/resources/excel/testdata.xlsx";
    private static final String RUNMANGERSHEET = "RUNMANAGER";

    public static String getExtentReportFilePath() throws Exception {
        if (EXTENTREPORTFILEPATH.isEmpty()){
            EXTENTREPORTFILEPATH = createReportPath();
        }
        return EXTENTREPORTFILEPATH;
    }
    public static String createReportPath() throws Exception {
        if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
            return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"index.html";
        }
        else {
            return EXTENTREPORTFOLDERPATH+ "index.html";
        }
    }
    public static String getChromeDriverPath() { return CHROMEDRIVERPATH; }
    public static String getGeckoDriverPath()  { return GECKODRIVERPATH;}
    public static String getConfigFilePath() { return CONFIGFILEPATH; }
    public static int getExplicitWait() { return EXPLICITWAIT; }
    public static String getRunmangerDatasheet() { return RUNMANGERSHEET;}
    public static String getExcelpath() { return EXCELPATH;}
}
