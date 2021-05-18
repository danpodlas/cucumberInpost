package GUI;

import GUI.driver.manager.DriverManager;
import GUI.driver.manager.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {


    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("https://inpost.pl/");
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }

}
