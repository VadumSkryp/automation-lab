package org.example.app.web2;

import org.example.web2.common.HomeBasePage;
import org.example.web2.common.MyAccountPageBase;
import org.example.web2.page.HomePage;
import org.example.web2.page.RegisterPage;
import org.example.web2.util.UserHelper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {

    @DataProvider(name = "invalidRegistrationData")
    public Object[][] invalidRegistrationData() {
        return new Object[][] {
                {"","Markus","097342345","pass123","pass123","First Name must be between 1 and 32 characters!"},
                {"Vadim","Markus","097342345","pass123","wrong","Password confirmation does not match password!"},
                {"Vadim","Markus","097342345","invalidEmail","pass123","pass123","E-Mail Address does not appear to be valid!"}
        };
    }

    @Test(dataProvider = "invalidRegistrationData")
    public void invalidRegistrationTest(String first, String last, String phone,
                                        String password, String confirmPassword, String expectedError) {
        HomeBasePage home = new HomePage(getDriver());
        home.open();
        RegisterPage reg = home.moveToRegisterPage();
        reg.registerUser(first, last, UserHelper.generateEmail(), phone, password, confirmPassword);

        String actualError = reg.getErrorMessage();
        Assert.assertTrue(actualError.contains(expectedError), "Error message mismatch");
    }

    @Test
    public void validRegistrationTest() {
        HomeBasePage home = new HomePage(getDriver());
        home.open();
        MyAccountPageBase account = UserHelper.registerUser(home, "Vadum", "Skryp", "098756942", "pass123");

        Assert.assertTrue(account.isRegistrationSuccessMessageDisplayed(), "Success message not shown");
        Assert.assertTrue(account.getMessageSuccess().contains("My Account"), "Account page not found");
    }


    @Test
    public void logoutTest() {
        HomeBasePage home = new HomePage(getDriver());
        home.open();
        MyAccountPageBase account = UserHelper.registerUser(home, "Vadum", "Skryp", "098756942", "pass123");

        home = account.logout();
        Assert.assertTrue(home.getTitle().contains("Your Store"), "Home page not opened after logout");
    }
}
