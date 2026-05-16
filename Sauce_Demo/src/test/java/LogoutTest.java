import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertUtil;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Logout
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickMenu();
        inventoryPage.clickLogout();

        // Validation
        String currentUrl = driver.getCurrentUrl();

        AssertUtil.assertTrue(
                currentUrl.contains("saucedemo.com"),
                "Logout failed or user not redirected to login page",
                driver,
                "LogoutFailure");
    }
}


