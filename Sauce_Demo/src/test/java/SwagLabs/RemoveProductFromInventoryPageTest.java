package SwagLabs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SwagLabs.base.BaseTest;
import SwagLabs.pages.InventoryPage;


public class RemoveProductFromInventoryPageTest extends BaseTest {
    public InventoryPage inventoryPage;

    @Test
    public void checkoutFlowTest() {
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
        inventoryPage = new InventoryPage(driver);
    }
}
