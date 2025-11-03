package org.example.api.mobile;

import com.zebrunner.carina.core.IAbstractTest;

import org.example.web.mobile.common.CartPageBase;
import org.example.web.mobile.common.HomePageBase;
import org.example.web.mobile.components.ProductItem;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class CartTests implements IAbstractTest {

    private HomePageBase homePage;
    private CartPageBase cartPage;

    @BeforeMethod
    public void setup() {
        homePage = initPage(HomePageBase.class);
        homePage.openCart();
        cartPage = initPage(CartPageBase.class);
    }

    @Test
    public void testCartInitiallyEmpty() {
        List<String> items = cartPage.getCartItems();
        Assert.assertTrue(items.isEmpty(), "Cart should be empty initially");
    }

    @Test
    public void testAddProductToCart() {
        homePage = initPage(HomePageBase.class);
        List<ProductItem> products = homePage.getProducts();
        products.get(0).addToCart();

        homePage.openCart();
        cartPage = initPage(CartPageBase.class);
        List<String> cartItems = cartPage.getCartItems();
        Assert.assertEquals(cartItems.size(), 1, "Cart should contain 1 item after adding");
    }

    @Test
    public void testRemoveProductFromCart() {
        homePage = initPage(HomePageBase.class);
        List<ProductItem> products = homePage.getProducts();
        products.get(0).addToCart();

        homePage.openCart();
        cartPage = initPage(CartPageBase.class);

        cartPage.removeFirstItem();
        List<String> cartItems = cartPage.getCartItems();
        Assert.assertTrue(cartItems.isEmpty(), "Cart should be empty after removing item");
    }

    @Test
    public void testAddMultipleProducts() {
        homePage = initPage(HomePageBase.class);
        List<ProductItem> products = homePage.getProducts();
        for (int i = 0; i < 3; i++) {
            products.get(i).addToCart();
        }

        homePage.openCart();
        cartPage = initPage(CartPageBase.class);
        Assert.assertEquals(cartPage.getCartItems().size(), 3, "Cart should contain 3 items");
    }

    @Test
    public void testCartItemNamesMatchProducts() {
        homePage = initPage(HomePageBase.class);
        List<ProductItem> products = homePage.getProducts();
        ProductItem firstProduct = products.get(0);
        firstProduct.addToCart();

        homePage.openCart();
        cartPage = initPage(CartPageBase.class);

        List<String> cartItems = cartPage.getCartItems();
        Assert.assertEquals(cartItems.get(0), firstProduct.getTitle(), "Cart item name should match product title");
    }
}
