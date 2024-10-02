package Pages;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class HomePage {
    private WebDriver driver;
    private SoftAssert softAssert;
    private String url = "https://automationexercise.com/";

    // constructor
    public HomePage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
    }
    // Locators

    // Actions

    public void navigate(){
        driver.navigate().to(url);
    }
    // Validations
    public Dashboard assertOnPageTitle(String expextedString) {
        softAssert.assertEquals(driver.getTitle().trim(), expextedString);
        return new Dashboard(driver,softAssert);
    }

}
