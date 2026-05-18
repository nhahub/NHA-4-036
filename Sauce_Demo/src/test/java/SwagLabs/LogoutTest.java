package SwagLabs;
import org.testng.annotations.Test;

import SwagLabs.base.BaseTest;
import SwagLabs.pages.InventoryPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();

        // Logout
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickMenu();
        inventoryPage.clickLogout();

        inventoryPage.assert_successful_Logout();

    }

}


