package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class SignUpPage {
    private WebDriver driver;
    private SoftAssert softAssert;
    private String url = "https://automationexercise.com/login";

    // Constructor
    public SignUpPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
    }
    // Locators
    private final By newUserName = By.xpath("//input[@type = 'text']");
    private final By newUserEmail = By.xpath("(//input[@type = 'email'])[2]");
    private final By newUserSignupText = By.xpath("//div[@class='signup-form']/h2");
    private final By signupButton = By.xpath("(//button[@type='submit'])[2]");

    // Actions
    public CreateAccountPage newUserSignup(String name) {
        driver.findElement(newUserName).sendKeys(name);
        String currentDate = String.valueOf(System.currentTimeMillis());
        driver.findElement(newUserEmail).sendKeys(name + currentDate + "@test.com");
        driver.findElement(signupButton).click();
        return new CreateAccountPage(driver,softAssert);
    }
    public void navigate(String url){
        driver.navigate().to(url);
    }

    // Validations
    public SignUpPage assertOnNewUserSignupWord(String expextedString) {
        softAssert.assertEquals(driver.findElement(newUserSignupText).getText(), expextedString);
        return this;
    }

}
