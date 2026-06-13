package org.example.web2.mobile.pages;

import com.zebrunner.carina.utils.factory.DeviceType;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.example.web2.mobile.common.HomePageBase;
import org.example.web2.mobile.common.LoginPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @ExtendedFindBy(accessibilityId = "Login")
    private ExtendedWebElement loginButton;

    @ExtendedFindBy(accessibilityId = "Menu")
    private ExtendedWebElement menuButton;

    public HomePage(WebDriver driver) { super(driver); }

    @Override
    public boolean isLoginButtonVisible() {
        return loginButton.isVisible();
    }

    @Override
    public LoginPageBase goToLoginPage() {
        loginButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public boolean isMenuVisible() {
        return menuButton.isVisible();
    }
}
