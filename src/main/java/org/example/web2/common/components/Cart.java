package org.example.web2.common.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Cart extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='caption']//a")
    private ExtendedWebElement title;

    @FindBy(xpath = "//p[@class='price']")
    private ExtendedWebElement price;

    @FindBy(xpath = ".//span[text()='Add to Cart']")
    private ExtendedWebElement addToCartButton;


    public Cart(WebDriver driver) {
        super(driver);
    }

    public Cart(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public String getTitleCart(){
        return title.getText().trim();
    }

    public Double getPrice(){
        String text = price.getText();
        text = text.split(" ")[0];
        text = text.replaceAll("[^0-9.]", "");
        return Double.parseDouble(text);
    }


    public void addProductToCart(){
           addToCartButton.scrollTo();
           addToCartButton.click();

    }





}
