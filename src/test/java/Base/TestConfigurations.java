package Base;

import Utils.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class TestConfigurations {
     public WebDriver driver;
     public SoftAssert sa;
     public ExtentReports extent;


     @BeforeSuite
     public void setUpExtentReport(){
         extent = new ExtentReports();
         ExtentSparkReporter spark = new ExtentSparkReporter("src/test/resources/TestReports/Spark.html");
         spark.config().setTheme(Theme.DARK);
         spark.config().setDocumentTitle("Test Automation Extent Report");
         spark.config().setReportName("Extent Report");
         extent.attachReporter(spark);
     }
    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver("Chrome",true);
        sa = new SoftAssert();
        driver.navigate().to("https://automationexercise.com/");
    }
    @AfterSuite
    public void tearDownExtentReport(){
        extent.flush(); //unless we write this line of code, the report will not be written with logs
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
        sa.assertAll();
    }
}
