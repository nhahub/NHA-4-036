package swagLabs.tests;

import SwagLabs.pages.Header;
import SwagLabs.pages.LoginPage;
import SwagLabs.utils.ItemsActions;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest {
    WebDriver driver;
    LoginPage lp;
    Header header;


    @Test(priority = 1)
    public void successful_logo_existence() {
        ItemsActions.successful_login(driver);
        header.assert_logo_exist();
    }

    @Test(priority = 2)
    public void successful_cart_existence_and_clickability() {
        ItemsActions.successful_login(driver);
        header.click_cart_icon();
        header.assert_cart_icon_is_clickable();
    }

    @Test(priority = 3)
    public void successful_burger_menu_existence_and_clickability() {
        ItemsActions.successful_login(driver);
        header.click_burger_menu();
        header.assert_burger_menu_is_clickable();
    }

    @Test(priority = 4)
    public void successful_all_items_existence_and_clickability() {
        ItemsActions.successful_login(driver);
        header.click_cart_icon();
        header.click_burger_menu();
        header.click_AllItems();
        header.assert_All_items_is_clickable();
    }

    @Test(priority = 5)
    public void successful_About_existence_and_clickability() {
        ItemsActions.successful_login(driver);
        header.click_burger_menu();
        header.click_About();
        header.assert_About_is_clickable();
    }

    @Test(priority = 6)
    public void successful_Reset_App_State_existence_and_clickability() {
        ItemsActions.successful_login(driver);
        header.addProductToCart();
        header.assert_cart_badge_exist();
        header.click_burger_menu();
        header.click_ResetAppState();
        header.assert_Reset_App_State_is_clickable();
    }

    //configurations
    @BeforeMethod
    public void setup() {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        lp = new LoginPage(driver);
        header = new Header(driver);
        driver.get("https://www.saucedemo.com/");

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
