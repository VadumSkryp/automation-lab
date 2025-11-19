package org.example.app.web2;

import org.example.web2.common.HomeBasePage;
import org.example.web2.common.components.Cart;
import org.example.web2.common.SearchResultsPageBase;
import org.example.web2.page.HomePage;
import org.example.web2.page.ShoppingCart;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePageTest extends BaseTest {

    @DataProvider(name = "searchKeywords")
    public Object[][] searchKeywords() {
        return new Object[][] {
                {"MacBook"},
                {"iPhone"},
                {"Samsung"}
        };
    }

    @Test
    public void openHomePageTest() {
        HomeBasePage home = new HomePage(getDriver());
        home.open();
        SoftAssert soft = new SoftAssert();

        Assert.assertTrue(home.isPageOpened(), "Home page not opened");
        soft.assertTrue(home.isLogoVisible(), "Logo not visible");
        soft.assertTrue(home.isFieldInputVisible(), "Search field not visible");
        soft.assertTrue(home.isMainMenuVisible(), "Menu not visible");

        soft.assertAll();
    }

    @Test(dataProvider = "searchKeywords")
    public void searchProductTest(String keyword) {
        HomeBasePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(),"Home page not opened");

        SearchResultsPageBase results = home.searchProduct(keyword);
        List<Cart> carts = results.getAllCards();

        SoftAssert soft = new SoftAssert();
        Assert.assertTrue(results.hasResult(), "No search results found");
        Assert.assertFalse(carts.isEmpty(), "No products found");

        for (Cart cart : carts) {
            soft.assertTrue(!cart.getTitleCart().isEmpty(), "Product title empty");
            soft.assertTrue(cart.getPrice() > 0, "Invalid product price");
        }

        soft.assertAll();
    }

    @Test
    public void addProductToCartTest() {
        HomeBasePage home = new HomePage(getDriver());
        home.open();
        SearchResultsPageBase results = home.searchProduct("MacBook");
        List<Cart> carts = results.getAllCards();

        Assert.assertTrue(results.hasResult(), "No search results found");
        Assert.assertFalse(carts.isEmpty(), "No products found");

        Cart first = carts.get(0);
        first.addProductToCart();
        Assert.assertTrue(results.isSuccessMessageVisible(), "Success message not shown");

        ShoppingCart cartPage = home.moveToShoppingCartPage();
        int quantity = cartPage.returnQuntityValue();

        Assert.assertTrue(cartPage.isLogoVisible(), "Logo not visible");
        Assert.assertTrue(cartPage.isTableCartVisible(), "Cart table not visible");
        Assert.assertEquals(quantity, 1, "Expected 1 item in cart");
    }
}
