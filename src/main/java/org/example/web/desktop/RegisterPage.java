package org.example.web.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import org.example.web.common.RegisterBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;



public class RegisterPage extends RegisterBasePage {


    @FindBy(xpath = "//a[text()='Register'] ")
    private ExtendedWebElement registerLink;

    @FindBy(xpath = "//input[@id='gender-male']")
    private ExtendedWebElement maleGenderRadio;

    @FindBy(xpath = "//input[@name='FirstName']")
    private ExtendedWebElement firstNameInput;

    @FindBy(xpath = "//input[@name='LastName']")
    private ExtendedWebElement lastNameInput;

    @FindBy(xpath = "//input[@name='Email']")
    private ExtendedWebElement emailInput;

//    @FindBy(xpath = "//input[@name='Company']")
//    private ExtendedWebElement companyInput;

    @FindBy(xpath = "//input[@id='Password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    private ExtendedWebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@id='register-button']")
    private ExtendedWebElement registerButton;

    @FindBy(xpath = "//a[text()='Continue']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//div[@class='result']")
    private ExtendedWebElement successMessage;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getSuccessMessageText() {
        return successMessage.getText();
    }


    @Override
    public void moveToRegisterPage() {
        registerLink.click();
        System.out.println("Register Page Open");
    }


    @Override
    public void addCustomer(String name,String surname,String email,String password) {

        maleGenderRadio.click();
        firstNameInput.type(name);
        lastNameInput.type(surname);
        emailInput.type(email);
        passwordInput.scrollTo();
        passwordInput.type(password);
        confirmPasswordInput.type(password);
        registerButton.scrollTo();
        registerButton.click();
        continueButton.click();


        System.out.println("User was registred");

    }


}



