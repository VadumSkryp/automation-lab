package org.example.web2.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) { super(driver); }

    public abstract boolean isLoginTextVisible();
    public abstract void login(String username, String password);
}