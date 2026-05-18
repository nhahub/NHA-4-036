package SwagLabs.base;

import SwagLabs.pages.LoginPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected WebDriver driver;
    public LoginPage loginPage;

    @BeforeMethod
    public void SetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);

        // Navigate from BaseTest
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }

}
