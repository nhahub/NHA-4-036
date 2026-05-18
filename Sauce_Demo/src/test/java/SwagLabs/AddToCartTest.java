package SwagLabs;
import org.testng.annotations.Test;

import SwagLabs.base.BaseTest;
import SwagLabs.pages.InventoryPage;
import SwagLabs.pages.LoginPage;
import SwagLabs.utils.AssertUtil;
import SwagLabs.utils.Wait;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartTest() {

        // Login
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        // Add product to cart
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addFirstProductToCart();

        Wait.wait_to_be_visible(driver, inventory.cartBadge);
        int cartCount = inventory.getCartCount();
        System.out.println("Cart count: " + cartCount);

// Validation
        AssertUtil.assertTrue(
                cartCount == 1,
                "Product not added to cart",
                driver,
                "AddToCartFailure"
        );



    }
}
