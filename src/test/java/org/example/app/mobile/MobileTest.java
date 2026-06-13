package org.example.app.mobile;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.web2.mobile.common.HomePageBase;
import org.example.web2.mobile.common.LoginPageBase;
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
        login.login("svudova77@gmail.com", "nina9999");
        Assert.assertTrue(login.issuccessMessageVisible());
    }

    @Test
    public void test4_menuVisible() {
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(home.isMenuVisible());
    }

    @Test
    public void test7_loginButtonExists() {
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(home.isLoginButtonVisible());
    }

    @Test
    public void test8_shouldNotLoginWithInvalidEmail() {
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        LoginPageBase login = home.goToLoginPage();
        login.login("vadim", "yana9999");
        Assert.assertTrue(login.isErrorMessageVisible());

    }

    @Test
    public void test9_checkMenu() {
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(home.isMenuVisible());
    }


}
