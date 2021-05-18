package GUI.driver.manager;

public class DriverUtils {

    public static void setInitialConfiguration() {
        DriverManager.getWebDriver().manage().window().fullscreen();
    }

    public static void navigateToPage(String url){
        DriverManager.getWebDriver().navigate().to(url);
    }

}
