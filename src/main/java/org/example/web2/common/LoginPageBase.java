package org.example.web2.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.web2.page.MyAccountPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {


    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract MyAccountPage loginUser(String name , String password);

    public abstract String getWarningMessage();




}
