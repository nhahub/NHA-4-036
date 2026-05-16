import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertUtil;

public class CheckoutTest extends BaseTest {

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

        // Checkout
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        cartPage.clickCheckout();
        checkoutPage.enterCheckoutDetails("Vironica", "Youssef", "15423");
        checkoutPage.clickContinue();

        // Finish order
        CheckoutOverviewPage overviewPage =
                new CheckoutOverviewPage(driver);
        overviewPage.clickFinish();

        // Validation
        String successMessage = overviewPage.getSuccessMessage();

        AssertUtil.assertTrue(
                successMessage.contains("Thank you for your order"),
                "Checkout failed or Success message not shown",
                driver,
                "CheckoutFailure."
        );

    }
}