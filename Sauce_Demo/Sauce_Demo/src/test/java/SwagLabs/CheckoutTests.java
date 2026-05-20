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

    @Test(priority = 1)
    public void checkoutFlowTest_till_end() {
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

    @Test(priority = 2)
    public void checkoutFlowTest_but_cancel_from_checkout_step1() {
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assert_successful_Login();

        // Add product & go to cart
        inventoryPage.addFirstProductToCart();
        inventoryPage.openCart();
        inventoryPage.assert_cart_icon_is_clickable();

        cartPage.clickCheckout();
        cartPage.assert_checkout_clickability();

        // Cancel order from checkout step1
        checkoutPage.clickCancel_from_checkOut_step1();
        checkoutPage.assert_CancelBtn_from_checkOut_step1_clickability();
    }

    @Test(priority = 3)
    public void checkoutFlowTest_but_cancel_from_checkout_step2(){
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
        checkoutOverviewPage.clickCancel_from_checkOut_step2();
        checkoutOverviewPage.assert_CancelBtn_from_checkOut_step2_clickability();
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