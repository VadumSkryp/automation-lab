package org.example.web2.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.web2.page.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class MyAccountPageBase extends AbstractPage {

    public MyAccountPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getMessageSuccess();

    public abstract boolean isRegistrationSuccessMessageDisplayed();

    public abstract void waitUntilPageOpened();

    public abstract HomePage logout();



}
