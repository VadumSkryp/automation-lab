package org.example.web.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickLoginLink();
    public abstract void clickRegisterLink();
    public abstract boolean isSearchBoxPresent();
    public abstract void waitForSearchBox();
    public abstract boolean isLogoPresent();
    public abstract String getShoppingCartText();
    public abstract boolean isTopMenuCategoryPresent(String categoryName);
    public abstract boolean isSliderVisible();
    public abstract boolean isContactUsLinkVisible();
}
