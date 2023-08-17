package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CreateAccountPage {
    private WebDriver driver;
    private SoftAssert softAssert;
    String url = "https://automationexercise.com/signup";

    // Constructor
    public CreateAccountPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
    }
    // Locators
    private final By TitleMrCheck = By.xpath("(//input[@type='radio'])[1]");
    private final By password = By.xpath("//input[@type='password']");
    private final By newsLetterSignUpCheckbox = By.xpath("//input[@type='checkbox']");
    private final By addressInfoFirstName = By.xpath("//input[@id='first_name']");
    private final By addressInfoLastName = By.xpath("//input[@id='last_name']");
    private final By addressInfoCompany = By.xpath("//input[@id='company']");
    private final By addressInfoAddress = By.xpath("//input[@id='address1']");
    private final By addressInfoAddress2 = By.xpath("//input[@id='address2']");
    private final By addressInfoState = By.xpath("//input[@id='state']");
    private final By addressInfoCity = By.xpath("//input[@id='city']");
    private final By addressInfoZipcode = By.xpath("//input[@id='zipcode']");
    private final By addressInfoMobileNumber = By.xpath("//input[@id='mobile_number']");
    private final By dayDropDownMenu = By.xpath("//select[@id='days']");
    private final By daySelected = By.xpath("//select[@id='days']//option[@value='30']");
    private final By monthDropDownMenu = By.xpath("//select[@id='months']");
    private final By monthSelected = By.xpath("//select[@id='months']//option[@value='11']");
    private final By yearDropDownMenu = By.xpath("//select[@id='years']");
    private final By yearSelected = By.xpath("//select[@id='years']//option[@value='1997']");
    private final By createAccountButton = By.xpath("(//button[@type='submit'])[1]");
    private final By enterAccountInformationWord = By.xpath("(//h2[@class='title text-center'])[1]");

    // Actions
    public AccountCreatedSuccessfullyPage createAccount(String firstName, String lastName, String Company, String address1, String address2, String state, String City, String zipcode, String mobileNumber ) {
        driver.findElement(TitleMrCheck).click();
        driver.findElement(this.password).sendKeys(firstName);
        driver.findElement(newsLetterSignUpCheckbox).click();
        driver.findElement(addressInfoFirstName).sendKeys(firstName);
        driver.findElement(addressInfoLastName).sendKeys(lastName);
        driver.findElement(addressInfoCompany).sendKeys(Company);
        driver.findElement(addressInfoAddress).sendKeys(address1);
        driver.findElement(addressInfoAddress2).sendKeys(address2);
        driver.findElement(addressInfoState).sendKeys(state);
        driver.findElement(addressInfoCity).sendKeys(City);
        driver.findElement(addressInfoZipcode).sendKeys(zipcode);
        driver.findElement(addressInfoMobileNumber).sendKeys(mobileNumber);
        driver.findElement(dayDropDownMenu).click();
        driver.findElement(daySelected).click();
        driver.findElement(monthDropDownMenu).click();
        driver.findElement(monthSelected).click();
        driver.findElement(yearDropDownMenu).click();
        driver.findElement(yearSelected).click();
        driver.findElement(createAccountButton).click();
        return new AccountCreatedSuccessfullyPage(driver,softAssert);
    }
    public void navigate(String url){
        driver.navigate().to(url);
    }

    // Validations
    public CreateAccountPage assertOnEnterAccountInformationWord(String expextedString) {
        softAssert.assertEquals(driver.findElement(enterAccountInformationWord).getText(), expextedString);
        return this;
    }

}
