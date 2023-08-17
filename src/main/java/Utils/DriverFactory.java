package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    static WebDriver driver ;
    public static WebDriver getDriver(String targetBrowser, boolean maximize) {
        if (targetBrowser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (targetBrowser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (targetBrowser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (maximize)
            driver.manage().window().maximize();
        return driver;
    }
}
