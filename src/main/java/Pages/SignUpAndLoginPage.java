package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class SignUpAndLoginPage {
    private WebDriver driver;
    private SoftAssert softAssert;
    private String url = "https://automationexercise.com/login";

    // Constructor
    public SignUpAndLoginPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
    }
    // Locators
    private final By newUserName = By.xpath("//input[@type = 'text']");
    private final By newUserEmail = By.xpath("(//input[@type = 'email'])[2]");
    private final By newUserSignupText = By.xpath("//div[@class='signup-form']/h2");
    private final By loginToYourAccountText = By.xpath("//div[@class='login-form']/h2");
    private final By loginErrorMsg = By.xpath("//p[@style='color: red;']");
    private final By signupButton = By.xpath("(//button[@type='submit'])[2]");
    private final By emailTextField = By.xpath("(//input[@type='email'])[1]");
    private final By passwordTextField = By.xpath("(//input[@type='password'])[1]");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");

    // Actions
    public CreateAccountPage newUserSignUp(String name) {
        driver.findElement(newUserName).sendKeys(name);
        String currentDate = String.valueOf(System.currentTimeMillis());
        driver.findElement(newUserEmail).sendKeys(name + currentDate + "@test.com");
        driver.findElement(signupButton).click();
        return new CreateAccountPage(driver,softAssert);
    }
    public void navigate(String url){
        driver.navigate().to(url);
    }
    public Dashboard loginWithValidCredintials(String userName, String password){
        driver.findElement(emailTextField).sendKeys(userName);
        driver.findElement(passwordTextField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new Dashboard(driver,softAssert);
    }
    public SignUpAndLoginPage loginWithInvalidCredintials(String userName, String password){
        driver.findElement(emailTextField).sendKeys(userName);
        driver.findElement(passwordTextField).sendKeys(password);
        driver.findElement(loginButton).click();
        return this;
    }

    // Validations
    public SignUpAndLoginPage assertOnNewUserSignupWord(String expextedString) {
        softAssert.assertEquals(driver.findElement(newUserSignupText).getText(), expextedString);
        return this;
    }
    public SignUpAndLoginPage assertOnLoginToYourAccountWord(String expextedString) {
        softAssert.assertEquals(driver.findElement(loginToYourAccountText).getText(), expextedString);
//        assert driver.findElement(By.id("")).isDisplayed();
        return this;
    }
    public SignUpAndLoginPage assertOnLoginErrorMsg(String expextedString) {
        softAssert.assertEquals(driver.findElement(loginErrorMsg).getText(), expextedString);
//        assert driver.findElement(By.id("")).isDisplayed();
        return this;
    }

}
