package SwagLabs.pages;

import SwagLabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginPage {

    private final WebDriver driver;

    // Locators
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By error_msg = By.cssSelector("[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public void enterUsername(String user) {
        ElementActions.send_data(driver, username, user);
    }

    public void enterPassword(String pass) {
        ElementActions.send_data(driver, password, pass);
    }

    public void clickLogin() {
        ElementActions.click_element(driver, loginBtn);
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    //Assertion
    public void assert_successful_Login(){
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.saucedemo.com/inventory.html"));
    }

    public void assert_unsuccessful_Login(){
        Assert.assertEquals(ElementActions.get_txt(driver, error_msg), "Epic sadface: Username and password do not match any user in this service");
    }

    public void assert_empty_username_field_Login(){
        Assert.assertEquals(ElementActions.get_txt(driver, error_msg), "Epic sadface: Username is required");
    }

    public void assert_empty_password_field_Login(){
        Assert.assertEquals(ElementActions.get_txt(driver, error_msg), "Epic sadface: Password is required");
    }

    public void assert_test_Login_Page_Shows_SwagLabs_Title(){
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

}
