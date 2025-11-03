package org.example.web.mobile.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import org.example.web.mobile.common.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Username and password do not match')]")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) { super(driver); }

    @Override
    public void typeUsername(String username) {
        usernameField.type(username);
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password);
    }

    @Override
    public void clickLoginButton() {
        loginButton.click();
    }

    @Override
    public boolean isErrorDisplayed() {
        return errorMessage.isElementPresent();
    }
}
