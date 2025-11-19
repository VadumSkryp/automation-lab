package org.example.web2.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class RegisterBasePage extends AbstractPage {

    public RegisterBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract MyAccountPageBase registerUser(String firstname,String lastname,String email,String
                                      telephone,String password,String confirm);


    public abstract String getErrorMessage();



}
