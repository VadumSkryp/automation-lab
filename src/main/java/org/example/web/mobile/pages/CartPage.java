package org.example.web.mobile.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;


import org.example.web.mobile.common.CartPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends CartPageBase {

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
    private List<ExtendedWebElement> cartItems;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-REMOVE']")
    private List<ExtendedWebElement> removeButtons;

    public CartPage(WebDriver driver) { super(driver); }

    @Override
    public List<String> getCartItems() {
        return cartItems.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    @Override
    public void removeFirstItem() {
        if (!removeButtons.isEmpty()) {
            removeButtons.get(0).click();
        }
    }
}
