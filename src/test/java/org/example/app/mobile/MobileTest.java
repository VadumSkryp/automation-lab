package org.example.app.mobile;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.web2.mobile.common.HomePageBase;
import org.example.web2.mobile.common.LoginPageBase;
import org.example.web2.mobile.common.SettingsPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MobileTest implements IAbstractTest {

    @Test
    public void test1_homeLoginVisible() {
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(home.isLoginButtonVisible());
    }

    @Test
    public void test2_openLoginPage() {
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        LoginPageBase login = home.goToLoginPage();
        Assert.assertTrue(login.isLoginTextVisible());
    }

    @Test
    public void test3_loginValidUser() {
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        LoginPageBase login = home.goToLoginPage();
        login.login("user", "pass");
    }

    @Test
    public void test4_menuVisible() {
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(home.isMenuVisible());
    }

    @Test
    public void test5_openSettings() {
        SettingsPageBase settings = initPage(getDriver(), SettingsPageBase.class);
        Assert.assertTrue(settings.isSettingsTitleVisible());
    }

    @Test
    public void test6_toggleNotification() {
        SettingsPageBase settings = initPage(getDriver(), SettingsPageBase.class);
        settings.toggleOption("Notifications");
    }

    @Test
    public void test7_loginButtonExists() {
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(home.isLoginButtonVisible());
    }

    @Test
    public void test8_loginEmptyFields() {
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        LoginPageBase login = home.goToLoginPage();
        login.login("", "");
    }

    @Test
    public void test9_checkMenu() {
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(home.isMenuVisible());
    }

    @Test
    public void test10_navigateAllPages() {
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        LoginPageBase login = home.goToLoginPage();
        SettingsPageBase settings = initPage(getDriver(), SettingsPageBase.class);
        Assert.assertTrue(home.isLoginButtonVisible());
        Assert.assertTrue(login.isLoginTextVisible());
        Assert.assertTrue(settings.isSettingsTitleVisible());
    }
}
