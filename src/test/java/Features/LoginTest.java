package Features;

import Base.TestConfigurations;
import Pages.HomePage;
import Utils.Listeners.CustomIRetryAnalyzer;
import Utils.Listeners.CustomITestListener;
import Utils.JsonFileManager;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomITestListener.class)
public class LoginTest extends TestConfigurations {

    JsonFileManager loinData;
    JsonFileManager CLs;

    String validEmail;
    String validPassword;
    String invalidEmail;
    String invalidPassword;
    String userName;
    String pageTitle;
    String loginToYourAccountWord;
    String loginErrorMsg;

    @BeforeClass
    public void prepareData(){
        // Read Test Data Files
        loinData = new JsonFileManager("src/test/resources/TestData/UserLogin.json");
        CLs = new JsonFileManager("src/test/resources/TestData/CLs.json");
        // Valid Login Data
        validEmail = loinData.getTestData("validCredentials.email");
        validPassword = loinData.getTestData("validCredentials.password");
        userName = loinData.getTestData("validCredentials.username");
        // Invalid Login Data
        invalidEmail = loinData.getTestData("invalidCredentials.email");
        invalidPassword = loinData.getTestData("invalidCredentials.password");
        // CLs Data
        pageTitle = CLs.getTestData("pageTitle");
        loginToYourAccountWord = CLs.getTestData("loginToYourAccountWord");
        loginErrorMsg = CLs.getTestData("loginErrorMsg");
    }

    @Test(description = "TC2: Login User with correct email and password", retryAnalyzer = CustomIRetryAnalyzer.class)
    public void loginWithCorrectCredentials(){
        new HomePage(driver,sa)
                .assertOnPageTitle(pageTitle)
                .clickSignupAndLoginButton()
                .assertOnLoginToYourAccountWord(loginToYourAccountWord)
                .loginWithValidCredintials(validEmail,validPassword)
                .assertOnLoggedInAsdWord(userName);

        ExtentTest test = extent.createTest("loginWithCorrectCredentials Test"); // create a test node in the report
        test.pass("loginWithCorrectCredentials Test started successfully"); // create a test step node in the report
        test.info("URL is loaded");
        test.info("Username and password entered");
        test.pass("Login test passed successfully!");
    }

    @Test(description = "TC3: Login User with incorrect email and password", retryAnalyzer = CustomIRetryAnalyzer.class)
    public void loginWithInCorrectCredentials(){
        new HomePage(driver,sa)
                .assertOnPageTitle(pageTitle)
                .clickSignupAndLoginButton()
                .assertOnLoginToYourAccountWord(loginToYourAccountWord)
                .loginWithInvalidCredintials(invalidEmail,invalidPassword)
                .assertOnLoginErrorMsg(loginErrorMsg);

        ExtentTest test = extent.createTest("loginWithInCorrectCredentials Test"); // create a test node in the report
        test.pass("loginWithInCorrectCredentials Test started successfully"); // create a test step node in the report
        test.info("URL is loaded");
        test.info("User login is in progress");
        test.fail("Loin test failed!");
    }
}