package pl.dpodlaski.GUI.page;

import pl.dpodlaski.GUI.driver.manager.DriverManager;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class DetailsOfOfferPage extends Page{

    public static final By BUTTON_APPLY = By.xpath("//div[4]/a/img");

    public ERecruiterPage clickApply() {
        ArrayList<String> tabs2 = new ArrayList<String> (DriverManager.getWebDriver().getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        click(BUTTON_APPLY);

        return new ERecruiterPage();
    }

}

