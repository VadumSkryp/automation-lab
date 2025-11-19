package org.example.web2.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.web2.common.MyAccountPageBase;
import org.example.web2.common.RegisterBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends RegisterBasePage {

    @FindBy(xpath = "//input[@id='input-firstname']")
    private ExtendedWebElement inputFirstname;

    @FindBy(xpath = "//input[@id='input-lastname']")
    private ExtendedWebElement inputLastname;

    @FindBy(xpath = "//input[@id='input-email']")
    private ExtendedWebElement inputEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    private ExtendedWebElement inputTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    private ExtendedWebElement inputPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    private ExtendedWebElement inputConfirm;

    @FindBy(xpath = "//input[@type='checkbox']")
    private ExtendedWebElement checkboxPolicy;

    @FindBy(xpath = "//input[@type='submit']")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[@class='text-danger']")
    private ExtendedWebElement errorText;

    @FindBy(xpath = "//div[@class='pull-right']")
    private ExtendedWebElement continueButton;



    public RegisterPage(WebDriver driver) {
        super(driver);
    }




    @Override
    public MyAccountPageBase registerUser(String firstname, String lastname, String email, String telephone, String password, String confirm) {
        inputFirstname.type(firstname);
        inputLastname.type(lastname);
        inputEmail.type(email);
        inputTelephone.type(telephone);
        inputPassword.type(password);
        inputConfirm.type(confirm);

        checkboxPolicy.scrollTo();
        checkboxPolicy.click();
        submitButton.click();
        continueButton.click();

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        myAccountPage.waitUntilPageOpened();

        return myAccountPage;

    }


    @Override
    public String getErrorMessage() {
        return errorText.getText();
    }
}
