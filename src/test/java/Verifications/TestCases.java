package Verifications;

import Pages.*;
import org.testng.annotations.Test;

public class TestCases extends TestConfigurations {

    @Test(description = "TC1: Register User")
    public void registerUser() {
        new HomePage(driver,sa).
                assertOnPageTitle("Automation Exercise").
                clickSignupAndLoginButton().
                assertOnNewUserSignupWord("New User Signup!").
                newUserSignUp("Ahmed").
                assertOnEnterAccountInformationWord("ENTER ACCOUNT INFORMATION").
                createAccount("Ahmed","Emad","_VOIS","here","There","Cairo","Cairo","123","12345678910").
                assertOnAccountCreatedWord("ACCOUNT CREATED!").
                clickContinue().
                assertOnLoggedInAsdWord("Ahmed").
                clickDeleteAccountButton().
                assertOnAccountDeleted("ACCOUNT DELETED!");
        System.out.println("Test 1");
    }
    @Test(description = "TC2: Login User with correct email and password")
    public void loginWithCorrectCredentials(){
        new HomePage(driver,sa)
                .assertOnPageTitle("Automation Exercise")
                .clickSignupAndLoginButton()
                .assertOnLoginToYourAccountWord("Login to your account")
                .login("testemad1234@gmail.com","test123")
                .assertOnLoggedInAsdWord("Ahmed");
        System.out.println("Test 2");
    }


//

}