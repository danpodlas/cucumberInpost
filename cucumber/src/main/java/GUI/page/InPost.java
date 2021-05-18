package GUI.page;

import GUI.driver.manager.DriverManager;
import GUI.waits.WaitForElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InPost {

    private static final By BUTTON = By.xpath("//*[@class='btncontainer']//button");
    WebElement e = DriverManager.getWebDriver().findElement(BUTTON);

    public boolean isInputSearchDisplayed() {
        WaitForElement.waitUntilElementIsVisible(BUTTON);
        return e.isDisplayed();
    }

}
