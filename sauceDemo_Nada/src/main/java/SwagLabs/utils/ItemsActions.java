package SwagLabs.utils;

import SwagLabs.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static SwagLabs.utils.Scroll.scroll_to_element;
import static SwagLabs.utils.Wait.wait_to_be_clickable;
import static SwagLabs.utils.Wait.wait_to_be_visible;

public class ItemsActions {
    private ItemsActions(){}
    static LoginPage lp;

    public static void send_date(WebDriver driver, By locator, String data){
        wait_to_be_visible(driver, locator);
        scroll_to_element(driver, locator);
        driver.findElement(locator).sendKeys(data);
    }

    public static void clicking(WebDriver driver, By locator){
        wait_to_be_clickable(driver, locator);
        scroll_to_element(driver, locator);
        driver.findElement(locator).click();
    }

    public static String get_txt(WebDriver driver, By locator){
        Wait.wait_to_be_visible(driver, locator);
        Scroll.scroll_to_element(driver, locator);
        return driver.findElement(locator).getText();
    }

    public static void successful_login(WebDriver driver){
        lp = new LoginPage(driver);
        lp.enter_username("standard_user");
        lp.enter_password("secret_sauce");
        lp.click_loginButton();
        lp.assert_successful_Login();
    }

}
