package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class Dashboard {
    private WebDriver driver;
    private SoftAssert softAssert;

    public Dashboard(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
    }

    ////////////////// Locators \\\\\\\\\\\\\\\\\
    private final By loginButton = By.xpath("//a[@href='/login']");
    private final By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    private final By successfulLoginText = By.xpath("(//ul[@class='nav navbar-nav']//a)[10]/b");

    ///////////////// Actions \\\\\\\\\\\\\\\\\\\\\
    public SignUpAndLoginPage clickSignupAndLoginButton() {
        driver.findElement(loginButton).click();
        return new SignUpAndLoginPage(driver,softAssert);
    }
    public AccountDeletedPage clickDeleteAccountButton() {
        driver.findElement(deleteAccountButton).click();
        return new AccountDeletedPage(driver,softAssert);
    }

    ///////////////// Validations \\\\\\\\\\\\\\\\\\\
    public Dashboard assertOnLoggedInAsdWord(String expextedString) {
        softAssert.assertEquals(driver.findElement(successfulLoginText).getText(), expextedString);
        return new Dashboard(driver,softAssert);
    }

}
