package SwagLabs;

import org.testng.annotations.Test;

import SwagLabs.base.BaseTest;

public class LoginTest extends BaseTest {


    @Test(priority = 1)
    public void validLoginTest() {
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
    }

    @Test(priority = 2)
    public void invalidLoginTest() {
        loginPage.login("standard_user", "secret_sauce123");
        loginPage.assert_unsuccessful_Login();
    }

    @Test(priority = 3)
    public void invalidLoginTest_empty_username_field() {
        loginPage.login("", "secret_sauce");
        loginPage.assert_empty_username_field_Login();
    }

    @Test(priority = 4)
    public void invalidLoginTest_empty_password_field() {
        loginPage.login("standard_user", "");
        loginPage.assert_empty_password_field_Login();
    }


}

