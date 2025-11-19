package org.example.web2.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.web2.page.LoginPage;
import org.example.web2.page.RegisterPage;
import org.example.web2.page.ShoppingCart;
import org.openqa.selenium.WebDriver;


public abstract class HomeBasePage extends AbstractPage {

    public HomeBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLogoVisible();

    public abstract boolean isMainMenuVisible();

    public abstract boolean isFieldInputVisible();

    public abstract SearchResultsPageBase searchProduct(String keyword);

    public abstract ShoppingCart moveToShoppingCartPage();

    public abstract RegisterPage moveToRegisterPage();

    public abstract LoginPage moveToLoginPage();




}
