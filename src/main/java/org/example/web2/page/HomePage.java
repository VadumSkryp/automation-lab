package org.example.web2.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.web2.common.HomeBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class HomePage extends HomeBasePage {

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    private ExtendedWebElement buttonSearch;

    @FindBy(xpath = "//div[@id='logo']//a")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//input[@name='search']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//nav[@id='menu']")
    private ExtendedWebElement menuBorder;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    private ExtendedWebElement shopinCartLink;

    @FindBy(xpath = "//span[@class='caret']")
    private ExtendedWebElement caret;

    @FindBy(xpath = "//uL[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")
    private ExtendedWebElement registerLink;

    @FindBy(xpath = "//uL[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
    private ExtendedWebElement loginLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLogoVisible() {
        return logo.isVisible();
    }

    @Override
    public boolean isMainMenuVisible() {
        return menuBorder.isVisible();
    }

    @Override
    public boolean isFieldInputVisible() {
        return searchInput.isVisible();
    }

    @Override
    public SearchResultsPage searchProduct(String keyword) {
        searchInput.type(keyword);
        buttonSearch.click();
        return new SearchResultsPage(getDriver());
    }

    @Override
    public ShoppingCart moveToShoppingCartPage() {
        shopinCartLink.click();
        return new ShoppingCart(getDriver());
    }


    @Override
    public RegisterPage moveToRegisterPage() {
        caret.click();
        registerLink.click();
        return new RegisterPage(getDriver());
    }


    @Override
    public LoginPage moveToLoginPage() {
        caret.click();
        loginLink.click();
        return new LoginPage(getDriver());
    }


}
