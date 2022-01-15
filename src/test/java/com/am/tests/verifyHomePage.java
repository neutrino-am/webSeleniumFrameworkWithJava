package com.am.tests;

import com.am.pages.*;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public final class verifyHomePage extends BaseTest {

    private verifyHomePage() {
    }

    @Test
    public void ValidateHomePage() {
        LoginPage e1 = new LoginPage();
        e1.enterUserName("id").enterPassword("pwd").clickLoginButton();
        HomePage e2 = new HomePage();
        assertThat(e2.getTitle())
                .as("Website | Home")
                .isNotNull();
    }

    @Test
    public void ValidateProductWiseStatisticsRecord() {
        LoginPage e1 = new LoginPage();
        e1.enterUserName("ID").enterPassword("pwd").clickLoginButton();
        HomePage e2 = new HomePage();
        e2.clickProductWiseStatistics();
        e2.clickDropdownProductWiseStatistics();
        //Validate Graph
    }
}
