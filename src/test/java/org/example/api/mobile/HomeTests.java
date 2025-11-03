package org.example.api.mobile;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.web.mobile.common.HomePageBase;
import org.example.web.mobile.components.ProductItem;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class HomeTests implements IAbstractTest {

    private HomePageBase homePage;

    @BeforeMethod
    public void setup() {
        homePage = initPage(HomePageBase.class);
    }

    @Test
    public void testProductListNotEmpty() {
        List<ProductItem> products = homePage.getProducts();
        Assert.assertFalse(products.isEmpty(), "Product list should not be empty");
    }

    @Test
    public void testAllProductsHaveTitleAndPrice() {
        List<ProductItem> products = homePage.getProducts();
        for (ProductItem item : products) {
            Assert.assertFalse(item.getTitle().isEmpty(), "Product title should not be empty");
            Assert.assertFalse(item.getPrice().isEmpty(), "Product price should not be empty");
        }
    }

    @Test
    public void testOpenCartFromHome() {
        homePage.openCart();
        Assert.assertTrue(getDriver().getPageSource().contains("YOUR CART"), "Cart page not opened");
    }

    @Test
    public void testOpenMenu() {
        homePage.openMenu();
        Assert.assertTrue(getDriver().getPageSource().contains("MENU"), "Menu should be displayed");
    }
}
