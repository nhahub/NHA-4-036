package SwagLabs.pages;


import SwagLabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {

    private final WebDriver driver;

    // Locators
    private final By cartItems = By.className("cart_item");
    private final By productName = By.className("inventory_item_name");
    private final By removeBtn = By.xpath("//button[contains(text(),'Remove')]");
    private final By checkoutBtn = By.id("checkout");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public void removeProductFromCart() {
        ElementActions.click_element(driver, removeBtn);
    }

    public String getProductNameFromCart() {
        try {
            return ElementActions.get_txt(driver,productName);
        } catch (Exception e) {
            return null;
        }
    }
    public void clickCheckout() {
        ElementActions.click_element(driver, checkoutBtn);
    }

    //Assertions
    public void assert_isCartNotEmpty() {
        Assert.assertFalse(driver.findElements(cartItems).isEmpty());
    }
    public void assert_isCartEmpty() {
        Assert.assertTrue(driver.findElements(cartItems).isEmpty());
    }
    public void assert_checkout_clickability(){
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.saucedemo.com/checkout-step-one.html"));
    }
}

