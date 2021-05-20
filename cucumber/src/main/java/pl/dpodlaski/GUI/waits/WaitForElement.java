package pl.dpodlaski.GUI.waits;

import pl.dpodlaski.GUI.driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitForElement {

    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(DriverManager.getWebDriver(), TimeUnit.SECONDS.toSeconds(15));
    }

    public static void waitUntilElementIsVisible(WebElement webElement) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitUntilElementIsClickable(WebElement webElement) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public static void waitUntilElementIsVisible(By by) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitUntilElementIsClickable(By by) {
        WebElement element = DriverManager.getWebDriver().findElement(by);
        ((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

}
