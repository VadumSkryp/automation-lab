package org.example.web.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class AbstractMenu extends AbstractUIObject {

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a")
    private List<ExtendedWebElement> menuItems;

    public AbstractMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isCategoryPresent(String categoryName) {
        return menuItems.stream().anyMatch(item -> item.getText().equalsIgnoreCase(categoryName));
    }

    public void clickCategory(String categoryName) {
        for (ExtendedWebElement item : menuItems) {
            if (item.getText().equalsIgnoreCase(categoryName)) {
                item.click();
                return;
            }
        }
        throw new RuntimeException("Category not found: " + categoryName);
    }
}
