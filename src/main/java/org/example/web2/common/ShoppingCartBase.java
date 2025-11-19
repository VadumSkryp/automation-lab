package org.example.web2.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ShoppingCartBase extends AbstractPage {

    public ShoppingCartBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLogoVisible();

    public abstract boolean isTableCartVisible();

    public abstract int returnQuntityValue();


}
