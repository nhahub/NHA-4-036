package SwagLabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wait {
    private Wait(){
        //to prevent instantiations for this class
    }

    //wait for element to exist
    public static WebElement wait_to_exist(WebDriver driver, By locator){
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> driver.findElement(locator));
    }

    // wait for element to hide
    public static Boolean wait_to_hide(WebDriver driver, By locator) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(driver1 -> driver.findElements(locator).isEmpty());
        } catch (TimeoutException e) {
            return false;
        }
    }

    //wait for element to be visible
    public static WebElement wait_to_be_visible(WebDriver driver, By locator){
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 ->
                {
                    WebElement element = wait_to_exist(driver, locator);
                    return element.isDisplayed()? element : null;
                });
    }

    //wait for element to be enabled
    public static WebElement wait_to_be_clickable(WebDriver driver, By locator){
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 ->
        {
            WebElement element = wait_to_be_visible(driver, locator);
            return element.isEnabled()? element : null;
        });
    }
}

