package SwagLabs.pages;

import SwagLabs.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import SwagLabs.utils.ElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class InventoryPage {

    private final WebDriver driver;

    // App_Logo
    private final By app_logo = By.className("app_logo");

    // Menu & Its 4 options (Logout, All Items, About, Reset App State)
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By menu_item_list = By.className("bm-menu-wrap");
    private final By All_items = By.id("inventory_sidebar_link");
    private final By About = By.id("about_sidebar_link");
    private final By logoutLink = By.id("logout_sidebar_link");
    private final By Reset_app_state = By.id("reset_sidebar_link");

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

    // Actions
    // Open menu
    public void clickMenu() {
        ElementActions.click_element(driver, menuButton);
    }

    //All items
    public void click_AllItems() {
        ElementActions.click_element(driver, All_items);
    }

    //About
    public void click_About() {
        ElementActions.click_element(driver, About);
    }

    // Logout
    public void clickLogout() {
        ElementActions.click_element(driver, logoutLink);
    }

    // reset app state
    public void click_ResetAppState() {
        ElementActions.click_element(driver, Reset_app_state);
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



//Select dropdown = new Select(dropdownElement);
//    dropdown.selectByValue(value);}

    // Assertions
    public void assert_logo_exist() {
        Assert.assertEquals(ElementActions.get_txt(driver, app_logo), ("Swag Labs"));
    }

    public void assert_burger_menu_is_clickable() {
        Assert.assertTrue(Wait.wait_to_exist(driver, menu_item_list).isDisplayed());
    }

    public void assert_All_items_is_clickable() {
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.saucedemo.com/inventory.html"));
    }

    public void assert_About_is_clickable() {
        Assert.assertEquals(driver.getCurrentUrl(), ("https://saucelabs.com/"));
    }

    public void assert_Reset_App_State_is_clickable() {
        Assert.assertTrue(Wait.wait_to_hide(driver, cartBadge));
    }

    public void assert_successful_removal_from_cart() {
        Assert.assertTrue(Wait.wait_to_hide(driver, cartBadge));
    }

    public void assert_successful_Logout() {
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.saucedemo.com/"));
    }

    public void assert_successful_addition_to_cart() {
        Assert.assertTrue(Wait.wait_to_exist(driver, cartBadge).isDisplayed());

        int cartCount = Integer.parseInt((driver.findElement(cartBadge).getText()).trim());
        System.out.println("Cart count: " + cartCount);
        Assert.assertEquals(cartCount, 1);
    }

    public void assert_cart_icon_is_clickable() {
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.saucedemo.com/cart.html"));
    }
}