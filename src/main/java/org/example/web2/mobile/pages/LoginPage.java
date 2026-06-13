package org.example.web2.mobile.pages;

import com.zebrunner.carina.utils.factory.DeviceType;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.example.web2.mobile.common.LoginPageBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @ExtendedFindBy(accessibilityId = "Login")
    private ExtendedWebElement loginText;

    @ExtendedFindBy(accessibilityId = "input-email")
    private ExtendedWebElement emailField;

    @ExtendedFindBy(accessibilityId = "input-password")
    private ExtendedWebElement passwordField;

    @ExtendedFindBy(accessibilityId = "button-LOGIN")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//*[@text='Please enter a valid email address']")
    private ExtendedWebElement errorMessage;

    @FindBy(id = "com.wdiodemoapp:id/alert_title")
    private ExtendedWebElement successMessage;



    public LoginPage(WebDriver driver) { super(driver); }

    @Override
    public boolean isLoginTextVisible() {
        return loginText.isVisible();
    }

    @Override
    public void login(String username, String password) {
        emailField.type(username);
        passwordField.type(password);
        submitButton.click();
    }

    @Override
    public boolean issuccessMessageVisible() {
        return successMessage.isVisible();

    }

    @Override
    public boolean isErrorMessageVisible() {
        return errorMessage.isVisible();
    }

}
