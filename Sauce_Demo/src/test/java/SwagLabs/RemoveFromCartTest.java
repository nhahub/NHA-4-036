package SwagLabs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SwagLabs.base.BaseTest;
import SwagLabs.pages.CartPage;
import SwagLabs.pages.InventoryPage;

public class RemoveFromCartTest extends BaseTest {

    public InventoryPage inventoryPage;
    CartPage cartPage;

    @Test
    public void removeFromCartTest() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();

        // Add product & open cart
        inventoryPage.addFirstProductToCart();
        inventoryPage.openCart();
        cartPage.assert_isCartNotEmpty();
        String product_name = cartPage.getProductNameFromCart();
        System.out.println("ProductName: " + product_name);

        // Remove product
        cartPage.removeProductFromCart();
        cartPage.assert_isCartEmpty();

    }

    @BeforeMethod
    @Override
    public void SetUp() {
        super.SetUp();
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
    }
}
