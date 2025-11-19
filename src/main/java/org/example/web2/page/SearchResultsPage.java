package org.example.web2.page;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.web2.common.components.Cart;
import org.example.web2.common.SearchResultsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends SearchResultsPageBase {


    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private ExtendedWebElement alertMessage;

    @FindBy(xpath = "//div[@class='product-thumb']")
    private List<Cart> productItems;

    @FindBy(xpath = "//div[@id='logo']//a")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//a[@title='Shopping Cart']")
    private ExtendedWebElement shoppingCartLink;



    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean hasResult() {
        return !productItems.isEmpty();
    }

    @Override
    public List<Cart> getAllCards() {
        return productItems;
    }


    @Override
    public boolean isSuccessMessageVisible() {
      return alertMessage.isVisible();
    }


    @Override
    public ShoppingCart movetoShoppingCart() {
        shoppingCartLink.click();
        return new ShoppingCart(getDriver());
    }


}
