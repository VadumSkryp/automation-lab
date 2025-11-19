package org.example.web2.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.web2.common.components.Cart;
import org.example.web2.page.ShoppingCart;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SearchResultsPageBase extends AbstractPage {


    public SearchResultsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean hasResult();

    public abstract List<Cart> getAllCards();

    public abstract boolean isSuccessMessageVisible();

    public abstract ShoppingCart movetoShoppingCart();


}
