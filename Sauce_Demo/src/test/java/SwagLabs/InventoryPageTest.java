package SwagLabs;
import SwagLabs.base.BaseTest;
import SwagLabs.pages.InventoryPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseTest {
    public InventoryPage inventoryPage;

    //Tests
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

    @Test
    public void addToCartTest() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        // Add product to cart
        inventoryPage.addFirstProductToCart();
        inventoryPage.assert_successful_addition_to_cart();
    }

    @Test
    public void removeProductFromInventoryTest() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        // Add product & go to cart
        inventoryPage.addFirstProductToCart();
        inventoryPage.assert_successful_addition_to_cart();
        inventoryPage.removeFirstProductFromInventory();
        inventoryPage.assert_successful_removal_from_cart();
    }

    @Test
    public void clickCartIconTest() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        // Add product to cart
        inventoryPage.openCart();
        inventoryPage.assert_cart_icon_is_clickable();
    }

    @BeforeMethod
    @Override
    public void SetUp() {
        super.SetUp();
        inventoryPage = new InventoryPage(driver);
    }



}
