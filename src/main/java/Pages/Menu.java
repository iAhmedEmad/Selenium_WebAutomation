package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.net.URL;

public class Menu {
    private WebDriver driver;
    private SoftAssert softAssert;

    public Menu(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
    }

    ////////////////// Locators \\\\\\\\\\\\\\\\\
    private final By loginButton = By.xpath("//a[@href='/login']");
    private final By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    private final By successfulLoginText = By.xpath("(//ul[@class='nav navbar-nav']//a)[10]");

    ///////////////// Actions \\\\\\\\\\\\\\\\\\\\\
    public SignUpPage clickSignupAndLoginButton() {
        driver.findElement(loginButton).click();
        return new SignUpPage(driver,softAssert);
    }
    public AccountDeletedPage deleteAccount() {
        driver.findElement(deleteAccountButton).click();
        return new AccountDeletedPage(driver,softAssert);
    }

    ///////////////// Validations \\\\\\\\\\\\\\\\\\\
    public Menu assertOnLoggedInAsdWord(String expextedString) {
        softAssert.assertEquals(driver.findElement(successfulLoginText).getText(), expextedString);
        return new Menu(driver,softAssert);
    }

}
