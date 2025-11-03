package org.example.web.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.web.mobile.components.ProductItem;
import org.openqa.selenium.WebDriver;
import java.util.List;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) { super(driver); }

    public abstract List<ProductItem> getProducts();
    public abstract void openMenu();
    public abstract void openCart();
}
