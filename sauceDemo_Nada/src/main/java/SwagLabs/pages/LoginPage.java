package SwagLabs.pages;

import SwagLabs.utils.ItemsActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private final WebDriver driver;
    //locators
    // to login
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By error_msg = By.cssSelector("[data-test='error']");
    // to logout
    private final By menu =By.id("react-burger-menu-btn");
    private final By logout =By.id("logout_sidebar_link");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Action
    public void enter_username(String username) {
        ItemsActions.send_date(driver, this.username, username);
    }

    public void enter_password(String password) {
        ItemsActions.send_date(driver, this.password, password);
    }

    public void click_loginButton() {
        ItemsActions.clicking(driver, loginButton);
    }

    public void logout(){
        ItemsActions.clicking(driver, menu);
        ItemsActions.clicking(driver, logout);
    }

    //Assertion
    public void assert_successful_Login(){
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.saucedemo.com/inventory.html"));
    }

    public void assert_unsuccessful_Login(){
        Assert.assertEquals(ItemsActions.get_txt(driver, error_msg), "Epic sadface: Username and password do not match any user in this service");
    }

    public void assert_empty_username_field_Login(){
        Assert.assertEquals(ItemsActions.get_txt(driver, error_msg), "Epic sadface: Username is required");
    }

    public void assert_empty_password_field_Login(){
        Assert.assertEquals(ItemsActions.get_txt(driver, error_msg), "Epic sadface: Password is required");
    }

    public void assert_successful_Logout(){
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.saucedemo.com/"));
    }

}
