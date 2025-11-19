package org.example.web2.mobile.pages;

import com.zebrunner.carina.utils.factory.DeviceType;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.web2.mobile.common.HomePageBase;
import org.example.web2.mobile.common.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//android.widget.Button[@content-desc='Login']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Menu']")
    private ExtendedWebElement menuButton;

    public HomePage(WebDriver driver) { super(driver); }

    @Override
    public boolean isLoginButtonVisible() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(loginButton)));
        return loginButton.isVisible();
    }

    @Override
    public LoginPageBase goToLoginPage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(loginButton)));
        loginButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public boolean isMenuVisible() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(menuButton)));
        return menuButton.isVisible();
    }
}
