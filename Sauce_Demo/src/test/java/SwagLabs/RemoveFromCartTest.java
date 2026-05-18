package SwagLabs;
import org.testng.annotations.Test;

import SwagLabs.base.BaseTest;
import SwagLabs.pages.CartPage;
import SwagLabs.pages.InventoryPage;
import SwagLabs.pages.LoginPage;
import SwagLabs.utils.AssertUtil;

public class RemoveFromCartTest extends BaseTest {

    @Test
    public void removeFromCartTest() {


        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add product & open cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstProductToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);

        // Validate cart not empty
        AssertUtil.assertTrue(
                cartPage.isCartNotEmpty(),
                "Cart is empty before removal",
                driver,
                "CartEmptyBeforeRemove"
        );

        // Remove product
        cartPage.removeProductFromCart();

        // Validate cart empty
        AssertUtil.assertTrue(
                cartPage.isCartEmpty(),
                "Cart not empty after removal",
                driver,
                "CartNotEmptyAfterRemove"
        );

    }
}
