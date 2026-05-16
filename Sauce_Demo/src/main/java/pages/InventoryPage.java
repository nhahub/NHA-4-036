package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtil;

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
        WaitUtil.clickElement(driver, menuButton);
    }

    // Logout
    public void clickLogout() {
        WaitUtil.clickElement(driver, logoutLink);
    }

    // Add first product to cart
    public void addFirstProductToCart() {
        WaitUtil.clickElement(driver, firstAddToCartBtn);
    }

    // Remove product from inventory page
    public void removeFirstProductFromInventory() {
        WaitUtil.clickElement(driver, removeFirstProductBtn);
    }

    // Get cart count
    public int getCartCount() {
        try {
            String countText = WaitUtil.getTextFromElement(driver, cartBadge);
            return Integer.parseInt(countText.trim());
        }
        catch (Exception e) {
            return 0;
        }}

    // Open cart page
    public void openCart() {
        WaitUtil.clickElement(driver, cartIcon);
    }}