package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtil;

public class LoginPage {

    WebDriver driver;

    // Locators
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public void enterUsername(String user) {
        WaitUtil.sendKeysToElement( driver,username, user);
    }

    public void enterPassword(String pass) {
        WaitUtil.sendKeysToElement(driver,password, pass);
    }

    public void clickLogin() {
        WaitUtil.clickElement(driver, loginBtn);
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

}
