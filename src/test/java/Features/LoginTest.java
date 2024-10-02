package Features;

import Pages.HomePage;
import org.testng.annotations.Test;

public class LoginTest extends TestConfigurations {

    @Test(description = "TC2: Login User with correct email and password")
    public void loginWithCorrectCredentials(){
        new HomePage(driver,sa)
                .assertOnPageTitle("Automation Exercise")
                .clickSignupAndLoginButton()
                .assertOnLoginToYourAccountWord("Login to your account")
                .loginWithValidCredintials("testemad1234@gmail.com","test123")
                .assertOnLoggedInAsdWord("Ahmed");
        System.out.println("Test 2");
    }
    @Test(description = "TC3: Login User with incorrect email and password")
    public void loginWithInCorrectCredentials(){
        new HomePage(driver,sa)
                .assertOnPageTitle("Automation Exercise")
                .clickSignupAndLoginButton()
                .assertOnLoginToYourAccountWord("Login to your account")
                .loginWithInvalidCredintials("invalid@gmail.com","test123")
                .assertOnLoginErrorMsg("Your email or password is incorrect!");
        System.out.println("Test 3");
    }
}