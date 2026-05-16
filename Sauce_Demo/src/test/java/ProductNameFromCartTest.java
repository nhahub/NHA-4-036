import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;
import utils.AssertUtil;
import utils.WaitUtil;

public class ProductNameFromCartTest extends BaseTest {
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
        inventoryPage.openCart();

        // get product name from cart
        CartPage cartPage = new CartPage(driver);
        cartPage.getProductNameFromCart();

        String productNameFromCart = cartPage.getProductNameFromCart();
        System.out.println("Product Name from Cart: " + productNameFromCart);

          //Validation
         AssertUtil.assertTrue(
                 productNameFromCart.contains("Sauce Labs Backpack"),
                 "Product name in cart does not match expected",
                 driver,
                 "ProductNameMismatch."
         );




    }
}