package Base;

import Utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class TestConfigurations {
     public WebDriver driver;
     public SoftAssert sa;


    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver("Chrome",true);
        sa = new SoftAssert();
        driver.navigate().to("https://automationexercise.com/");
        System.out.println("before method");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
        sa.assertAll();
        System.out.println("after method");
    }
}
