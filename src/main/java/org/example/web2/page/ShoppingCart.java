package org.example.web2.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.web2.common.ShoppingCartBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart extends ShoppingCartBase {

    @FindBy(xpath = "//div[@id='logo']//a")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//div[@class='table-responsive']")
    private ExtendedWebElement tableCart;

    @FindBy(xpath = "//div[@class='input-group btn-block']//input")
    private ExtendedWebElement inputQuantity;


    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLogoVisible() {
        return logo.isVisible();
    }


    @Override
    public boolean isTableCartVisible() {
        return tableCart.isVisible();
    }

    @Override
    public int returnQuntityValue() {
        String text = inputQuantity.getAttribute("value");
        return Integer.parseInt(text);
    }



}
