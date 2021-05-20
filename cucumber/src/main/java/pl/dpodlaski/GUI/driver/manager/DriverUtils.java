package pl.dpodlaski.GUI.driver.manager;

public class DriverUtils {

    public static void setInitialConfiguration() {
        DriverManager.getWebDriver().manage().window().maximize();
    }

    public static void navigateToPage(String url){
        DriverManager.getWebDriver().navigate().to(url);
    }

}
