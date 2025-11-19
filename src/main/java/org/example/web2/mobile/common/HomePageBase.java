package org.example.web2.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) { super(driver); }

    public abstract boolean isLoginButtonVisible();
    public abstract LoginPageBase goToLoginPage();
    public abstract boolean isMenuVisible();
}