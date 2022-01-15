package com.am.pages;

import com.am.enums.WaitStrategy;
import com.am.reports.ExtentLogger;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage {

    private final By textboxUsername = By.id ("email");
    private final By textboxPassword = By.xpath ("//input[@id='password' and @type ='password']");
    private final By btnLogin = By.xpath ("//button[@id ='login-button']");

    public String getTitle(){
        ExtentLogger.pass("User is on Login page");
        return getPageTitle();
    }

    public LoginPage enterUserName(String username) {
        sendKeys(textboxUsername,username, "Username ", WaitStrategy.CLICKABLE);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(textboxPassword,password, "password", WaitStrategy.CLICKABLE);
        return this;
    }

    public HomePage clickLoginButton() {
        click(btnLogin, "Login Button", WaitStrategy.CLICKABLE);
        return new HomePage();
    }

}
