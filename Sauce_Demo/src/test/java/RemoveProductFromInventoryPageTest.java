import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertUtil;
import utils.WaitUtil;

public class RemoveProductFromInventoryPageTest extends BaseTest {

    @Test
    public void checkoutFlowTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add product & go to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstProductToCart();
        inventoryPage.removeFirstProductFromInventory();

        CartPage cartPage = new CartPage(driver);
        WaitUtil.waitForInvisibility(driver,inventoryPage.cartBadge);

        int cartCount = inventoryPage.getCartCount();
        System.out.println("Cart count: " + cartCount);

// Validation
        AssertUtil.assertTrue(
                cartCount == 0,
                "Product not removed from cart",
                driver,
                "RemoveFromCartFailure"
        );




        // Validation


    }
}
