package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class ElementActions {
    public static void elementLocatingStrategy(WebDriver driver,By locator){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
        new Actions(driver).scrollToElement(driver.findElement(locator));
    }
        public static void click(WebDriver driver , By locator ){
            elementLocatingStrategy(driver,locator);
            new WebDriverWait(driver,Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(locator));
            driver.findElement(locator).click();
        }
    public static void type (WebDriver driver, By locator, String text){
        elementLocatingStrategy(driver,locator);
        driver.findElement(locator).sendKeys(text);
    }


}
