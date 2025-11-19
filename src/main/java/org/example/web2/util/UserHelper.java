package org.example.web2.util;

import org.example.web2.common.HomeBasePage;
import org.example.web2.common.MyAccountPageBase;


import java.util.UUID;

public class UserHelper {

    private static String lastEmail;

    public static String generateEmail() {
        lastEmail = "user_" + UUID.randomUUID().toString().substring(0, 8) + "@mail.com";
        return lastEmail;
    }

    public static String getLastEmail() {
        return lastEmail;
    }

    public static MyAccountPageBase registerUser(HomeBasePage home, String firstName, String lastName,
                                                 String phone, String password) {
        return home.moveToRegisterPage()
                .registerUser(firstName, lastName, generateEmail(), phone, password, password);
    }

    public static MyAccountPageBase loginUser(HomeBasePage home, String email, String password) {
        return home.moveToLoginPage().loginUser(email, password);
    }
}
