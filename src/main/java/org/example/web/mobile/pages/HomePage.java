package org.example.web.mobile.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import org.example.web.mobile.common.HomePageBase;
import org.example.web.mobile.components.ProductItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends HomePageBase {

    @FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup")
    private List<ExtendedWebElement> productElements;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    private ExtendedWebElement menuButton;

    public HomePage(WebDriver driver) { super(driver); }

    @Override
    public List<ProductItem> getProducts() {
        return productElements.stream()
                .map(el -> new ProductItem(getDriver(), el.getElement()))
                .collect(Collectors.toList());
    }

    @Override
    public void openMenu() {
        menuButton.click();
    }

    @Override
    public void openCart() {
        cartButton.click();
    }
}
