package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;


public class BaseTest {
    protected WebDriver driver;
     public LoginPage loginPage;

    @BeforeMethod
    public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        // Navigate from BaseTest
        driver.get("https://www.saucedemo.com");

    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }





}
