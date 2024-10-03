package Features;

import Base.TestConfigurations;
import Pages.HomePage;
import Utils.JsonFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

    @Test(description = "TC2: Login User with correct email and password")
    public void loginWithCorrectCredentials(){
        new HomePage(driver,sa)
                .assertOnPageTitle(pageTitle)
                .clickSignupAndLoginButton()
                .assertOnLoginToYourAccountWord(loginToYourAccountWord)
                .loginWithValidCredintials(validEmail,validPassword)
                .assertOnLoggedInAsdWord(userName);
        System.out.println("Test 2");
    }
    @Test(description = "TC3: Login User with incorrect email and password")
    public void loginWithInCorrectCredentials(){
        new HomePage(driver,sa)
                .assertOnPageTitle(pageTitle)
                .clickSignupAndLoginButton()
                .assertOnLoginToYourAccountWord(loginToYourAccountWord)
                .loginWithInvalidCredintials(invalidEmail,invalidPassword)
                .assertOnLoginErrorMsg(loginErrorMsg);
        System.out.println("Test 3");
    }
}