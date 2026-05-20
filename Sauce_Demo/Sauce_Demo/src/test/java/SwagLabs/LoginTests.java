package SwagLabs;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTests extends BaseTest {

    @Test(priority = 1)
    public void testLoginPageShowsSwagLabsTitle(){
        loginPage.assert_test_Login_Page_Shows_SwagLabs_Title();
    }

    @Test(priority = 2)
    public void validLoginTest() {
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
    }

    @Test(priority = 3)
    public void invalidLoginTest() {
        loginPage.login("standard_user", "secret_sauce123");
        loginPage.assert_unsuccessful_Login();
    }

    @Test(priority = 4)
    public void invalidLoginTest_empty_username_field() {
        loginPage.login("", "secret_sauce");
        loginPage.assert_empty_username_field_Login();
    }

    @Test(priority = 5)
    public void invalidLoginTest_empty_password_field() {
        loginPage.login("standard_user", "");
        loginPage.assert_empty_password_field_Login();
    }

    /*============================= Data Provider =============================*/
/*
    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"visual_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }

    @Test(priority = 3, dataProvider = "loginData")
    public void validLoginTest_with_data_provider(String username, String password) {

        loginPage.login(username, password);
        loginPage.assert_successful_Login();
    }
*/
}
