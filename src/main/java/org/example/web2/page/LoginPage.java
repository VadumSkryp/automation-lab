package org.example.web2.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.web2.common.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//input[@id='input-email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[@id='input-password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private ExtendedWebElement warningMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MyAccountPage loginUser(String name, String password) {
        emailInput.type(name);
        passwordInput.type(password);
        loginButton.click();
        return new MyAccountPage(getDriver());
    }


    @Override
    public String getWarningMessage() {
        return warningMessage.getText();
    }
}
