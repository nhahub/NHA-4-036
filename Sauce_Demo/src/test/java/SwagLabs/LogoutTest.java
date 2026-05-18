package SwagLabs;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SwagLabs.base.BaseTest;
import SwagLabs.pages.InventoryPage;

public class LogoutTest extends BaseTest {

    public InventoryPage inventoryPage;

    @Test
    public void logoutTest() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        // Logout
        inventoryPage.clickMenu();
        inventoryPage.clickLogout();
        inventoryPage.assert_successful_Logout();
    }

    @BeforeMethod
    @Override
    public void SetUp() {
        super.SetUp();
        inventoryPage = new InventoryPage(driver);
    }

}