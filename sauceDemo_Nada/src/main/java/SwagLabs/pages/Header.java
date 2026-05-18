package SwagLabs.pages;

import SwagLabs.utils.ItemsActions;
import SwagLabs.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Header {
    //variables
    private final WebDriver driver;

    //locators
    private final By app_logo = By.className("app_logo");
    private final By cart_icon = By.cssSelector("[data-test='shopping-cart-link']");
    private final By menu = By.id("react-burger-menu-btn");
    private final By menu_item_list = By.className("bm-menu-wrap");

    private final By All_items = By.id("inventory_sidebar_link");

    private final By About = By.id("about_sidebar_link");

    private final By cart_badge = By.cssSelector("[data-test='shopping-cart-badge']");
    private final By Add_backpack_To_Cart = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    private final By Reset_app_state = By.id("reset_sidebar_link");


    //constructor
    public Header(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    // 1 --> need to check if the swag labs logo exist -->(no actions)

    // 2 --> need to check if cart icon  exists, clickable and direct me to cart page
    public void click_cart_icon() {
        ItemsActions.clicking(driver, cart_icon);
    }

    // 3 --> need to check if burger menu exists, clickable and has all 4 options (All items, About, logout, reset app state)
    public void click_burger_menu() {
        ItemsActions.clicking(driver, menu);
    }

    // 4 --> need to check if the 4 burger menu options (All items, About, logout, reset app state) are clickable
    //All items
    public void click_AllItems() {
        ItemsActions.clicking(driver, All_items);
    }

    //About
    public void click_About() {
        ItemsActions.clicking(driver, About);
    }

    // logout already checked in LoginPage

    // reset app state
    // Add  product to cart
    public void addProductToCart() {
        ItemsActions.clicking(driver, Add_backpack_To_Cart);
    }

    public void click_ResetAppState() {
        ItemsActions.clicking(driver, Reset_app_state);
    }


    //assertion
    public void assert_logo_exist() {
        Assert.assertEquals(ItemsActions.get_txt(driver, app_logo), ("Swag Labs"));
    }

    public void assert_cart_icon_is_clickable() {
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.saucedemo.com/cart.html"));
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

    public void assert_cart_badge_exist() {
        Assert.assertTrue(Wait.wait_to_exist(driver, cart_badge).isDisplayed());
    }

    public void assert_Reset_App_State_is_clickable() {
        Assert.assertTrue(Wait.wait_to_hide(driver, cart_badge));
    }

}
