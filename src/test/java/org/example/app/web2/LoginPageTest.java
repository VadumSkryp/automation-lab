package org.example.app.web2;

import org.example.web2.common.HomeBasePage;
import org.example.web2.common.MyAccountPageBase;
import org.example.web2.page.HomePage;
import org.example.web2.util.UserHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {



    @Test
    public void validLoginTest() {
        HomeBasePage home = new HomePage(getDriver());
        home.open();
        MyAccountPageBase account = UserHelper.registerUser(home, "Vadum", "Skryp", "098756942", "pass123");

        home = account.logout();
        Assert.assertTrue(home.getTitle().contains("Your Store"));

        account = UserHelper.loginUser(home, UserHelper.getLastEmail(), "pass123");
        Assert.assertTrue(account.getMessageSuccess().contains("My Account"), "Account page not found");
    }

    @Test
    public void invalidLoginTest() {
        HomeBasePage home = new HomePage(getDriver());
        home.open();
        UserHelper.registerUser(home, "Vadum", "Skryp", "098756942", "pass123");

        var loginPage = home.moveToLoginPage();
        loginPage.loginUser(UserHelper.getLastEmail(), "wrongPass");

        Assert.assertTrue(loginPage.getWarningMessage().contains(
                "Warning: No match for E-Mail Address and/or Password."
        ), "Expected warning not shown");
    }
}
