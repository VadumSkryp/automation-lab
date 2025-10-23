package org.example.web.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.web.common.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends HomePageBase {

    @FindBy(xpath = "//a[text()='Log in']")
    private ExtendedWebElement loginLink;

    @FindBy(xpath = "//a[text()='Register']")
    private ExtendedWebElement registerLink;

    @FindBy(xpath = "//input[@id='small-searchterms']")
    private ExtendedWebElement searchBox;

    @FindBy(xpath = "//div[@class='header-logo']")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//span[@class='cart-label']")
    private ExtendedWebElement shoppingCart;

    @FindBy(xpath = "//div[@id='nivo-slider']")
    private ExtendedWebElement slider;

    @FindBy(xpath = "//a[text()='Contact us']")
    private ExtendedWebElement contactUsLink;

    @FindBy(xpath = "//ul[@class='top-menu']//a")
    private List<ExtendedWebElement> topMenuLinks;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']")
    private ExtendedWebElement menuContainer;

    private HomePageMenu menu;

    public HomePage(WebDriver driver) {
        super(driver);
        menu = new HomePageMenu(driver, menuContainer.getElement());

    }


    public HomePageMenu getMenu() {
        return menu;
    }

    @Override
    public void clickLoginLink() {
        loginLink.click();
    }

    @Override
    public void clickRegisterLink() {
        registerLink.click();
    }

    @Override
    public boolean isSearchBoxPresent() {
        return searchBox.isElementPresent();
    }

    @Override
    public void waitForSearchBox() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchBox.getElement()));
    }

    @Override
    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }

    @Override
    public String getShoppingCartText() {
        return shoppingCart.getText();
    }

    @Override
    public boolean isTopMenuCategoryPresent(String categoryName) {
        for (ExtendedWebElement link : topMenuLinks) {
            if (link.getText().equalsIgnoreCase(categoryName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSliderVisible() {
        return slider.isElementPresent();
    }

    @Override
    public boolean isContactUsLinkVisible() {
        return contactUsLink.isElementPresent();
    }
}
