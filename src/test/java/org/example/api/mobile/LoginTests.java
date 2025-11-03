package org.example.api.mobile;


import com.zebrunner.carina.core.IAbstractTest;
import org.example.web.mobile.common.LoginPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests implements IAbstractTest {

    @Test
    public void testValidLogin() {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();


        Assert.assertTrue(getDriver().getPageSource().contains("PRODUCTS"), "Home page not displayed after login");
    }

    @Test
    public void testInvalidLogin() {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        loginPage.typeUsername("wrong_user");
        loginPage.typePassword("wrong_pass");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed for invalid credentials");
    }
}
