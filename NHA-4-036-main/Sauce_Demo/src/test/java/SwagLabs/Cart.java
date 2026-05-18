package SwagLabs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import SwagLabs.pages.CartPage;
import SwagLabs.pages.InventoryPage;

public class Cart extends BaseTest {

    public InventoryPage inventoryPage;
    public CartPage cartPage;

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
    @Test
    public void clickCheckoutTest() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        // Add product & open cart
        inventoryPage.addFirstProductToCart();
        inventoryPage.openCart();
        cartPage.assert_isCartNotEmpty();
        String product_name = cartPage.getProductNameFromCart();
        System.out.println("ProductName: " + product_name);
        // Checkout
        cartPage.clickCheckout();
        cartPage.assert_checkout_clickability();
    }

    @Test
    public void testContinueShoppingReturnsToInventoryPage(){
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();
        // Add product & open cart
        inventoryPage.addFirstProductToCart();
        inventoryPage.openCart();
        cartPage.assert_isCartNotEmpty();
        String product_name = cartPage.getProductNameFromCart();
        System.out.println("ProductName: " + product_name);
        //Continue Shopping
        cartPage.clickContinueShopping();
        cartPage.assert_continue_shopping_clickability();

    }

    @BeforeMethod
    @Override
    public void SetUp() {
        super.SetUp();
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
    }
}
