import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.WaitUtil;

import static org.testng.TestRunner.PriorityWeight.priority;

public class LoginTest extends BaseTest {


    @Test(priority = 1)
    public void validLoginTest() {

        loginPage.login("standard_user", "secret_sauce");

        boolean isLoginSuccessful = driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(isLoginSuccessful, "Login failed!");
    }

    @Test(priority = 2)
    public void invalidLoginTest() {
        loginPage.login("standard_user", "secret_sauce123");

        By error_msg = By.cssSelector("[data-test='error']");
        boolean is_not_LoginSuccessful = (WaitUtil.getTextFromElement(driver, error_msg).equals("Epic sadface: Username and password do not match any user in this service"));
        Assert.assertTrue(is_not_LoginSuccessful, "Login passed!");
    }

}

