package swagLabs.tests;

import SwagLabs.pages.LoginPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    LoginPage lp;


    @Test(priority = 1)
    public void successfulLogin1() {
        lp.enter_username("standard_user");
        lp.enter_password("secret_sauce");
        lp.click_loginButton();
        lp.assert_successful_Login();
    }


    @Test(priority = 2)
    public void successfulLogin2() {
        lp.enter_username("error_user");
        lp.enter_password("secret_sauce");
        lp.click_loginButton();
        lp.assert_successful_Login();
    }


    @Test(priority = 3)
    public void unsuccessfulLogin_with_wrong_password() {
        lp.enter_username("error_user");
        lp.enter_password("12345$");
        lp.click_loginButton();
        lp.assert_unsuccessful_Login();
    }


    @Test(priority = 4)
    public void unsuccessfulLogin_with_empty_username() {
        lp.enter_username("");
        lp.enter_password("secret_sauce");
        lp.click_loginButton();
        lp.assert_empty_username_field_Login();
    }

    @Test(priority = 5)
    public void unsuccessfulLogin_with_empty_password() {
        lp.enter_username("standard_user");
        lp.enter_password("");
        lp.click_loginButton();
        lp.assert_empty_password_field_Login();
    }

    @Test(priority = 6)
    public void successfulLogin_then_logout() {
        lp.enter_username("standard_user");
        lp.enter_password("secret_sauce");
        lp.click_loginButton();
        lp.logout();
        lp.assert_successful_Logout();
    }


    //configurations
    @BeforeMethod
    public void setup() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        lp = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
