package Verifications;

import Utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class TestConfigurations {
     WebDriver driver;
     SoftAssert sa;
    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver("Chrome",true);
        sa = new SoftAssert();
        driver.navigate().to("https://automationexercise.com/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() {
        sa.assertAll();
        driver.quit();
    }
}
