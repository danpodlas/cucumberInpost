package pl.dpodlaski.GUI.page;

import pl.dpodlaski.GUI.driver.manager.DriverManager;
import pl.dpodlaski.GUI.waits.WaitForElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {

    protected WebDriver driver = DriverManager.getWebDriver();

    protected void click(By by){
        focus(by);
        driver.findElement(by).click();
    }

    protected boolean isVisible(By by){
        return driver.findElement(by).isDisplayed();
    }

    protected String getText(By by){
        return driver.findElement(by).getText();
    }

    protected void sendKeys(By by, String txt){
        focus(by);
        driver.findElement(by).sendKeys(txt);
    }

    protected void focus(By by){
        WaitForElement.waitUntilElementIsVisible(by);
        WebElement element = driver.findElement(by);
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
    }

}
