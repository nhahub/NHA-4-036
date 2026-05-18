package SwagLabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scroll {

    private Scroll(){
        //to prevent instantiations for this class
    }

    public static void scroll_to_element(WebDriver driver, By locator){
        ((JavascriptExecutor ) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(locator));
    }
}
