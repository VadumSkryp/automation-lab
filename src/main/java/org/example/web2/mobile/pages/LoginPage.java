package org.example.web2.mobile.pages;

import com.zebrunner.carina.utils.factory.DeviceType;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.web2.mobile.common.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='Login']")
    private ExtendedWebElement loginText;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='Username']")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='Password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Submit']")
    private ExtendedWebElement submitButton;

    public LoginPage(WebDriver driver) { super(driver); }

    @Override
    public boolean isLoginTextVisible() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(loginText)));
        return loginText.isVisible();
    }

    @Override
    public void login(String username, String password) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(usernameField)));
        usernameField.type(username);
        passwordField.type(password);

        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(submitButton)));
        submitButton.click();
    }
}
