package com.am.tests;

import com.am.pages.HomePage;
import com.am.pages.LoginPage;
import com.am.reports.ExtentLogger;
import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.Test;

public final class VerifyLogin extends BaseTest{

    private VerifyLogin () {
    }


    @Test
    public void verifyValidUserLogin() {
        LoginPage e1 = new LoginPage();
        e1.enterUserName("id")
                .enterPassword("pwd");
                e1.clickLoginButton();
        HomePage e2 = new HomePage();
        assertThat(e1.getTitle())
                .as("Website | Home");
    }
    @Test
    public void verifyInvalidUserLogin() {
        LoginPage e1 = new LoginPage();
        e1.enterUserName("id").enterPassword("pwd").clickLoginButton();
        //verify invalid credentials message
    }

}