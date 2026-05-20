package SwagLabs.pages;

import SwagLabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutOverviewPage {

    private final WebDriver driver;

    // Locators
    private final By finishBtn = By.id("finish");
    private final By cancelBtn2 = By.id("cancel");
    private final By successMsg = By.className("complete-header");


    // constructor
    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickFinish() {
        ElementActions.click_element(driver, finishBtn);
    }

    public void clickCancel_from_checkOut_step2() {
        ElementActions.click_element(driver, cancelBtn2);
    }

    // Assertion
    public void assert_successful_checkout(){
        Assert.assertTrue(ElementActions.get_txt(driver, successMsg).contains("Thank you for your order"));
    }

    public void assert_CancelBtn_from_checkOut_step2_clickability(){
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.saucedemo.com/inventory.html"));
    }

}
