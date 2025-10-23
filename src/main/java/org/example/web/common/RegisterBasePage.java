package org.example.web.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class RegisterBasePage extends AbstractPage {

    public RegisterBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract void moveToRegisterPage();

    public abstract void addCustomer(String name,String surname,String email,String password);

    public abstract String getSuccessMessageText();



}
