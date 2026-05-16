import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertUtil;
import utils.WaitUtil;

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

        WaitUtil.waitForVisibility(driver, inventory.cartBadge);
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
