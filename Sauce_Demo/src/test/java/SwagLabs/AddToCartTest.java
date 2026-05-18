package SwagLabs;
import SwagLabs.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SwagLabs.base.BaseTest;

public class AddToCartTest extends BaseTest {
    public InventoryPage inventoryPage;
    @Test
    public void addToCartTest() {

        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();

        // Add product to cart
        inventoryPage.addFirstProductToCart();
        inventoryPage.assert_successful_addition_to_cart();
    }

    @BeforeMethod
    @Override
    public void SetUp() {
        super.SetUp();
        inventoryPage = new InventoryPage(driver);
    }
}
