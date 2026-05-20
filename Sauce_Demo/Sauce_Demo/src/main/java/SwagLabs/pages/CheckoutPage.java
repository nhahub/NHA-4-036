package SwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import SwagLabs.utils.ElementActions;
import org.testng.Assert;


public class CheckoutPage {

    private final WebDriver driver;

    // Locators
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");

    private final By continueBtn = By.id("continue");
    private final By cancelBtn1 = By.id("cancel");

    // constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterCheckoutDetails(String fName, String lName, String zip) {
        ElementActions.send_data(driver, firstName, fName);
        ElementActions.send_data(driver, lastName, lName);
        ElementActions.send_data(driver, postalCode, zip);
    }

    public void clickContinue() {
        ElementActions.click_element(driver, continueBtn);
    }
    public void clickCancel_from_checkOut_step1() {
        ElementActions.click_element(driver, cancelBtn1);
    }

    //Assertion
    public void assert_continueBtn_clickability(){
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.saucedemo.com/checkout-step-two.html"));
    }

    public void assert_CancelBtn_from_checkOut_step1_clickability(){
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.saucedemo.com/cart.html"));
    }
}

