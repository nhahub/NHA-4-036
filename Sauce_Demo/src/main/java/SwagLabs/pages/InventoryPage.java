package SwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import SwagLabs.utils.ElementActions;
import org.testng.Assert;

public class InventoryPage {

    WebDriver driver;
    WebDriverWait wait;


    // Constructor

    // Menu & Logout
    By menuButton = By.id("react-burger-menu-btn");
    By logoutLink = By.id("logout_sidebar_link");

    // Products
    By firstAddToCartBtn = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
    By removeFirstProductBtn = By.xpath("(//button[contains(text(),'Remove')])[1]");

    // Cart
    By cartIcon = By.className("shopping_cart_link");
    public By cartBadge = By.className("shopping_cart_badge");

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
        ElementActions.click_element(driver, firstAddToCartBtn);
    }

    // Remove product from inventory page
    public void removeFirstProductFromInventory() {
        ElementActions.click_element(driver, removeFirstProductBtn);
    }

    // Get cart count
    public int getCartCount() {
        try {
            String countText = ElementActions.get_txt(driver, cartBadge);
            return Integer.parseInt(countText.trim());
        }
        catch (Exception e) {
            return 0;
        }}

    // Open cart page
    public void openCart() {
        ElementActions.click_element(driver, cartIcon);
    }

    // Assertions
    public void assert_successful_Logout(){
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.saucedemo.com/"));
    }

}