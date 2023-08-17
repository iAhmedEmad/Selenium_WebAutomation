package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class AccountDeletedPage {
    private WebDriver driver;
    private SoftAssert softAssert;
    private String url = "https://automationexercise.com/delete_account";

    // Constructor
    public AccountDeletedPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
    }
    // Locators
    private final By accountDeletedText = By.xpath("//b");
    //Actions
    public void navigate(String url){
        driver.navigate().to(url);
    }

    //Validations
    public AccountDeletedPage assertOnAccountDeleted(String expextedString){
        softAssert.assertEquals(driver.findElement(accountDeletedText).getText(), expextedString);
        return this;
    }


}
