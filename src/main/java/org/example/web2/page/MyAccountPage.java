package org.example.web2.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.web2.common.MyAccountPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends MyAccountPageBase {

    @FindBy(xpath = "//div[@id='content']//h2")
    private ExtendedWebElement messageSuccess;

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    private ExtendedWebElement logoutButton;

    @FindBy(xpath = "//div[@class='pull-right']")
    private ExtendedWebElement ContinueButton;

    @FindBy(xpath = "//div[@id='content']")
    private ExtendedWebElement contentSuccess;


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getMessageSuccess() {
        return messageSuccess.getText();
    }

    @Override
    public boolean isRegistrationSuccessMessageDisplayed() {
        return contentSuccess.isElementPresent(10);
    }


    @Override
    public void waitUntilPageOpened() {
        contentSuccess.assertElementPresent(10);
    }


    @Override
    public HomePage logout() {
        logoutButton.click();
        ContinueButton.click();

        return new HomePage(getDriver());

    }
}
