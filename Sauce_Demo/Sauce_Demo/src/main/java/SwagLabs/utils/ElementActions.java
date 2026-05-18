package SwagLabs.utils;

import SwagLabs.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static SwagLabs.utils.Scroll.scroll_to_element;
import static SwagLabs.utils.Wait.wait_to_be_clickable;
import static SwagLabs.utils.Wait.wait_to_be_visible;

public class ElementActions {
    private ElementActions(){}
    static LoginPage lp;

    public static void send_data(WebDriver driver, By locator, String data){
        wait_to_be_visible(driver, locator);
        scroll_to_element(driver, locator);
        driver.findElement(locator).sendKeys(data);
    }

    public static void click_element(WebDriver driver, By locator){
        wait_to_be_clickable(driver, locator);
        scroll_to_element(driver, locator);
        driver.findElement(locator).click();
    }

    public static String get_txt(WebDriver driver, By locator){
        Wait.wait_to_be_visible(driver, locator);
        Scroll.scroll_to_element(driver, locator);
        return driver.findElement(locator).getText();
    }
}
