package Verifications;

import Pages.*;
import org.testng.annotations.Test;

public class TestCase1 extends TestConfigurations {

    @Test(description = "Test Exercise")
    public void testExercise() {
        new HomePage(driver,sa).
                assertOnPageTitle("Automation Exercise").
                clickSignupAndLoginButton().
                assertOnNewUserSignupWord("New User Signup!").
                newUserSignup("Ahmed").
                assertOnEnterAccountInformationWord("ENTER ACCOUNT INFORMATION").
                createAccount("Ahmed","Emad","_VOIS","here","There","Cairo","Cairo","123","12345678910").
                assertOnAccountCreatedWord("ACCOUNT CREATED!").
                clickContinue().
                assertOnLoggedInAsdWord("Logged in as Ahmed").
                deleteAccount().
                assertOnAccountDeleted("ACCOUNT DELETED!");
    }
}