package SwagLabs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import SwagLabs.pages.CartPage;
import SwagLabs.pages.CheckoutOverviewPage;
import SwagLabs.pages.CheckoutPage;
import SwagLabs.pages.InventoryPage;

public class CheckoutTests extends BaseTest {
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public CheckoutOverviewPage checkoutOverviewPage;

    @Test
    public void checkoutFlowTest() {
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();

        // Add product & go to cart
        inventoryPage.addFirstProductToCart();
        inventoryPage.openCart();
        inventoryPage.assert_cart_icon_is_clickable();

        cartPage.clickCheckout();
        cartPage.assert_checkout_clickability();

        checkoutPage.enterCheckoutDetails("Vironica", "Youssef", "15423");
        checkoutPage.clickContinue();
        checkoutPage.assert_continueBtn_clickability();

        // Finish order
        checkoutOverviewPage.clickFinish();
        checkoutOverviewPage.assert_successful_checkout();
    }

    @Test
    public void testCancelCheckoutReturnsToCart(){
        // Valid Login
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();

        // Add product & go to cart
        inventoryPage.addFirstProductToCart();
        inventoryPage.openCart();
        inventoryPage.assert_cart_icon_is_clickable();

        cartPage.clickCheckout();
        cartPage.assert_checkout_clickability();

        checkoutPage.enterCheckoutDetails("Vironica", "Youssef", "15423");
        checkoutPage.clickContinue();
        checkoutPage.assert_continueBtn_clickability();

        // Cancel order
        checkoutPage.clickCancel();
        checkoutPage.assert_click_Cancel();
    }
    @BeforeMethod
    @Override
    public void SetUp() {
        super.SetUp();
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }
}