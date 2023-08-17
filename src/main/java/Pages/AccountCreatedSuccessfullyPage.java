package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class AccountCreatedSuccessfullyPage {
    private WebDriver driver;
    private SoftAssert softAssert;
    private String url = "https://automationexercise.com/account_created";

    // Constructor
    public AccountCreatedSuccessfullyPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
    }
    // Locators
    private final By accountCreatedText = By.xpath("//b");
    private final By continueAfterAccountCreated = By.xpath("(//a[@href='/'])[3]");
    // Actions
    public Menu clickContinue() {
        driver.findElement(continueAfterAccountCreated).click();
        return new Menu(driver,softAssert);
    }
    public void navigate(String url){
        driver.navigate().to(url);
    }
    // Validations
    public AccountCreatedSuccessfullyPage assertOnAccountCreatedWord(String expextedString) {
        softAssert.assertEquals(driver.findElement(accountCreatedText).getText(), expextedString);
        return this;
    }
}
