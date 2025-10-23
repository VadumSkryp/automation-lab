package org.example.api.web;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.web.desktop.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest implements IAbstractTest {

    @Test
    public void searchBoxIsVisible() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.waitForSearchBox();
        Assert.assertTrue(homePage.isSearchBoxPresent(), "Search box should be visible");
    }

    @Test
    public void clickLoginLinkTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickLoginLink();
        Assert.assertTrue(getDriver().getTitle().contains("Login"), "Login page title check");
    }

    @Test
    public void clickRegisterLinkTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickRegisterLink();
        Assert.assertTrue(getDriver().getTitle().contains("Register"), "Register page title check");
    }

    @Test
    public void logoIsVisible() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isLogoPresent(), "Logo should be visible");
    }

    @Test
    public void shoppingCartTextTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertEquals(homePage.getShoppingCartText(), "Shopping cart", "Shopping cart text mismatch");
    }

    @Test
    public void booksCategoryIsVisible() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isTopMenuCategoryPresent("Books"), "Books category should be visible");
    }

    @Test
    public void computersCategoryIsVisible() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isTopMenuCategoryPresent("Computers"), "Computers category should be visible");
    }

    @Test
    public void electronicsCategoryIsVisible() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isTopMenuCategoryPresent("Electronics"), "Electronics category should be visible");
    }

    @Test
    public void contactUsLinkIsVisible() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isContactUsLinkVisible(), "Contact us link should be visible");
    }

    @Test
    public void sliderIsVisible() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isSliderVisible(), "Slider should be visible");
    }

    @Test
    public void verifyMenuCategories() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.getMenu().isCategoryPresent("Books"), "Books category is not present!");
        homePage.getMenu().clickCategory("Books");

        Assert.assertTrue(getDriver().getTitle().contains("Books"), "Books page didn't open!");
    }
}
