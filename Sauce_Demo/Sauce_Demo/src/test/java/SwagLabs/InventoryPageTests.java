package SwagLabs;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryPageTests extends BaseTest {
    public SwagLabs.pages.InventoryPage inventoryPage;

    //Tests
    @Test(priority = 1)
    public void successful_logo_existence() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        inventoryPage.assert_logo_exist();
    }

    @Test(priority = 2)
    public void clickCartIconTest() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        // Add product to cart
        inventoryPage.openCart();
        inventoryPage.assert_cart_icon_is_clickable();
    }

    @Test(priority = 3)
    public void successful_burger_menu_existence_and_clickability() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        inventoryPage.clickMenu();
        inventoryPage.assert_burger_menu_is_clickable();
    }

    @Test(priority = 4)
    public void successful_all_items_existence_and_clickability() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        inventoryPage.openCart();
        inventoryPage.clickMenu();
        inventoryPage.click_AllItems();
        inventoryPage.assert_All_items_is_clickable();
    }

    @Test(priority = 5)
    public void successful_About_existence_and_clickability() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        inventoryPage.clickMenu();
        inventoryPage.click_About();
        inventoryPage.assert_About_is_clickable();
    }

    @Test(priority = 6)
    public void logoutTest() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        // Logout
        inventoryPage.clickMenu();
        inventoryPage.clickLogout();
        inventoryPage.assert_successful_Logout();
    }

    @Test(priority = 7)
    public void successful_Reset_App_State_existence_and_clickability() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        inventoryPage.addFirstProductToCart();
        inventoryPage.clickMenu();
        inventoryPage.click_ResetAppState();
        inventoryPage.assert_Reset_App_State_is_clickable();
    }
/*====================================================================================================================*/
    @Test(priority = 8)
    public void addToCartTest() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        // Add product to cart
        inventoryPage.addFirstProductToCart();
        inventoryPage.assert_successful_addition_to_cart();
    }

    @Test(priority = 9)
    public void removeProductFromInventoryTest() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        // Add product & go to cart
        inventoryPage.addFirstProductToCart();
        inventoryPage.removeFirstProductFromInventory();
        inventoryPage.assert_successful_removal_from_cart();
    }

    @BeforeMethod
    @Override
    public void SetUp() {
        super.SetUp();
        inventoryPage = new SwagLabs.pages.InventoryPage(driver);
    }

}