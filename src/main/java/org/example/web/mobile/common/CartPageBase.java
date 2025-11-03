package org.example.web.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import java.util.List;

public abstract class CartPageBase extends AbstractPage {
    public CartPageBase(WebDriver driver) { super(driver); }

    public abstract List<String> getCartItems();
    public abstract void removeFirstItem();
}
