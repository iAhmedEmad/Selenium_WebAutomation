package Features;

import Base.TestConfigurations;
import Pages.*;
import Utils.Listeners.CustomIRetryAnalyzer;
import Utils.Listeners.CustomITestListener;
import Utils.JsonFileManager;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomITestListener.class)
public class RegisterUserTest extends TestConfigurations {
    JsonFileManager CLs;
    JsonFileManager newUserData;
    String accountCreatedMsg;
    String accountDeletedMsg;
    String enterAccountInformationWord;
    String pageTitle;
    String newUserSignupWord;
    String firstName;
    String lastName;
    String Company;
    String address1;
    String address2;
    String state;
    String City;
    String zipcode;
    String mobileNumber;



    @BeforeClass
    public void prepareData(){
        // Read Test Data Files
        CLs = new JsonFileManager("src/test/resources/TestData/CLs.json");
        newUserData = new JsonFileManager("src/test/resources/TestData/RegisterNewUser.json");
        // CLs Data
        pageTitle = CLs.getTestData("pageTitle");
        accountCreatedMsg = CLs.getTestData("accountCreatedMsg");
        accountDeletedMsg = CLs.getTestData("accountDeletedMsg");
        newUserSignupWord = CLs.getTestData("newUserSignupWord");
        enterAccountInformationWord = CLs.getTestData("enterAccountInformationWord");
        // New User Data
         firstName = newUserData.getTestData("newUserInfo.firstName");
         lastName = newUserData.getTestData("newUserInfo.lastName");
         Company = newUserData.getTestData("newUserInfo.Company");
         address1 = newUserData.getTestData("newUserInfo.address1");
         address2 = newUserData.getTestData("newUserInfo.address2");
         state = newUserData.getTestData("newUserInfo.state");
         City = newUserData.getTestData("newUserInfo.City");
         zipcode = newUserData.getTestData("newUserInfo.zipcode");
         mobileNumber = newUserData.getTestData("newUserInfo.mobileNumber");
    }

    @Test(description = "TC1: Register User", retryAnalyzer = CustomIRetryAnalyzer.class )
    public void registerUser() {
        new HomePage(driver,sa).
                assertOnPageTitle(pageTitle).
                clickSignupAndLoginButton().
                assertOnNewUserSignupWord(newUserSignupWord).
                newUserSignUp(firstName).
                assertOnEnterAccountInformationWord(enterAccountInformationWord).
                createAccount(firstName,lastName,Company,address1,address2,state,City,zipcode,mobileNumber).
                assertOnAccountCreatedWord(accountCreatedMsg).
                clickContinue().
                assertOnLoggedInAsdWord(firstName).
                clickDeleteAccountButton().
                assertOnAccountDeleted(accountDeletedMsg);

        ExtentTest test = extent.createTest("registerUser Test"); // create a test node in the report
        test.pass("Register User Test started successfully"); // create a test step node in the report
        test.info("URL is loaded");
        test.info("User registration is in progress");
        test.pass("Registration test failed!");
    }
}