package SwagLabs.pages;

import SwagLabs.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import SwagLabs.utils.ElementActions;
import org.testng.Assert;

public class InventoryPage {

    private final WebDriver driver;

    // Menu & Logout
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");

    // Products
    private final By addFirstAddToCartBtn = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
    private final By removeFirstProductBtn = By.xpath("(//button[contains(text(),'Remove')])[1]");

    // Cart
    private final By cartIcon = By.className("shopping_cart_link");
    private final By cartBadge = By.className("shopping_cart_badge");

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    // Open menu
    public void clickMenu() {
        ElementActions.click_element(driver, menuButton);
    }

    // Logout
    public void clickLogout() {
        ElementActions.click_element(driver, logoutLink);
    }

    // Add first product to cart
    public void addFirstProductToCart() {
        ElementActions.click_element(driver, addFirstAddToCartBtn);
    }

    // Remove product from inventory page
    public void removeFirstProductFromInventory() {
        ElementActions.click_element(driver, removeFirstProductBtn);
    }

    // Open cart page
    public void openCart() {
        ElementActions.click_element(driver, cartIcon);
    }

    // Assertions
    public void assert_successful_Logout() {
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.saucedemo.com/"));
    }

    public void assert_successful_addition_to_cart() {
        Assert.assertTrue(Wait.wait_to_exist(driver, cartBadge).isDisplayed());

        int cartCount = Integer.parseInt((driver.findElement(cartBadge).getText()).trim());
        System.out.println("Cart count: " + cartCount);
        Assert.assertEquals(cartCount, 1);
    }

    public void assert_successful_removal_from_cart() {
        Wait.wait_to_hide(driver, cartBadge);
    }

    public void assert_cart_icon_is_clickable() {
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.saucedemo.com/cart.html"));
    }
}