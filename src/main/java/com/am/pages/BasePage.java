package com.am.pages;

import com.am.driver.DriverManager;
import com.am.enums.WaitStrategy;
import com.am.factories.ExplicitWaitFactory;
import com.am.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {

    // returns the title of the page
    public String getPageTitle() {
        return DriverManager.getDriver()
                .getTitle();
    }

    // clicks the element
    protected void click(By elementToBeClicked, String elementName, WaitStrategy waitstrategy) {
        ExplicitWaitFactory.performExplicitWait(waitstrategy, elementToBeClicked)
                .click();
        try {
            ExtentLogger.pass(elementName+ " is clicked",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //verifies if element is present
    protected void isVisible(By by, WaitStrategy waitstrategy) {
        ExplicitWaitFactory.performExplicitWait(waitstrategy, by)
                .isDisplayed();
        try {
            ExtentLogger.pass("Element is visible ", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Enters test to a textbox
    protected void sendKeys(By by,String value,String elementName, WaitStrategy waitstrategy) {
        ExplicitWaitFactory.performExplicitWait(waitstrategy, by)
                .sendKeys(value);
        try {
            ExtentLogger.pass(value+" value was entered successfully in "+elementName, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Clicks Tab Key
    protected void tabField(By element) {
        DriverManager.getDriver().findElement(element)
                .sendKeys(Keys.TAB);
    }

    // Clears the textbox field
    protected void clearField(By by,WaitStrategy waitstrategy) {
        ExplicitWaitFactory.performExplicitWait(waitstrategy, by)
                .click();
        DriverManager.getDriver().findElement(by).clear();
    }

    // returns the text of the element
    protected String getTextFromField(By by,WaitStrategy waitstrategy) {
        ExplicitWaitFactory.performExplicitWait(waitstrategy, by)
                .click();
        return DriverManager.getDriver().findElement(by).getText();
    }

    protected void browserBackButton() {
        DriverManager.getDriver().navigate().back();
    }

    protected void refreshBrowser() {
        DriverManager.getDriver().navigate().refresh();
    }

    protected void navigateBrowserToUrl(String url) {
        DriverManager.getDriver().navigate().to(url);
    }

    protected void clickButtonFromLeftElement(By element, By locatorToBeClicked ,WaitStrategy waitstrategy){
        ExplicitWaitFactory.performExplicitWait(waitstrategy, element);
        DriverManager.getDriver().findElement(with(locatorToBeClicked).toLeftOf(element))
                .click();
    }

    public void uploadFile (By button, String filePath ) {
        DriverManager.getDriver()
                .findElement(button)
                .sendKeys(System.getProperty("user.dir")+filePath);
        //give path as "/src/test/resources/"
    }

    public List<String> getTableHeaderValues(By tableHeaderLocator ) {
        return DriverManager.getDriver().findElements(tableHeaderLocator)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        // give xpath to locator to headers like //*[@id='table']/div/div/table/thead/tr/th
    }

    public List<String> getValuesOfRow( String tablevalues, int rowNum){
        String temp = String.format(tablevalues,rowNum );
        return DriverManager.getDriver().findElements(By.xpath(temp))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    public int getNumberOfRowsOfTable() {
        return DriverManager.getDriver()
                .findElements(By.xpath("//table/tbody/tr"))
                .size();
    }

    public void clickBackSpaceKey (By button) {
        DriverManager.getDriver().findElement(button)
                .sendKeys(Keys.BACK_SPACE);
                //.sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.DELETE));
    }

    public String getLocalTime () {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }
}
