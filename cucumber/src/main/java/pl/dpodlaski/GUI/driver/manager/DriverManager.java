package pl.dpodlaski.GUI.driver.manager;

import pl.dpodlaski.GUI.driver.BrowserFactory;
import pl.dpodlaski.GUI.driver.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static final BrowserType BROWSER_TYPE = BrowserType.CHROME;
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = BrowserFactory.getBrowser(BROWSER_TYPE);
        }
        return driver;
    }

    public static void disposeDriver() {

        driver.close();
        if(!BROWSER_TYPE.equals(BrowserType.FIREFOX)){
            driver.quit();
        }
        driver=null;

    }

}
