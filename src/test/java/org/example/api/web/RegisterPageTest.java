package org.example.api.web;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.web.common.HomePageBase;
import org.example.web.common.RegisterBasePage;
import org.example.web.desktop.HomePage;
import org.example.web.desktop.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest implements IAbstractTest {

    @Test
    public void OpenPage() {
        HomePageBase homePageBase = new HomePage(getDriver());
        homePageBase.open();
        Assert.assertTrue(getDriver().getTitle().contains("nopCommerce demo store. Home page title"));
        Assert.assertTrue(homePageBase.isPageOpened());
    }


    @Test
    public void registerCustomer() {
        RegisterBasePage registerBasePage = new RegisterPage(getDriver());
        registerBasePage.open();
        registerBasePage.moveToRegisterPage();
        registerBasePage.addCustomer("Vadum", "Skryp",
                "tovste333@gmail.com", "Kantemap9999");

        Assert.assertTrue(getDriver().getTitle().contains("nopCommerce demo store. Register"));
        Assert.assertEquals(registerBasePage.getSuccessMessageText(), "Your registration completed");

    }


}
