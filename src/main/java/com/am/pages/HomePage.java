package com.am.pages;

import com.am.enums.WaitStrategy;
import com.am.reports.ExtentLogger;
import org.openqa.selenium.By;


public final class HomePage extends BasePage {

    //menu items
    private final By menuDashboard = By.xpath("//a[@href='#/dashboard/home']");
    private final By menuProducts = By.xpath("//a[@href='#/products']");
    private final By menuOrders = By.xpath("//a[@href='#/orders']");

    //cards
    private final By card_productWiseStatistics = By.xpath("//span[text() ='Product Wise']");
    private final By card_productInventoryStatistics = By.xpath("//span[text() ='Product Inventory Statistics']");

    //Product Wise  Statistics Card
    private final By dropdownProductWiseStatistics = By.xpath("//div[@class='ant-select ant-select-single ant-select-show-arrow']");
    private final By selectProductWiseStatistics = By.xpath("//div[@class='ant-select-item-option-content'][text()='Covid-19 Neutralizing Antibody']");

    public String getTitle() {
        ExtentLogger.pass("User is on Home page");
        return getPageTitle();
    }

    //cards

    public HomePage clickProductWiseStatistics() {
        click(card_productWiseStatistics, "Product Inventory Statistics Card ", WaitStrategy.CLICKABLE);
        return this;
    }

    public HomePage clickProductInventoryStatisticsCard() {
        click(card_productInventoryStatistics, "Product Inventory Statistics Card ", WaitStrategy.CLICKABLE);
        return this;
    }
    public HomePage clickDropdownProductWiseStatistics() {
        click(dropdownProductWiseStatistics, "Dropdown", WaitStrategy.CLICKABLE);
        return this;
    }

  public HomePage clickDashboardMenuItem() {
        click(menuDashboard, "Dashboard Menu Item", WaitStrategy.CLICKABLE);
        return this;
    }

    public HomePage clickProductMenuItem() {
        click(menuProducts, "Product Menu Button", WaitStrategy.CLICKABLE);
        return this;
    }

    public HomePage clickOrdersMenuItems() {
        click(menuOrders, "Orders Menu Button", WaitStrategy.CLICKABLE);
        return this;
    }

}
